package core.db.store;

import core.db.BlockDb;
import core.db.PeerDb;
import core.db.TransactionDb;

public interface Dbs {

  BlockDb getBlockDb();

  TransactionDb getTransactionDb();

  PeerDb getPeerDb();

}
