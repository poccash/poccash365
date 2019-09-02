package core.http;

import core.Account;
import core.Asset;
import core.Pc365Exception;
import core.Trade;
import core.assetexchange.AssetExchange;
import core.http.common.Parameters;
import core.services.ParameterService;
import core.util.Convert;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

import static core.http.common.Parameters.*;
import static core.http.common.ResultFields.TRADES_RESPONSE;

public final class GetTrades extends APIServlet.JsonRequestHandler {

  private final ParameterService parameterService;
  private final AssetExchange assetExchange;

  GetTrades(ParameterService parameterService, AssetExchange assetExchange) {
    super(new APITag[] {APITag.AE}, ASSET_PARAMETER, ACCOUNT_PARAMETER, FIRST_INDEX_PARAMETER, LAST_INDEX_PARAMETER, INCLUDE_ASSET_INFO_PARAMETER);
    this.parameterService = parameterService;
    this.assetExchange = assetExchange;
  }

  @Override
  JsonElement processRequest(HttpServletRequest req) throws Pc365Exception {

    String assetId = Convert.emptyToNull(req.getParameter(ASSET_PARAMETER));
    String accountId = Convert.emptyToNull(req.getParameter(ACCOUNT_PARAMETER));

    int firstIndex = ParameterParser.getFirstIndex(req);
    int lastIndex = ParameterParser.getLastIndex(req);
    boolean includeAssetInfo = !Parameters.isFalse(req.getParameter(INCLUDE_ASSET_INFO_PARAMETER));

    JsonObject response = new JsonObject();
    JsonArray tradesData = new JsonArray();
    Collection<Trade> trades;
    if (accountId == null) {
      Asset asset = parameterService.getAsset(req);
      trades = assetExchange.getTrades(asset.getId(), firstIndex, lastIndex);
    } else if (assetId == null) {
      Account account = parameterService.getAccount(req);
      trades = assetExchange.getAccountTrades(account.getId(), firstIndex, lastIndex);
    } else {
      Asset asset = parameterService.getAsset(req);
      Account account = parameterService.getAccount(req);
      trades = assetExchange.getAccountAssetTrades(account.getId(), asset.getId(), firstIndex, lastIndex);
    }
    for (Trade trade : trades) {
      final Asset asset = includeAssetInfo ? assetExchange.getAsset(trade.getAssetId()) : null;
      tradesData.add(JSONData.trade(trade, asset));
    }
    response.add(TRADES_RESPONSE, tradesData);

    return response;
  }
}
