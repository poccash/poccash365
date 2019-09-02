package core.db.store;

import core.Subscription;
import core.db.Pc365Key;
import core.db.VersionedEntityTable;

import java.util.Collection;

public interface SubscriptionStore {

  Pc365Key.LongKeyFactory<Subscription> getSubscriptionDbKeyFactory();

  VersionedEntityTable<Subscription> getSubscriptionTable();

  Collection<Subscription> getSubscriptionsByParticipant(Long accountId);

  Collection<Subscription> getIdSubscriptions(Long accountId);

  Collection<Subscription> getSubscriptionsToId(Long accountId);

  Collection<Subscription> getUpdateSubscriptions(int timestamp);
}
