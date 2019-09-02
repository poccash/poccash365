package core.http;

import core.*;
import core.assetexchange.AssetExchange;
import core.services.ParameterService;
import com.google.gson.JsonElement;

import javax.servlet.http.HttpServletRequest;

import static core.http.JSONResponses.UNKNOWN_ORDER;
import static core.http.common.Parameters.ORDER_PARAMETER;

public final class CancelAskOrder extends CreateTransaction {

  private final ParameterService parameterService;
  private final Blockchain blockchain;
  private final AssetExchange assetExchange;

  public CancelAskOrder(ParameterService parameterService, Blockchain blockchain, AssetExchange assetExchange, APITransactionManager apiTransactionManager) {
    super(new APITag[]{APITag.AE, APITag.CREATE_TRANSACTION}, apiTransactionManager, ORDER_PARAMETER);
    this.parameterService = parameterService;
    this.blockchain = blockchain;
    this.assetExchange = assetExchange;
  }

  @Override
  JsonElement processRequest(HttpServletRequest req) throws Pc365Exception {
    long orderId = ParameterParser.getOrderId(req);
    Account account = parameterService.getSenderAccount(req);
    Order.Ask orderData = assetExchange.getAskOrder(orderId);
    if (orderData == null || orderData.getAccountId() != account.getId()) {
      return UNKNOWN_ORDER;
    }
    Attachment attachment = new Attachment.ColoredCoinsAskOrderCancellation(orderId, blockchain.getHeight());
    return createTransaction(req, account, attachment);
  }

}
