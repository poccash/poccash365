package core.db.store;

import core.Alias;
import core.db.Pc365Key;
import core.db.VersionedEntityTable;

import java.util.Collection;

public interface AliasStore {
  Pc365Key.LongKeyFactory<Alias> getAliasDbKeyFactory();
  Pc365Key.LongKeyFactory<Alias.Offer> getOfferDbKeyFactory();

  VersionedEntityTable<Alias> getAliasTable();

  VersionedEntityTable<Alias.Offer> getOfferTable();

  Collection<Alias> getAliasesByOwner(long accountId, int from, int to);

  Alias getAlias(String aliasName);
}
