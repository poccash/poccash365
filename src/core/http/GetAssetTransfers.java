package core.http;

import core.Account;
import core.Asset;
import core.AssetTransfer;
import core.Pc365Exception;
import core.assetexchange.AssetExchange;
import core.http.common.Parameters;
import core.services.AccountService;
import core.services.ParameterService;
import core.util.Convert;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

import static core.http.common.Parameters.*;
import static core.http.common.ResultFields.TRANSFERS_RESPONSE;

public final class GetAssetTransfers extends APIServlet.JsonRequestHandler {

  private final ParameterService parameterService;
  private final AccountService accountService;
  private final AssetExchange assetExchange;

  GetAssetTransfers(ParameterService parameterService, AccountService accountService, AssetExchange assetExchange) {
    super(new APITag[]{APITag.AE}, ASSET_PARAMETER, ACCOUNT_PARAMETER, FIRST_INDEX_PARAMETER, LAST_INDEX_PARAMETER, INCLUDE_ASSET_INFO_PARAMETER);
    this.parameterService = parameterService;
    this.accountService = accountService;
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
    JsonArray transfersData = new JsonArray();
    Collection<AssetTransfer> transfers;
    if (accountId == null) {
      Asset asset = parameterService.getAsset(req);
      transfers = assetExchange.getAssetTransfers(asset.getId(), firstIndex, lastIndex);
    } else if (assetId == null) {
      Account account = parameterService.getAccount(req);
      transfers = accountService.getAssetTransfers(account.getId(), firstIndex, lastIndex);
    } else {
      Asset asset = parameterService.getAsset(req);
      Account account = parameterService.getAccount(req);
      transfers = assetExchange.getAccountAssetTransfers(account.getId(), asset.getId(), firstIndex, lastIndex);
    }
    for (AssetTransfer transfer : transfers) {
      final Asset asset = includeAssetInfo ? assetExchange.getAsset(transfer.getAssetId()) : null;
      transfersData.add(JSONData.assetTransfer(transfer, asset));
    }

    response.add(TRANSFERS_RESPONSE, transfersData);

    return response;
  }
}
