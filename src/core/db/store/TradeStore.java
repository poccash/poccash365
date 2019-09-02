package core.db.store;

import core.Trade;
import core.db.Pc365Key;
import core.db.sql.EntitySqlTable;

import java.util.Collection;

public interface TradeStore {
  Collection<Trade> getAllTrades(int from, int to);

  Collection<Trade> getAssetTrades(long assetId, int from, int to);

  Collection<Trade> getAccountTrades(long accountId, int from, int to);

  Collection<Trade> getAccountAssetTrades(long accountId, long assetId, int from, int to);

  int getTradeCount(long assetId);

  Pc365Key.LinkKeyFactory<Trade> getTradeDbKeyFactory();

  EntitySqlTable<Trade> getTradeTable();
}
