package core.db;

import core.Block;
import core.Pc365Exception;
import core.schema.tables.records.BlockRecord;
import org.jooq.DSLContext;

public interface BlockDb extends Table {
  Block findBlock(long blockId);

  boolean hasBlock(long blockId);

  long findBlockIdAtHeight(int height);

  Block findBlockAtHeight(int height);

  Block findLastBlock();

  Block findLastBlock(int timestamp);

  Block loadBlock(BlockRecord r) throws Pc365Exception.ValidationException;

  void saveBlock(DSLContext ctx, Block block);

  // relying on cascade triggers in the database to delete the transactions for all deleted blocks
  void deleteBlocksFrom(long blockId);

  void deleteAll(boolean force);
}
