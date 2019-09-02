package core.http;

import core.Pc365Exception;
import core.Order;
import core.assetexchange.AssetExchange;
import core.services.ParameterService;
import core.util.Convert;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;

import static core.http.common.Parameters.*;
import static core.http.common.ResultFields.ASK_ORDER_IDS_RESPONSE;

public final class GetAskOrderIds extends APIServlet.JsonRequestHandler {

  private final ParameterService parameterService;
  private final AssetExchange assetExchange;

  GetAskOrderIds(ParameterService parameterService, AssetExchange assetExchange) {
    super(new APITag[]{APITag.AE}, ASSET_PARAMETER, FIRST_INDEX_PARAMETER, LAST_INDEX_PARAMETER);
    this.parameterService = parameterService;
    this.assetExchange = assetExchange;
  }

  @Override
  JsonElement processRequest(HttpServletRequest req) throws Pc365Exception {

    long assetId = parameterService.getAsset(req).getId();
    int firstIndex = ParameterParser.getFirstIndex(req);
    int lastIndex = ParameterParser.getLastIndex(req);

    JsonArray orderIds = new JsonArray();
    for (Order.Ask askOrder : assetExchange.getSortedAskOrders(assetId, firstIndex, lastIndex)) {
      orderIds.add(Convert.toUnsignedLong(askOrder.getId()));
    }

    JsonObject response = new JsonObject();
    response.add(ASK_ORDER_IDS_RESPONSE, orderIds);
    return response;
  }
}
