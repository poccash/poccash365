package core.grpc.handlers;

import core.Account;
import core.Blockchain;
import core.Escrow;
import core.Generator;
import core.assetexchange.AssetExchange;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import core.peer.Peers;
import core.services.AccountService;
import core.services.AliasService;
import core.services.EscrowService;
import com.google.protobuf.Empty;

public class GetCountsHandler implements GrpcApiHandler<Empty, CoreApi.Counts> {
    
    private final AccountService accountService;
    private final EscrowService escrowService;
    private final Blockchain blockchain;
    private final AssetExchange assetExchange;
    private final AliasService aliasService;
    private final Generator generator;

    public GetCountsHandler(AccountService accountService, EscrowService escrowService, Blockchain blockchain, AssetExchange assetExchange, AliasService aliasService, Generator generator) {
        this.accountService = accountService;
        this.escrowService = escrowService;
        this.blockchain = blockchain;
        this.assetExchange = assetExchange;
        this.aliasService = aliasService;
        this.generator = generator;
    }

    @Override
    public CoreApi.Counts handleRequest(Empty empty) throws Exception {
        long totalEffectiveBalance = 0;
        int numberOfBlocks = blockchain.getHeight() + 1; // Height + genesis
        int numberOfTransactions = blockchain.getTransactionCount();
        int numberOfAccounts = accountService.getCount();
        int numberOfAssets = assetExchange.getAssetsCount();
        int numberOfAskOrders = assetExchange.getAskCount();
        int numberOfBidOrders = assetExchange.getBidCount();
        int numberOfOrders = numberOfAskOrders + numberOfBidOrders;
        int numberOfTrades = assetExchange.getTradesCount();
        int numberOfTransfers = assetExchange.getAssetTransferCount();
        long numberOfAliases = aliasService.getAliasCount();
        int numberOfPeers = Peers.getAllPeers().size();
        int numberOfGenerators = generator.getAllGenerators().size();
        for (Account account : accountService.getAllAccounts(0, -1)) {
            long effectiveBalancePC365 = account.getBalanceNQT();
            if (effectiveBalancePC365 > 0) {
                totalEffectiveBalance += effectiveBalancePC365;
            }
        }
        for (Escrow escrow : escrowService.getAllEscrowTransactions()) {
            totalEffectiveBalance += escrow.getAmountNQT();
        }

        return CoreApi.Counts.newBuilder()
                .setNumberOfBlocks(numberOfBlocks)
                .setNumberOfTransactions(numberOfTransactions)
                .setNumberOfAccounts(numberOfAccounts)
                .setNumberOfAssets(numberOfAssets)
                .setNumberOfOrders(numberOfOrders)
                .setNumberOfAskOrders(numberOfAskOrders)
                .setNumberOfBidOrders(numberOfBidOrders)
                .setNumberOfTrades(numberOfTrades)
                .setNumberOfTransfers(numberOfTransfers)
                .setNumberOfAliases(numberOfAliases)
                .setNumberOfPeers(numberOfPeers)
                .setNumberOfGenerators(numberOfGenerators)
                .setTotalEffectiveBalance(totalEffectiveBalance)
                .build();
    }
}
