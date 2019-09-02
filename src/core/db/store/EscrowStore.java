package core.db.store;

import core.Escrow;
import core.Transaction;
import core.db.Pc365Key;
import core.db.VersionedEntityTable;
import core.db.sql.DbKey;

import java.util.Collection;
import java.util.List;

public interface EscrowStore {

  Pc365Key.LongKeyFactory<Escrow> getEscrowDbKeyFactory();

  VersionedEntityTable<Escrow> getEscrowTable();

  DbKey.LinkKeyFactory<Escrow.Decision> getDecisionDbKeyFactory();

  VersionedEntityTable<Escrow.Decision> getDecisionTable();

  Collection<Escrow> getEscrowTransactionsByParticipant(Long accountId);

  List<Transaction> getResultTransactions();

  Collection<Escrow.Decision> getDecisions(Long id);
}
