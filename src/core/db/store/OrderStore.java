package core.db.store;

import core.Order;
import core.db.Pc365Key;
import core.db.VersionedEntityTable;

import java.util.Collection;

public interface OrderStore {
  VersionedEntityTable<Order.Bid> getBidOrderTable();

  Collection<Order.Ask> getAskOrdersByAccountAsset(long accountId, long assetId, int from, int to);

  Collection<Order.Ask> getSortedAsks(long assetId, int from, int to);

  Order.Ask getNextOrder(long assetId);

  Collection<Order.Ask> getAll(int from, int to);

  Collection<Order.Ask> getAskOrdersByAccount(long accountId, int from, int to);

  Collection<Order.Ask> getAskOrdersByAsset(long assetId, int from, int to);

  Pc365Key.LongKeyFactory<Order.Ask> getAskOrderDbKeyFactory();

  VersionedEntityTable<Order.Ask> getAskOrderTable();

  Pc365Key.LongKeyFactory<Order.Bid> getBidOrderDbKeyFactory();

  Collection<Order.Bid> getBidOrdersByAccount(long accountId, int from, int to);

  Collection<Order.Bid> getBidOrdersByAsset(long assetId, int from, int to);

  Collection<Order.Bid> getBidOrdersByAccountAsset(long accountId, long assetId, int from, int to);

  Collection<Order.Bid> getSortedBids(long assetId, int from, int to);

  Order.Bid getNextBid(long assetId);
}
