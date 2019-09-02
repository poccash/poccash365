package core.db.store;

import core.at.AT;
import core.db.Pc365Key;
import core.db.VersionedEntityTable;

import java.util.Collection;
import java.util.List;

public interface ATStore {

  boolean isATAccountId(Long id);

  List<Long> getOrderedATs();

  AT getAT(Long id);

  List<Long> getATsIssuedBy(Long accountId);

  Collection<Long> getAllATIds();

  Pc365Key.LongKeyFactory<AT> getAtDbKeyFactory();

  VersionedEntityTable<AT> getAtTable();

  Pc365Key.LongKeyFactory<AT.ATState> getAtStateDbKeyFactory();

  VersionedEntityTable<AT.ATState> getAtStateTable();

  Long findTransaction(int startHeight, int endHeight, Long atID, int numOfTx, long minAmount);

  int findTransactionHeight(Long transactionId, int height, Long atID, long minAmount);
}
