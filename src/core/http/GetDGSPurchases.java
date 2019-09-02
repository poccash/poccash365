package core.http;

import core.Pc365Exception;
import core.DigitalGoodsStore;
import core.http.common.Parameters;
import core.services.DGSGoodsStoreService;
import core.util.FilteringIterator;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

import static core.http.common.Parameters.*;
import static core.http.common.ResultFields.PURCHASES_RESPONSE;

public final class GetDGSPurchases extends APIServlet.JsonRequestHandler {

  private final DGSGoodsStoreService dgsGoodsStoreService;

  public GetDGSPurchases(DGSGoodsStoreService dgsGoodsStoreService) {
    super(new APITag[] {APITag.DGS}, SELLER_PARAMETER, BUYER_PARAMETER, FIRST_INDEX_PARAMETER, LAST_INDEX_PARAMETER, COMPLETED_PARAMETER);
    this.dgsGoodsStoreService = dgsGoodsStoreService;
  }

  @Override
  JsonElement processRequest(HttpServletRequest req) throws Pc365Exception {
    long sellerId = ParameterParser.getSellerId(req);
    long buyerId = ParameterParser.getBuyerId(req);
    int firstIndex = ParameterParser.getFirstIndex(req);
    int lastIndex = ParameterParser.getLastIndex(req);
    final boolean completed = Parameters.isTrue(req.getParameter(COMPLETED_PARAMETER));


    JsonObject response = new JsonObject();
    JsonArray purchasesJSON = new JsonArray();
    response.add(PURCHASES_RESPONSE, purchasesJSON);

    if (sellerId == 0 && buyerId == 0) {
      FilteringIterator<DigitalGoodsStore.Purchase> purchaseIterator = new FilteringIterator<>(dgsGoodsStoreService.getAllPurchases(0, -1), purchase -> ! (completed && purchase.isPending()), firstIndex, lastIndex);
      while (purchaseIterator.hasNext()) {
        purchasesJSON.add(JSONData.purchase(purchaseIterator.next()));
      }
      return response;
    }

    Collection<DigitalGoodsStore.Purchase> purchases;
    if (sellerId != 0 && buyerId == 0) {
      purchases = dgsGoodsStoreService.getSellerPurchases(sellerId, 0, -1);
    } else if (sellerId == 0) {
      purchases = dgsGoodsStoreService.getBuyerPurchases(buyerId, 0, -1);
    } else {
      purchases = dgsGoodsStoreService.getSellerBuyerPurchases(sellerId, buyerId, 0, -1);
    }
    FilteringIterator<DigitalGoodsStore.Purchase> purchaseIterator = new FilteringIterator<>(purchases, purchase -> ! (completed && purchase.isPending()), firstIndex, lastIndex);
    while (purchaseIterator.hasNext()) {
      purchasesJSON.add(JSONData.purchase(purchaseIterator.next()));
    }
    return response;
  }
}
