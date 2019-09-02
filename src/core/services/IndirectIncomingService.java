package core.services;

import core.Transaction;

public interface IndirectIncomingService {
    void processTransaction(Transaction transaction);
    boolean isIndirectlyReceiving(Transaction transaction, long accountId);
}
