package core.db.store;

import core.Account;
import core.Block;
import core.Transaction;
import core.schema.tables.records.BlockRecord;
import core.schema.tables.records.TransactionRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

import java.util.Collection;

/**
 * Store for both BlockchainImpl and BlockchainProcessorImpl
 */

public interface BlockchainStore {


  Collection<Block> getBlocks(int from, int to);

  Collection<Block> getBlocks(Account account, int timestamp, int from, int to);

  Collection<Block> getBlocks(Result<BlockRecord> blockRecords);

  Collection<Long> getBlockIdsAfter(long blockId, int limit);

  Collection<Block> getBlocksAfter(long blockId, int limit);

  int getTransactionCount();

  Collection<Transaction> getAllTransactions();

  Collection<Transaction> getTransactions(Account account, int numberOfConfirmations, byte type, byte subtype,
                                                 int blockTimestamp, int from, int to, boolean includeIndirectIncoming);

  Collection<Transaction> getTransactions(DSLContext ctx, Result<TransactionRecord> rs);

  void addBlock(Block block);

  Collection<Block> getLatestBlocks(int amountBlocks);
}
