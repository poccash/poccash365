package core.db.sql;

import core.Pc365;
import core.Subscription;
import core.db.Pc365Key;
import core.db.VersionedEntityTable;
import core.db.store.DerivedTableManager;
import core.db.store.SubscriptionStore;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SortField;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static core.schema.Tables.SUBSCRIPTION;

public class SqlSubscriptionStore implements SubscriptionStore {

  private final Pc365Key.LongKeyFactory<Subscription> subscriptionDbKeyFactory = new DbKey.LongKeyFactory<Subscription>(SUBSCRIPTION.ID) {
      @Override
      public Pc365Key newKey(Subscription subscription) {
        return subscription.dbKey;
      }
    };

  private final VersionedEntityTable<Subscription> subscriptionTable;

  public SqlSubscriptionStore(DerivedTableManager derivedTableManager) {
    subscriptionTable = new VersionedEntitySqlTable<Subscription>("subscription", core.schema.Tables.SUBSCRIPTION, subscriptionDbKeyFactory, derivedTableManager) {
      @Override
      protected Subscription load(DSLContext ctx, Record rs) {
        return new SqlSubscription(rs);
      }

      @Override
      protected void save(DSLContext ctx, Subscription subscription) {
        saveSubscription(ctx, subscription);
      }

      @Override
      protected List<SortField<?>> defaultSort() {
        List<SortField<?>> sort = new ArrayList<>();
        sort.add(tableClass.field("time_next", Integer.class).asc());
        sort.add(tableClass.field("id", Long.class).asc());
        return sort;
      }
    };
  }

  private static Condition getByParticipantClause(final long id) {
    return SUBSCRIPTION.SENDER_ID.eq(id).or(SUBSCRIPTION.RECIPIENT_ID.eq(id));
  }

  private static Condition getUpdateOnBlockClause(final int timestamp) {
    return SUBSCRIPTION.TIME_NEXT.le(timestamp);
  }

  @Override
  public Pc365Key.LongKeyFactory<Subscription> getSubscriptionDbKeyFactory() {
    return subscriptionDbKeyFactory;
  }

  @Override
  public VersionedEntityTable<Subscription> getSubscriptionTable() {
    return subscriptionTable;
  }

  @Override
  public Collection<Subscription> getSubscriptionsByParticipant(Long accountId) {
    return subscriptionTable.getManyBy(getByParticipantClause(accountId), 0, -1);
  }

  @Override
  public Collection<Subscription> getIdSubscriptions(Long accountId) {
    return subscriptionTable.getManyBy(SUBSCRIPTION.SENDER_ID.eq(accountId), 0, -1);
  }

  @Override
  public Collection<Subscription> getSubscriptionsToId(Long accountId) {
    return subscriptionTable.getManyBy(SUBSCRIPTION.RECIPIENT_ID.eq(accountId), 0, -1);
  }

  @Override
  public Collection<Subscription> getUpdateSubscriptions(int timestamp) {
    return subscriptionTable.getManyBy(getUpdateOnBlockClause(timestamp), 0, -1);
  }

  private void saveSubscription(DSLContext ctx, Subscription subscription) {
    ctx.mergeInto(SUBSCRIPTION, SUBSCRIPTION.ID, SUBSCRIPTION.SENDER_ID, SUBSCRIPTION.RECIPIENT_ID, SUBSCRIPTION.AMOUNT, SUBSCRIPTION.FREQUENCY, SUBSCRIPTION.TIME_NEXT, SUBSCRIPTION.HEIGHT, SUBSCRIPTION.LATEST)
            .key(SUBSCRIPTION.ID, SUBSCRIPTION.SENDER_ID, SUBSCRIPTION.RECIPIENT_ID, SUBSCRIPTION.AMOUNT, SUBSCRIPTION.FREQUENCY, SUBSCRIPTION.TIME_NEXT, SUBSCRIPTION.HEIGHT, SUBSCRIPTION.LATEST)
            .values(subscription.id, subscription.senderId, subscription.recipientId, subscription.amountNQT, subscription.frequency, subscription.getTimeNext(), Pc365.getBlockchain().getHeight(), true)
            .execute();
  }

  private class SqlSubscription extends Subscription {
    SqlSubscription(Record record) {
      super(
            record.get(SUBSCRIPTION.SENDER_ID),
            record.get(SUBSCRIPTION.RECIPIENT_ID),
            record.get(SUBSCRIPTION.ID),
            record.get(SUBSCRIPTION.AMOUNT),
            record.get(SUBSCRIPTION.FREQUENCY),
            record.get(SUBSCRIPTION.TIME_NEXT),
            subscriptionDbKeyFactory.newKey(record.get(SUBSCRIPTION.ID))
            );
    }
  }
}
