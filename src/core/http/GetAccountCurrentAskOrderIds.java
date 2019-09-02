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
import java.util.Collection;

import static core.http.common.Parameters.*;
import static core.http.common.ResultFields.ASK_ORDER_IDS_RESPONSE;

public final class GetAccountCurrentAskOrderIds extends APIServlet.JsonRequestHandler {

  private final ParameterService parameterService;
  private final AssetExchange assetExchange;

  GetAccountCurrentAskOrderIds(ParameterService parameterService, AssetExchange assetExchange) {
    super(new APITag[]{APITag.ACCOUNTS, APITag.AE}, ACCOUNT_PARAMETER, ASSET_PARAMETER, FIRST_INDEX_PARAMETER, LAST_INDEX_PARAMETER);
    this.parameterService = parameterService;
    this.assetExchange = assetExchange;
  }

  @Override
  JsonElement processRequest(HttpServletRequest req) throws Pc365Exception {
    long accountId = parameterService.getAccount(req).getId();
    long assetId = 0;
    try {
      assetId = Convert.parseUnsignedLong(req.getParameter(ASSET_PARAMETER));
    } catch (RuntimeException e) {
      // ignore
    }
    int firstIndex = ParameterParser.getFirstIndex(req);
    int lastIndex = ParameterParser.getLastIndex(req);

    Collection<Order.Ask> askOrders;
    if (assetId == 0) {
      askOrders = assetExchange.getAskOrdersByAccount(accountId, firstIndex, lastIndex);
    } else {
      askOrders = assetExchange.getAskOrdersByAccountAsset(accountId, assetId, firstIndex, lastIndex);
    }
    JsonArray orderIds = new JsonArray();
    for (Order.Ask askOrder : askOrders) {
      orderIds.add(Convert.toUnsignedLong(askOrder.getId()));
    }
    JsonObject response = new JsonObject();
    response.add(ASK_ORDER_IDS_RESPONSE, orderIds);
    return response;
  }

}
