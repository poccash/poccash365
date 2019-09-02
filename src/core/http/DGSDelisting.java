package core.http;

import core.*;
import core.services.ParameterService;
import com.google.gson.JsonElement;

import javax.servlet.http.HttpServletRequest;

import static core.http.JSONResponses.UNKNOWN_GOODS;
import static core.http.common.Parameters.GOODS_PARAMETER;

public final class DGSDelisting extends CreateTransaction {

  private final ParameterService parameterService;
  private final Blockchain blockchain;

  public DGSDelisting(ParameterService parameterService, Blockchain blockchain, APITransactionManager apiTransactionManager) {
    super(new APITag[]{APITag.DGS, APITag.CREATE_TRANSACTION}, apiTransactionManager, GOODS_PARAMETER);
    this.parameterService = parameterService;
    this.blockchain = blockchain;
  }

  @Override
  JsonElement processRequest(HttpServletRequest req) throws Pc365Exception {
    Account account = parameterService.getSenderAccount(req);
    DigitalGoodsStore.Goods goods = parameterService.getGoods(req);
    if (goods.isDelisted() || goods.getSellerId() != account.getId()) {
      return UNKNOWN_GOODS;
    }
    Attachment attachment = new Attachment.DigitalGoodsDelisting(goods.getId(), blockchain.getHeight());
    return createTransaction(req, account, attachment);
  }

}
