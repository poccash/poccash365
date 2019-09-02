package core.http;

import core.Account;
import core.Pc365Exception;
import core.services.ParameterService;
import core.util.Convert;
import core.util.JSON;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;

import static core.http.common.Parameters.ACCOUNT_PARAMETER;
import static core.http.common.ResultFields.PUBLIC_KEY_RESPONSE;

public final class GetAccountPublicKey extends APIServlet.JsonRequestHandler {

  private final ParameterService parameterService;

  GetAccountPublicKey(ParameterService parameterService) {
    super(new APITag[] {APITag.ACCOUNTS}, ACCOUNT_PARAMETER);
    this.parameterService = parameterService;
  }

  @Override
  JsonElement processRequest(HttpServletRequest req) throws Pc365Exception {

    Account account = parameterService.getAccount(req);

    if (account.getPublicKey() != null) {
      JsonObject response = new JsonObject();
      response.addProperty(PUBLIC_KEY_RESPONSE, Convert.toHexString(account.getPublicKey()));
      return response;
    } else {
      return JSON.emptyJSON;
    }
  }

}
