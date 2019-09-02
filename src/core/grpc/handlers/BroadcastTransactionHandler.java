package core.grpc.handlers;

import core.Blockchain;
import core.TransactionProcessor;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;

public class BroadcastTransactionHandler implements GrpcApiHandler<CoreApi.BasicTransaction, CoreApi.TransactionBroadcastResult> {

    private final TransactionProcessor transactionProcessor;
    private final Blockchain blockchain;

    public BroadcastTransactionHandler(TransactionProcessor transactionProcessor, Blockchain blockchain) {
        this.transactionProcessor = transactionProcessor;
        this.blockchain = blockchain;
    }

    @Override
    public CoreApi.TransactionBroadcastResult handleRequest(CoreApi.BasicTransaction basicTransaction) throws Exception {
        return CoreApi.TransactionBroadcastResult.newBuilder()
                .setNumberOfPeersSentTo(transactionProcessor.broadcast(ProtoBuilder.parseBasicTransaction(blockchain, basicTransaction)))
                .build();
    }
}
