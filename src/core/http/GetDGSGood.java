package core.http;

import core.Pc365Exception;
import core.services.ParameterService;
import com.google.gson.JsonElement;

import javax.servlet.http.HttpServletRequest;

import static core.http.common.Parameters.GOODS_PARAMETER;

public final class GetDGSGood extends APIServlet.JsonRequestHandler {

  private final ParameterService parameterService;

  GetDGSGood(ParameterService parameterService) {
    super(new APITag[] {APITag.DGS}, GOODS_PARAMETER);
    this.parameterService = parameterService;
  }

  @Override
  JsonElement processRequest(HttpServletRequest req) throws Pc365Exception {
    return JSONData.goods(parameterService.getGoods(req));
  }

}
