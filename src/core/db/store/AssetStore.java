package core.db.store;

import core.Asset;
import core.db.Pc365Key;
import core.db.sql.EntitySqlTable;

import java.util.Collection;

public interface AssetStore {
  Pc365Key.LongKeyFactory<Asset> getAssetDbKeyFactory();

  EntitySqlTable<Asset> getAssetTable();

  Collection<Asset> getAssetsIssuedBy(long accountId, int from, int to);
}
