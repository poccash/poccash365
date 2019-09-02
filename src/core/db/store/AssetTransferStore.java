package core.db.store;

import core.AssetTransfer;
import core.db.Pc365Key;
import core.db.sql.EntitySqlTable;

import java.util.Collection;

public interface AssetTransferStore {
  Pc365Key.LongKeyFactory<AssetTransfer> getTransferDbKeyFactory();

  EntitySqlTable<AssetTransfer> getAssetTransferTable();

  Collection<AssetTransfer> getAssetTransfers(long assetId, int from, int to);

  Collection<AssetTransfer> getAccountAssetTransfers(long accountId, int from, int to);

  Collection<AssetTransfer> getAccountAssetTransfers(long accountId, long assetId, int from, int to);

  int getTransferCount(long assetId);
}
