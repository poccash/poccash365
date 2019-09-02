package core.db.sql;

import core.Alias;
import core.Pc365;
import core.db.Pc365Key;
import core.db.VersionedEntityTable;
import core.db.store.AliasStore;
import core.db.store.DerivedTableManager;
import core.util.Convert;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SortField;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import static core.schema.Tables.ALIAS;
import static core.schema.Tables.ALIAS_OFFER;

public class SqlAliasStore implements AliasStore {

  private static final DbKey.LongKeyFactory<Alias.Offer> offerDbKeyFactory = new DbKey.LongKeyFactory<Alias.Offer>(ALIAS_OFFER.ID) {
      @Override
      public Pc365Key newKey(Alias.Offer offer) {
        return offer.dbKey;
      }
    };

  public SqlAliasStore(DerivedTableManager derivedTableManager) {
    offerTable = new VersionedEntitySqlTable<Alias.Offer>("alias_offer", ALIAS_OFFER, offerDbKeyFactory, derivedTableManager) {
      @Override
      protected Alias.Offer load(DSLContext ctx, Record record) {
        return new SqlOffer(record);
      }

      @Override
      protected void save(DSLContext ctx, Alias.Offer offer) {
        saveOffer(offer);
      }
    };

    aliasTable = new VersionedEntitySqlTable<Alias>("alias", core.schema.Tables.ALIAS, aliasDbKeyFactory, derivedTableManager) {
      @Override
      protected Alias load(DSLContext ctx, Record record) {
        return new SqlAlias(record);
      }

      @Override
      protected void save(DSLContext ctx, Alias alias) {
        saveAlias(ctx, alias);
      }

      @Override
      protected List<SortField<?>> defaultSort() {
        List<SortField<?>> sort = new ArrayList<>();
        sort.add(tableClass.field("alias_name_lower", String.class).asc());
        return sort;
      }
    };
  }

  @Override
  public Pc365Key.LongKeyFactory<Alias.Offer> getOfferDbKeyFactory() {
    return offerDbKeyFactory;
  }

  private static final Pc365Key.LongKeyFactory<Alias> aliasDbKeyFactory = new DbKey.LongKeyFactory<Alias>(ALIAS.ID) {

      @Override
      public Pc365Key newKey(Alias alias) {
        return alias.dbKey;
      }
    };

  @Override
  public Pc365Key.LongKeyFactory<Alias> getAliasDbKeyFactory() {
    return aliasDbKeyFactory;
  }

  @Override
  public VersionedEntityTable<Alias> getAliasTable() {
    return aliasTable;
  }

  private class SqlOffer extends Alias.Offer {
    private SqlOffer(Record record) {
      super(record.get(ALIAS_OFFER.ID), record.get(ALIAS_OFFER.PRICE), Convert.nullToZero(record.get(ALIAS_OFFER.BUYER_ID)), offerDbKeyFactory.newKey(record.get(ALIAS_OFFER.ID)));
    }
  }

  private void saveOffer(Alias.Offer offer) {
    Db.useDSLContext(ctx -> {
      ctx.insertInto(ALIAS_OFFER, ALIAS_OFFER.ID, ALIAS_OFFER.PRICE, ALIAS_OFFER.BUYER_ID, ALIAS_OFFER.HEIGHT)
              .values(offer.getId(), offer.getPriceNQT(), (offer.getBuyerId() == 0 ? null : offer.getBuyerId()), Pc365.getBlockchain().getHeight())
              .execute();
    });
  }

  private final VersionedEntityTable<Alias.Offer> offerTable;

  @Override
  public VersionedEntityTable<Alias.Offer> getOfferTable() {
    return offerTable;
  }

  private class SqlAlias extends Alias {
    private SqlAlias(Record record) {
      super(
            record.get(ALIAS.ID),
            record.get(ALIAS.ACCOUNT_ID),
            record.get(ALIAS.ALIAS_NAME),
            record.get(ALIAS.ALIAS_URI),
            record.get(ALIAS.TIMESTAMP),
            aliasDbKeyFactory.newKey(record.get(ALIAS.ID))
            );
    }
  }

  private void saveAlias(DSLContext ctx, Alias alias) {
    ctx.insertInto(ALIAS).
      set(ALIAS.ID, alias.getId()).
      set(ALIAS.ACCOUNT_ID, alias.getAccountId()).
      set(ALIAS.ALIAS_NAME, alias.getAliasName()).
      set(ALIAS.ALIAS_NAME_LOWER, alias.getAliasName().toLowerCase(Locale.ENGLISH)).
      set(ALIAS.ALIAS_URI, alias.getAliasURI()).
      set(ALIAS.TIMESTAMP, alias.getTimestamp()).
      set(ALIAS.HEIGHT, Pc365.getBlockchain().getHeight()).execute();
  }

  private final VersionedEntityTable<Alias> aliasTable;

  @Override
  public Collection<Alias> getAliasesByOwner(long accountId, int from, int to) {
    return aliasTable.getManyBy(core.schema.Tables.ALIAS.ACCOUNT_ID.eq(accountId), from, to);
  }

  @Override
  public Alias getAlias(String aliasName) {
    return aliasTable.getBy(core.schema.Tables.ALIAS.ALIAS_NAME_LOWER.eq(aliasName.toLowerCase(Locale.ENGLISH)));
  }

}
