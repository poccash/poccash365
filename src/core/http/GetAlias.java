package core.http;

import core.Alias;
import core.Alias.Offer;
import core.services.AliasService;
import core.services.ParameterService;
import com.google.gson.JsonElement;

import javax.servlet.http.HttpServletRequest;

import static core.http.common.Parameters.ALIAS_NAME_PARAMETER;
import static core.http.common.Parameters.ALIAS_PARAMETER;

public final class GetAlias extends APIServlet.JsonRequestHandler {

  private final ParameterService parameterService;
  private final AliasService aliasService;

  GetAlias(ParameterService parameterService, AliasService aliasService) {
    super(new APITag[] {APITag.ALIASES}, ALIAS_PARAMETER, ALIAS_NAME_PARAMETER);
    this.parameterService = parameterService;
    this.aliasService = aliasService;
  }

  @Override
  JsonElement processRequest(HttpServletRequest req) throws ParameterException {
    final Alias alias = parameterService.getAlias(req);
    final Offer offer = aliasService.getOffer(alias);

    return JSONData.alias(alias, offer);
  }

}
