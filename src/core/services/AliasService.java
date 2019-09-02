package core.services;

import core.Alias;
import core.Alias.Offer;
import core.Attachment;
import core.Transaction;

import java.util.Collection;

public interface AliasService {

  Alias getAlias(long aliasId);

  Alias getAlias(String aliasName);

  Offer getOffer(Alias alias);

  long getAliasCount();

  Collection<Alias> getAliasesByOwner(long accountId, int from, int to);

  void addOrUpdateAlias(Transaction transaction, Attachment.MessagingAliasAssignment attachment);

  void sellAlias(Transaction transaction, Attachment.MessagingAliasSell attachment);

  void changeOwner(long newOwnerId, String aliasName, int timestamp);
}
