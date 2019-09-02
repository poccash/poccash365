package core.http;

import core.Account;
import core.Blockchain;
import core.Pc365Exception;
import core.services.ParameterService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;

import static core.http.common.Parameters.ACCOUNT_PARAMETER;
import static core.http.common.Parameters.HEIGHT_PARAMETER;
import static core.http.common.ResultFields.*;

/**
 * @deprecated This call does nothing. It always returns an empty array.
 */
@Deprecated
public final class GetAccountLessors extends APIServlet.JsonRequestHandler {

  private final ParameterService parameterService;
  private final Blockchain blockchain;

  GetAccountLessors(ParameterService parameterService, Blockchain blockchain) {
    super(new APITag[]{APITag.ACCOUNTS}, ACCOUNT_PARAMETER, HEIGHT_PARAMETER);
    this.parameterService = parameterService;
    this.blockchain = blockchain;
  }

  @Override
  JsonElement processRequest(HttpServletRequest req) throws Pc365Exception {

    Account account = parameterService.getAccount(req);
    int height = parameterService.getHeight(req);
    if (height < 0) {
      height = blockchain.getHeight();
    }

    JsonObject response = new JsonObject();
    JSONData.putAccount(response, ACCOUNT_RESPONSE, account.getId());
    response.addProperty(HEIGHT_RESPONSE, height);
    JsonArray lessorsJSON = new JsonArray();

    response.add(LESSORS_RESPONSE, lessorsJSON);
    return response;
  }
}
