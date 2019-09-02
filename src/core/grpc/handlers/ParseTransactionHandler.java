package core.grpc.handlers;

import core.Transaction;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;

public class ParseTransactionHandler implements GrpcApiHandler<CoreApi.TransactionBytes, CoreApi.BasicTransaction> {
    @Override
    public CoreApi.BasicTransaction handleRequest(CoreApi.TransactionBytes transactionBytes) throws Exception {
        return ProtoBuilder.buildBasicTransaction(Transaction.parseTransaction(transactionBytes.getTransactionBytes().toByteArray()));
    }
}
