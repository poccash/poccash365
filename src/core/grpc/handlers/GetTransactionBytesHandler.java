package core.grpc.handlers;

import core.Blockchain;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import com.google.protobuf.ByteString;

public class GetTransactionBytesHandler implements GrpcApiHandler<CoreApi.BasicTransaction, CoreApi.TransactionBytes> {

    private final Blockchain blockchain;

    public GetTransactionBytesHandler(Blockchain blockchain) {
        this.blockchain = blockchain;
    }

    @Override
    public CoreApi.TransactionBytes handleRequest(CoreApi.BasicTransaction basicTransaction) throws Exception {
        return CoreApi.TransactionBytes.newBuilder()
                .setTransactionBytes(ByteString.copyFrom(ProtoBuilder.parseBasicTransaction(blockchain, basicTransaction).getBytes()))
                .build();
    }
}
