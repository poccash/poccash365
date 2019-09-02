package core.grpc.handlers;

import core.Account;
import core.Blockchain;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.ApiException;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import core.services.AccountService;
import core.services.BlockService;

import java.util.stream.Collectors;

public class GetAccountBlocksHandler implements GrpcApiHandler<CoreApi.GetAccountBlocksRequest, CoreApi.Blocks> {

    private final Blockchain blockchain;
    private final BlockService blockService;
    private final AccountService accountService;

    public GetAccountBlocksHandler(Blockchain blockchain, BlockService blockService, AccountService accountService) {
        this.blockchain = blockchain;
        this.blockService = blockService;
        this.accountService = accountService;
    }

    @Override
    public CoreApi.Blocks handleRequest(CoreApi.GetAccountBlocksRequest getAccountRequest) throws Exception {
        long accountId = getAccountRequest.getAccountId();
        int timestamp = getAccountRequest.getTimestamp();
        boolean includeTransactions = getAccountRequest.getIncludeTransactions();

        CoreApi.IndexRange indexRange = ProtoBuilder.sanitizeIndexRange(getAccountRequest.getIndexRange());
        int firstIndex = indexRange.getFirstIndex();
        int lastIndex = indexRange.getLastIndex();

        Account account = accountService.getAccount(accountId);
        if (account == null) throw new ApiException("Could not find account");

        return CoreApi.Blocks.newBuilder()
                .addAllBlocks(blockchain.getBlocks(account, timestamp, firstIndex, lastIndex).stream()
                        .map(block -> ProtoBuilder.buildBlock(blockchain, blockService, block, includeTransactions))
                        .collect(Collectors.toList()))
                .build();
    }
}
