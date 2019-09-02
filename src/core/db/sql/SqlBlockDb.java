package core.db.sql;

import core.Block;
import core.Pc365;
import core.Pc365Exception;
import core.db.BlockDb;
import core.schema.tables.records.BlockRecord;
import org.jooq.DSLContext;
import org.jooq.DeleteQuery;
import org.jooq.Record;
import org.jooq.SelectQuery;
import org.jooq.impl.TableImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static core.schema.Tables.BLOCK;

public class SqlBlockDb implements BlockDb {

  private static final Logger logger = LoggerFactory.getLogger(BlockDb.class);

  public Block findBlock(long blockId) {
    return Db.useDSLContext(ctx -> {
      try {
        BlockRecord r = ctx.selectFrom(BLOCK).where(BLOCK.ID.eq(blockId)).fetchAny();
        return r == null ? null : loadBlock(r);
      } catch (Pc365Exception.ValidationException e) {
        throw new RuntimeException("Block already in database, id = " + blockId + ", does not pass validation!", e);
      }
    });
  }

  public boolean hasBlock(long blockId) {
    return Db.useDSLContext(ctx -> {
      return ctx.fetchExists(ctx.selectOne().from(BLOCK).where(BLOCK.ID.eq(blockId)));
    });
  }

  public long findBlockIdAtHeight(int height) {
    return Db.useDSLContext(ctx -> {
      Long id = ctx.select(BLOCK.ID).from(BLOCK).where(BLOCK.HEIGHT.eq(height)).fetchOne(BLOCK.ID);
      if (id == null) {
        throw new RuntimeException("Block at height " + height + " not found in database!");
      }
      return id;
    });
  }

  public Block findBlockAtHeight(int height) {
    return Db.useDSLContext(ctx -> {
      try {
        Block block = loadBlock(ctx.selectFrom(BLOCK).where(BLOCK.HEIGHT.eq(height)).fetchAny());
        if (block == null) {
          throw new RuntimeException("Block at height " + height + " not found in database!");
        }
        return block;
      } catch (Pc365Exception.ValidationException e) {
        throw new RuntimeException(e.toString(), e);
      }
    });
  }

  public Block findLastBlock() {
    return Db.useDSLContext(ctx -> {
      try {
        return loadBlock(ctx.selectFrom(BLOCK).orderBy(BLOCK.DB_ID.desc()).limit(1).fetchAny());
      } catch (Pc365Exception.ValidationException e) {
        throw new RuntimeException("Last block already in database does not pass validation!", e);
      }
    });
  }

  public Block findLastBlock(int timestamp) {
    return Db.useDSLContext(ctx -> {
      try {
        return loadBlock(ctx.selectFrom(BLOCK).where(BLOCK.TIMESTAMP.lessOrEqual(timestamp)).orderBy(BLOCK.DB_ID.desc()).limit(1).fetchAny());
      } catch (Pc365Exception.ValidationException e) {
        throw new RuntimeException("Block already in database at timestamp " + timestamp + " does not pass validation!", e);
      }
    });
  }

  public Block loadBlock(BlockRecord r) throws Pc365Exception.ValidationException {
    int version                     = r.getVersion();
    int timestamp                   = r.getTimestamp();
    long previousBlockId            = Optional.ofNullable(r.getPreviousBlockId()).orElse(0L);
    long totalAmountNQT             = r.getTotalAmount();
    long totalFeeNQT                = r.getTotalFee();
    int payloadLength               = r.getPayloadLength();
    byte[] generatorPublicKey       = r.getGeneratorPublicKey();
    byte[] previousBlockHash        = r.getPreviousBlockHash();
    BigInteger cumulativeDifficulty = new BigInteger(r.getCumulativeDifficulty());
    long baseTarget                 = r.getBaseTarget();
    long nextBlockId                = Optional.ofNullable(r.getNextBlockId()).orElse(0L);
    int height                      = r.getHeight();
    byte[] generationSignature      = r.getGenerationSignature();
    byte[] blockSignature           = r.getBlockSignature();
    byte[] payloadHash              = r.getPayloadHash();
    long id                         = r.getId();
    long nonce                      = r.getNonce();
    byte[] blockATs                 = r.getAts();

    return new Block(version, timestamp, previousBlockId, totalAmountNQT, totalFeeNQT, payloadLength, payloadHash,
                         generatorPublicKey, generationSignature, blockSignature, previousBlockHash,
                         cumulativeDifficulty, baseTarget, nextBlockId, height, id, nonce, blockATs);
  }

