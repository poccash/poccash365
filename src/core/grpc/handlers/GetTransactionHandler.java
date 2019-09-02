package core.grpc.handlers;

import core.Blockchain;
import core.Transaction;
import core.TransactionProcessor;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.ApiException;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import core.util.Convert;

public class GetTransactionHandler implements GrpcApiHandler<CoreApi.GetTransactionRequest, CoreApi.Transaction> {

    private final Blockchain blockchain;
    private final TransactionProcessor transactionProcessor;

    public GetTransactionHandler(Blockchain blockchain, TransactionProcessor transactionProcessor) {
        this.blockchain = blockchain;
        this.transactionProcessor = transactionProcessor;
    }

    @Override
    public CoreApi.Transaction handleRequest(CoreApi.GetTransactionRequest request) throws Exception {
        return ProtoBuilder.buildTransaction(getTransaction(blockchain, transactionProcessor, request), blockchain.getHeight());
    }

    public static Transaction getTransaction(Blockchain blockchain, TransactionProcessor transactionProcessor, CoreApi.GetTransactionRequest request) throws ApiException {
        long id = request.getTransactionId();
        byte[] fullHash = request.getFullHash().toByteArray();
        Transaction transaction;
        if (fullHash.length > 0) {
            transaction = blockchain.getTransactionByFullHash(Convert.toHexString(fullHash));
        } else if (id != 0) {
            transaction = blockchain.getTransaction(id);
            if (transaction == null) transaction = transactionProcessor.getUnconfirmedTransaction(id);
        } else {
            throw new ApiException("Could not find transaction");
        }
        if (transaction == null) {
            throw new ApiException("Could not find transaction");
        }
        return transaction;
    }
}
