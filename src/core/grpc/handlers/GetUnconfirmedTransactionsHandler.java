package core.grpc.handlers;

import core.TransactionProcessor;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import core.services.IndirectIncomingService;

import java.util.stream.Collectors;

public class GetUnconfirmedTransactionsHandler implements GrpcApiHandler<CoreApi.GetAccountRequest, CoreApi.UnconfirmedTransactions> {

    private final IndirectIncomingService indirectIncomingService;
    private final TransactionProcessor transactionProcessor;

    public GetUnconfirmedTransactionsHandler(IndirectIncomingService indirectIncomingService, TransactionProcessor transactionProcessor) {
        this.indirectIncomingService = indirectIncomingService;
        this.transactionProcessor = transactionProcessor;
    }

    @Override
    public CoreApi.UnconfirmedTransactions handleRequest(CoreApi.GetAccountRequest getAccountRequest) throws Exception {
        return CoreApi.UnconfirmedTransactions.newBuilder()
                .addAllUnconfirmedTransactions(transactionProcessor.getAllUnconfirmedTransactions()
                        .stream()
                        .filter(transaction -> getAccountRequest.getAccountId() == 0
                                || getAccountRequest.getAccountId() == transaction.getSenderId()
                                || getAccountRequest.getAccountId() == transaction.getRecipientId()
                                || indirectIncomingService.isIndirectlyReceiving(transaction, getAccountRequest.getAccountId()))
                        .map(ProtoBuilder::buildUnconfirmedTransaction)
                        .collect(Collectors.toList()))
                .build();
    }
}
