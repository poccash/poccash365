package core.http;

import core.Pc365Exception;
import core.services.AccountService;
import core.services.ParameterService;
import com.google.gson.JsonElement;

import javax.servlet.http.HttpServletRequest;

import static core.http.common.Parameters.AT_PARAMETER;

final class GetAT extends APIServlet.JsonRequestHandler {

  private final ParameterService parameterService;
  private final AccountService accountService;

  GetAT(ParameterService parameterService, AccountService accountService) {
    super(new APITag[]{APITag.AT}, AT_PARAMETER);
    this.parameterService = parameterService;
    this.accountService = accountService;
  }

  @Override
  JsonElement processRequest(HttpServletRequest req) throws Pc365Exception {
    return JSONData.at(parameterService.getAT(req), accountService);
  }

}
