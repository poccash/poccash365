package core.grpc.handlers;

import core.Account;
import core.Blockchain;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.ApiException;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import core.services.AccountService;

public class GetAccountTransactionsHandler implements GrpcApiHandler<CoreApi.GetAccountTransactionsRequest, CoreApi.Transactions> {

    private final Blockchain blockchain;
    private final AccountService accountService;

    public GetAccountTransactionsHandler(Blockchain blockchain, AccountService accountService) {
        this.blockchain = blockchain;
        this.accountService = accountService;
    }

    @Override
    public CoreApi.Transactions handleRequest(CoreApi.GetAccountTransactionsRequest request) throws Exception {
        long accountId = request.getAccountId();
        int timestamp = request.getTimestamp();
        CoreApi.IndexRange indexRange = ProtoBuilder.sanitizeIndexRange(request.getIndexRange());
        int firstIndex = indexRange.getFirstIndex();
        int lastIndex = indexRange.getLastIndex();
        int numberOfConfirmations = request.getConfirmations();
        byte type = (byte) (request.getFilterByType() ? request.getType() : -1);
        byte subtype = (byte) (request.getFilterByType() ? request.getSubtype() : -1);

        Account account = accountService.getAccount(accountId);
        if (account == null) throw new ApiException("Could not find account");

        CoreApi.Transactions.Builder builder = CoreApi.Transactions.newBuilder();

        int currentHeight = blockchain.getHeight();
        blockchain.getTransactions(account, numberOfConfirmations, type, subtype, timestamp, firstIndex, lastIndex, true)
                .forEach(transaction -> builder.addTransactions(ProtoBuilder.buildTransaction(transaction, currentHeight)));

        return builder.build();
    }
}