  public void saveBlock(DSLContext ctx, Block block) {
      ctx.insertInto(BLOCK, BLOCK.ID, BLOCK.VERSION, BLOCK.TIMESTAMP, BLOCK.PREVIOUS_BLOCK_ID,
              BLOCK.TOTAL_AMOUNT, BLOCK.TOTAL_FEE, BLOCK.PAYLOAD_LENGTH, BLOCK.GENERATOR_PUBLIC_KEY,
              BLOCK.PREVIOUS_BLOCK_HASH, BLOCK.CUMULATIVE_DIFFICULTY, BLOCK.BASE_TARGET, BLOCK.HEIGHT,
              BLOCK.GENERATION_SIGNATURE, BLOCK.BLOCK_SIGNATURE, BLOCK.PAYLOAD_HASH, BLOCK.GENERATOR_ID,
              BLOCK.NONCE, BLOCK.ATS)
              .values(block.getId(), block.getVersion(), block.getTimestamp(),
                      block.getPreviousBlockId() == 0 ? null : block.getPreviousBlockId(),
                      block.getTotalAmountNQT(), block.getTotalFeeNQT(), block.getPayloadLength(),
                      block.getGeneratorPublicKey(), block.getPreviousBlockHash(),
                      block.getCumulativeDifficulty().toByteArray(), block.getBaseTarget(), block.getHeight(),
                      block.getGenerationSignature(), block.getBlockSignature(), block.getPayloadHash(),
                      block.getGeneratorId(), block.getNonce(), block.getBlockATs())
              .execute();

    Pc365.getDbs().getTransactionDb().saveTransactions(block.getTransactions());

    if (block.getPreviousBlockId() != 0) {
      ctx.update(BLOCK)
              .set(BLOCK.NEXT_BLOCK_ID, block.getId())
              .where(BLOCK.ID.eq(block.getPreviousBlockId()))
              .execute();
    }
  }

  // relying on cascade triggers in the database to delete the transactions for all deleted blocks
  @Override
  public void deleteBlocksFrom(long blockId) {
    if (!Db.isInTransaction()) {
      try {
        Db.beginTransaction();
        deleteBlocksFrom(blockId);
        Db.commitTransaction();
      } catch (Exception e) {
        Db.rollbackTransaction();
        throw e;
      } finally {
        Db.endTransaction();
      }
      return;
    }
    Db.useDSLContext(ctx -> {
      SelectQuery<Record> blockHeightQuery = ctx.selectQuery();
      blockHeightQuery.addFrom(BLOCK);
      blockHeightQuery.addSelect(BLOCK.HEIGHT);
      blockHeightQuery.addConditions(BLOCK.ID.eq(blockId));
      Integer blockHeight = blockHeightQuery.fetchOne().get(BLOCK.HEIGHT);

      if (blockHeight != null) {
        DeleteQuery deleteQuery = ctx.deleteQuery(BLOCK);
        deleteQuery.addConditions(BLOCK.HEIGHT.ge(blockHeight));
        deleteQuery.execute();
      }
    });
  }

  public void deleteAll(boolean force) {
    if (!Db.isInTransaction()) {
      try {
        Db.beginTransaction();
        deleteAll(force);
        Db.commitTransaction();
      } catch (Exception e) {
        Db.rollbackTransaction();
        throw e;
      }
      Db.endTransaction();
      return;
    }
    logger.info("Deleting blockchain...");
    Db.useDSLContext(ctx -> {
      List<TableImpl> tables = new ArrayList<>(Arrays.asList(core.schema.Tables.ACCOUNT,
              core.schema.Tables.ACCOUNT_ASSET, core.schema.Tables.ALIAS, core.schema.Tables.ALIAS_OFFER,
              core.schema.Tables.ASK_ORDER, core.schema.Tables.ASSET, core.schema.Tables.ASSET_TRANSFER,
              core.schema.Tables.AT, core.schema.Tables.AT_STATE, core.schema.Tables.BID_ORDER,
              core.schema.Tables.BLOCK, core.schema.Tables.ESCROW, core.schema.Tables.ESCROW_DECISION,
              core.schema.Tables.GOODS, core.schema.Tables.PEER, core.schema.Tables.PURCHASE,
              core.schema.Tables.PURCHASE_FEEDBACK, core.schema.Tables.PURCHASE_PUBLIC_FEEDBACK,
              core.schema.Tables.REWARD_RECIP_ASSIGN, core.schema.Tables.SUBSCRIPTION,
              core.schema.Tables.TRADE, core.schema.Tables.TRANSACTION,
              core.schema.Tables.UNCONFIRMED_TRANSACTION));
      for (TableImpl<?> table : tables) {
        try {
          ctx.truncate(table).execute();
        } catch (org.jooq.exception.DataAccessException e) {
          if (force) {
            logger.trace("exception during truncate {0}", table, e);
          } else {
            throw e;
          }
        }
      }
    });
  }

  @Override
  public void optimize() {
    Db.optimizeTable(BLOCK.getName());
  }
}
