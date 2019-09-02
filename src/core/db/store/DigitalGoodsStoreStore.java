package core.db.store;

import core.DigitalGoodsStore;
import core.crypto.EncryptedData;
import core.db.Pc365Key;
import core.db.VersionedEntityTable;
import core.db.VersionedValuesTable;

import java.util.Collection;

public interface DigitalGoodsStoreStore {

  Pc365Key.LongKeyFactory<DigitalGoodsStore.Purchase> getFeedbackDbKeyFactory();

  Pc365Key.LongKeyFactory<DigitalGoodsStore.Purchase> getPurchaseDbKeyFactory();

  VersionedEntityTable<DigitalGoodsStore.Purchase> getPurchaseTable();

  VersionedValuesTable<DigitalGoodsStore.Purchase, EncryptedData> getFeedbackTable();

  Pc365Key.LongKeyFactory<DigitalGoodsStore.Purchase> getPublicFeedbackDbKeyFactory();

  VersionedValuesTable<DigitalGoodsStore.Purchase, String> getPublicFeedbackTable();

  Pc365Key.LongKeyFactory<DigitalGoodsStore.Goods> getGoodsDbKeyFactory();

  VersionedEntityTable<DigitalGoodsStore.Goods> getGoodsTable();

  Collection<DigitalGoodsStore.Goods> getGoodsInStock(int from, int to);

  Collection<DigitalGoodsStore.Goods> getSellerGoods(long sellerId, boolean inStockOnly, int from, int to);

  Collection<DigitalGoodsStore.Purchase> getAllPurchases(int from, int to);

  Collection<DigitalGoodsStore.Purchase> getSellerPurchases(long sellerId, int from, int to);

  Collection<DigitalGoodsStore.Purchase> getBuyerPurchases(long buyerId, int from, int to);

  Collection<DigitalGoodsStore.Purchase> getSellerBuyerPurchases(long sellerId, long buyerId, int from, int to);

  Collection<DigitalGoodsStore.Purchase> getPendingSellerPurchases(long sellerId, int from, int to);

  Collection<DigitalGoodsStore.Purchase> getExpiredPendingPurchases(int timestamp);
}
