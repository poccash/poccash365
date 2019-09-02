package core.grpc.handlers;

import core.Transaction;
import core.TransactionProcessor;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;

public class BroadcastTransactionBytesHandler implements GrpcApiHandler<CoreApi.TransactionBytes, CoreApi.TransactionBroadcastResult> {

    private final TransactionProcessor transactionProcessor;

    public BroadcastTransactionBytesHandler(TransactionProcessor transactionProcessor) {
        this.transactionProcessor = transactionProcessor;
    }

    @Override
    public CoreApi.TransactionBroadcastResult handleRequest(CoreApi.TransactionBytes transactionBytes) throws Exception {
        return CoreApi.TransactionBroadcastResult.newBuilder()
                .setNumberOfPeersSentTo(transactionProcessor.broadcast(Transaction.parseTransaction(transactionBytes.getTransactionBytes().toByteArray())))
                .build();
    }
}
