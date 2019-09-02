package core.grpc.handlers;

import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import core.services.EscrowService;

public class GetAccountEscrowTransactionsHandler implements GrpcApiHandler<CoreApi.GetAccountRequest, CoreApi.EscrowTransactions> {

    private final EscrowService escrowService;

    public GetAccountEscrowTransactionsHandler(EscrowService escrowService) {
        this.escrowService = escrowService;
    }

    @Override
    public CoreApi.EscrowTransactions handleRequest(CoreApi.GetAccountRequest request) throws Exception {
        long accountId = request.getAccountId();
        CoreApi.EscrowTransactions.Builder builder = CoreApi.EscrowTransactions.newBuilder();
        escrowService.getEscrowTransactionsByParticipant(accountId)
                .forEach(escrow -> builder.addEscrowTransactions(ProtoBuilder.buildEscrowTransaction(escrow)));
        return builder.build();
    }
}
