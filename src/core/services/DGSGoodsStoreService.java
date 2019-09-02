package core.services;

import core.Appendix;
import core.Attachment;
import core.DigitalGoodsStore.Event;
import core.DigitalGoodsStore.Goods;
import core.DigitalGoodsStore.Purchase;
import core.Transaction;
import core.util.Listener;

import java.util.Collection;

public interface DGSGoodsStoreService { // TODO Redundant name!

  boolean addGoodsListener(Listener<Goods> listener, Event eventType);

  boolean removeGoodsListener(Listener<Goods> listener, Event eventType);

  boolean addPurchaseListener(Listener<Purchase> listener, Event eventType);

  boolean removePurchaseListener(Listener<Purchase> listener, Event eventType);

  Goods getGoods(long goodsId);

  Collection<Goods> getAllGoods(int from, int to);

  Collection<Goods> getGoodsInStock(int from, int to);

  Collection<Goods> getSellerGoods(long sellerId, boolean inStockOnly, int from, int to);

  Collection<Purchase> getAllPurchases(int from, int to);

  Collection<Purchase> getSellerPurchases(long sellerId, int from, int to);

  Collection<Purchase> getBuyerPurchases(long buyerId, int from, int to);

  Collection<Purchase> getSellerBuyerPurchases(long sellerId, long buyerId, int from, int to);

  Collection<Purchase> getPendingSellerPurchases(long sellerId, int from, int to);

  Purchase getPurchase(long purchaseId);

  void changeQuantity(long goodsId, int deltaQuantity, boolean allowDelisted);

  void purchase(Transaction transaction, Attachment.DigitalGoodsPurchase attachment);

  void addPurchase(Transaction transaction, Attachment.DigitalGoodsPurchase attachment, long sellerId);

  void listGoods(Transaction transaction, Attachment.DigitalGoodsListing attachment);

  void delistGoods(long goodsId);

  void feedback(long purchaseId, Appendix.EncryptedMessage encryptedMessage, Appendix.Message message);

  void refund(long sellerId, long purchaseId, long refundNQT, Appendix.EncryptedMessage encryptedMessage);

  Collection<Purchase> getExpiredPendingPurchases(int timestamp);

  void changePrice(long goodsId, long priceNQT);

  void deliver(Transaction transaction, Attachment.DigitalGoodsDelivery attachment);

  Purchase getPendingPurchase(long purchaseId);

  void setPending(Purchase purchase, boolean pendingValue);
}
