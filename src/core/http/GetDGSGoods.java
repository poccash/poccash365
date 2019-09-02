package core.http;

import core.Pc365Exception;
import core.DigitalGoodsStore;
import core.http.common.Parameters;
import core.services.DGSGoodsStoreService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

import static core.http.common.Parameters.*;
import static core.http.common.ResultFields.GOODS_RESPONSE;

public final class GetDGSGoods extends APIServlet.JsonRequestHandler {

  private final DGSGoodsStoreService digitalGoodsStoreService;

  public GetDGSGoods(DGSGoodsStoreService digitalGoodsStoreService) {
    super(new APITag[] {APITag.DGS}, SELLER_PARAMETER, FIRST_INDEX_PARAMETER, LAST_INDEX_PARAMETER, IN_STOCK_ONLY_PARAMETER);
    this.digitalGoodsStoreService = digitalGoodsStoreService;
  }

  @Override
  JsonElement processRequest(HttpServletRequest req) throws Pc365Exception {
    long sellerId = ParameterParser.getSellerId(req);
    int firstIndex = ParameterParser.getFirstIndex(req);
    int lastIndex = ParameterParser.getLastIndex(req);
    boolean inStockOnly = !Parameters.isFalse(req.getParameter(IN_STOCK_ONLY_PARAMETER));

    JsonObject response = new JsonObject();
    JsonArray goodsJSON = new JsonArray();
    response.add(GOODS_RESPONSE, goodsJSON);

    Collection<DigitalGoodsStore.Goods> goods = null;
    if (sellerId == 0) {
      if (inStockOnly) {
        goods = digitalGoodsStoreService.getGoodsInStock(firstIndex, lastIndex);
      } else {
        goods = digitalGoodsStoreService.getAllGoods(firstIndex, lastIndex);
      }
    } else {
      goods = digitalGoodsStoreService.getSellerGoods(sellerId, inStockOnly, firstIndex, lastIndex);
    }
    for (DigitalGoodsStore.Goods good : goods) {
      goodsJSON.add(JSONData.goods(good));
    }

    return response;
  }

}
