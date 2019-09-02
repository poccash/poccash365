package core.http;

import core.Pc365Exception;
import core.services.ParameterService;
import com.google.gson.JsonElement;

import javax.servlet.http.HttpServletRequest;

import static core.http.common.Parameters.PURCHASE_PARAMETER;

public final class GetDGSPurchase extends APIServlet.JsonRequestHandler {

  private final ParameterService parameterService;

  public GetDGSPurchase(ParameterService parameterService) {
    super(new APITag[] {APITag.DGS}, PURCHASE_PARAMETER);
    this.parameterService = parameterService;
  }

  @Override
  JsonElement processRequest(HttpServletRequest req) throws Pc365Exception {
    return JSONData.purchase(parameterService.getPurchase(req));
  }

}
