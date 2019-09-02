package core.http;

import core.Alias;
import core.Alias.Offer;
import core.Pc365Exception;
import core.services.AliasService;
import core.services.ParameterService;
import core.util.FilteringIterator;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;

import static core.http.common.Parameters.*;
import static core.http.common.ResultFields.ALIASES_RESPONSE;

public final class GetAliases extends APIServlet.JsonRequestHandler {

  private final ParameterService parameterService;
  private final AliasService aliasService;

  GetAliases(ParameterService parameterService, AliasService aliasService) {
    super(new APITag[]{APITag.ALIASES}, TIMESTAMP_PARAMETER, ACCOUNT_PARAMETER, FIRST_INDEX_PARAMETER, LAST_INDEX_PARAMETER);
    this.parameterService = parameterService;
    this.aliasService = aliasService;
  }

  @Override
  JsonElement processRequest(HttpServletRequest req) throws Pc365Exception {
    final int timestamp = ParameterParser.getTimestamp(req);
    final long accountId = parameterService.getAccount(req).getId();
    int firstIndex = ParameterParser.getFirstIndex(req);
    int lastIndex = ParameterParser.getLastIndex(req);

    JsonArray aliases = new JsonArray();
    FilteringIterator<Alias> aliasIterator = new FilteringIterator<>(aliasService.getAliasesByOwner(accountId, 0, -1), alias -> alias.getTimestamp() >= timestamp, firstIndex, lastIndex);
    while (aliasIterator.hasNext()) {
      final Alias alias = aliasIterator.next();
      final Offer offer = aliasService.getOffer(alias);
      aliases.add(JSONData.alias(alias, offer));
    }

    JsonObject response = new JsonObject();
    response.add(ALIASES_RESPONSE, aliases);
    return response;
  }

}
