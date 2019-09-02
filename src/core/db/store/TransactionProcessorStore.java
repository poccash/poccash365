package core.db.store;

import core.Transaction;
import core.db.Pc365Key;
import core.db.sql.EntitySqlTable;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface TransactionProcessorStore {
  // WATCH: BUSINESS-LOGIC
  void processLater(Collection<Transaction> transactions);

  Pc365Key.LongKeyFactory<Transaction> getUnconfirmedTransactionDbKeyFactory();

  Set<Transaction> getLostTransactions();

  Map<Long, Integer> getLostTransactionHeights();

  EntitySqlTable<Transaction> getUnconfirmedTransactionTable();

  int deleteTransaction (Transaction transaction);

  boolean hasTransaction(long transactionId);
}
