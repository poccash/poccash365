package core.grpc.proto;

import core.Blockchain;
import core.BlockchainProcessor;
import core.Generator;
import core.TransactionProcessor;
import core.assetexchange.AssetExchange;
import core.feesuggestions.FeeSuggestionCalculator;
import core.fluxcapacitor.FluxCapacitor;
import core.grpc.GrpcApiHandler;
import core.grpc.handlers.*;
import core.props.PropertyService;
import core.services.*;
import com.google.protobuf.Empty;
import com.google.protobuf.Message;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CoreService extends CoreApiServiceGrpc.CoreApiServiceImplBase {

    private final Map<Class<? extends GrpcApiHandler<? extends Message,? extends Message>>, GrpcApiHandler<? extends Message,? extends Message>> handlers;

    public CoreService(BlockchainProcessor blockchainProcessor, Blockchain blockchain, BlockService blockService, AccountService accountService, Generator generator, TransactionProcessor transactionProcessor, TimeService timeService, FeeSuggestionCalculator feeSuggestionCalculator, ATService atService, AliasService aliasService, IndirectIncomingService indirectIncomingService, FluxCapacitor fluxCapacitor, EscrowService escrowService, AssetExchange assetExchange, SubscriptionService subscriptionService, DGSGoodsStoreService digitalGoodsStoreService, PropertyService propertyService) {
        Map<Class<? extends GrpcApiHandler<? extends Message,? extends Message>>, GrpcApiHandler<? extends Message,? extends Message>> handlerMap = new HashMap<>();
        handlerMap.put(BroadcastTransactionHandler.class, new BroadcastTransactionHandler(transactionProcessor, blockchain));
        handlerMap.put(BroadcastTransactionBytesHandler.class, new BroadcastTransactionBytesHandler(transactionProcessor));
        handlerMap.put(CompleteBasicTransactionHandler.class, new CompleteBasicTransactionHandler(timeService, transactionProcessor, blockchain));
        handlerMap.put(GetAccountATsHandler.class, new GetAccountATsHandler(atService, accountService));
        handlerMap.put(GetAccountBlocksHandler.class, new GetAccountBlocksHandler(blockchain, blockService, accountService));
        handlerMap.put(GetAccountCurrentOrdersHandler.class, new GetAccountCurrentOrdersHandler(assetExchange));
        handlerMap.put(GetAccountEscrowTransactionsHandler.class, new GetAccountEscrowTransactionsHandler(escrowService));
        handlerMap.put(GetAccountHandler.class, new GetAccountHandler(accountService));
        handlerMap.put(GetAccountsHandler.class, new GetAccountsHandler(accountService));
        handlerMap.put(GetAccountSubscriptionsHandler.class, new GetAccountSubscriptionsHandler(subscriptionService));
        handlerMap.put(GetAccountTransactionsHandler.class, new GetAccountTransactionsHandler(blockchain, accountService));
        handlerMap.put(GetAliasesHandler.class, new GetAliasesHandler(aliasService));
        handlerMap.put(GetAliasHandler.class, new GetAliasHandler(aliasService));
        handlerMap.put(GetAssetBalancesHandler.class, new GetAssetBalancesHandler(assetExchange));
        handlerMap.put(GetAssetHandler.class, new GetAssetHandler(assetExchange));
        handlerMap.put(GetAssetsByIssuerHandler.class, new GetAssetsByIssuerHandler(assetExchange));
        handlerMap.put(GetAssetsHandler.class, new GetAssetsHandler(assetExchange));
        handlerMap.put(GetAssetTradesHandler.class, new GetAssetTradesHandler(assetExchange));
        handlerMap.put(GetAssetTransfersHandler.class, new GetAssetTransfersHandler(assetExchange, accountService));
        handlerMap.put(GetATHandler.class, new GetATHandler(atService, accountService));
        handlerMap.put(GetATIdsHandler.class, new GetATIdsHandler(atService));
        handlerMap.put(GetBlockHandler.class, new GetBlockHandler(blockchain, blockService));
        handlerMap.put(GetBlocksHandler.class, new GetBlocksHandler(blockchain, blockService));
        handlerMap.put(GetConstantsHandler.class, new GetConstantsHandler(fluxCapacitor));
        handlerMap.put(GetCountsHandler.class, new GetCountsHandler(accountService, escrowService, blockchain, assetExchange, aliasService, generator));
        handlerMap.put(GetCurrentTimeHandler.class, new GetCurrentTimeHandler(timeService));
        handlerMap.put(GetDgsGoodHandler.class, new GetDgsGoodHandler(digitalGoodsStoreService));
        handlerMap.put(GetDgsGoodsHandler.class, new GetDgsGoodsHandler(digitalGoodsStoreService));
        handlerMap.put(GetDgsPendingPurchasesHandler.class, new GetDgsPendingPurchasesHandler(digitalGoodsStoreService));
        handlerMap.put(GetDgsPurchaseHandler.class, new GetDgsPurchaseHandler(digitalGoodsStoreService));
        handlerMap.put(GetDgsPurchasesHandler.class, new GetDgsPurchasesHandler(digitalGoodsStoreService));
        handlerMap.put(GetEscrowTransactionHandler.class, new GetEscrowTransactionHandler(escrowService));
        handlerMap.put(GetMiningInfoHandler.class, new GetMiningInfoHandler(blockchainProcessor, blockchain, generator));
        handlerMap.put(GetOrderHandler.class, new GetOrderHandler(assetExchange));
        handlerMap.put(GetOrdersHandler.class, new GetOrdersHandler(assetExchange));
        handlerMap.put(GetPeersHandler.class, new GetPeersHandler());
        handlerMap.put(GetStateHandler.class, new GetStateHandler(timeService, blockchain, generator, blockchainProcessor, propertyService));
        handlerMap.put(GetSubscriptionHandler.class, new GetSubscriptionHandler(subscriptionService));
        handlerMap.put(GetSubscriptionsToAccountHandler.class, new GetSubscriptionsToAccountHandler(subscriptionService));
        handlerMap.put(GetTransactionBytesHandler.class, new GetTransactionBytesHandler(blockchain));
        handlerMap.put(GetTransactionHandler.class, new GetTransactionHandler(blockchain, transactionProcessor));
        handlerMap.put(GetUnconfirmedTransactionsHandler.class, new GetUnconfirmedTransactionsHandler(indirectIncomingService, transactionProcessor));
        handlerMap.put(ParseTransactionHandler.class, new ParseTransactionHandler());
        handlerMap.put(SubmitNonceHandler.class, new SubmitNonceHandler(propertyService, blockchain, accountService, generator));
        handlerMap.put(SuggestFeeHandler.class, new SuggestFeeHandler(feeSuggestionCalculator));
        this.handlers = Collections.unmodifiableMap(handlerMap);
    }

    public Server start(String hostname, int port) throws IOException {
        if (Objects.equals(hostname, "0.0.0.0")) {
            return ServerBuilder.forPort(port).addService(this).build().start();
        } else {
            return NettyServerBuilder.forAddress(new InetSocketAddress(hostname, port)).addService(this).build().start();
        }
    }

    private <H extends GrpcApiHandler<R, S>, R extends Message, S extends Message> void handleRequest(Class<H> handlerClass, R request, StreamObserver<S> response) {
        GrpcApiHandler<? extends Message, ? extends Message> handler = handlers.get(handlerClass);
        if (handlerClass != null && handlerClass.isInstance(handler)) {
            H handlerInstance = handlerClass.cast(handler);
            handlerInstance.handleRequest(request, response);
        } else {
            response.onError(ProtoBuilder.buildError(new HandlerNotFoundException("H not registered: " + handlerClass)));
        }
    }

    @Override
    public void getMiningInfo(Empty request, StreamObserver<CoreApi.MiningInfo> responseObserver) {
        handleRequest(GetMiningInfoHandler.class, request, responseObserver);
    }

    @Override
    public void submitNonce(CoreApi.SubmitNonceRequest request, StreamObserver<CoreApi.SubmitNonceResponse> responseObserver) {
        handleRequest(SubmitNonceHandler.class, request, responseObserver);
    }

    @Override
    public void getAccount(CoreApi.GetAccountRequest request, StreamObserver<CoreApi.Account> responseObserver) {
        handleRequest(GetAccountHandler.class, request, responseObserver);
    }

    @Override
    public void getAccounts(CoreApi.GetAccountsRequest request, StreamObserver<CoreApi.Accounts> responseObserver) {
        handleRequest(GetAccountsHandler.class, request, responseObserver);
    }

    @Override
    public void getBlock(CoreApi.GetBlockRequest request, StreamObserver<CoreApi.Block> responseObserver) {
        handleRequest(GetBlockHandler.class, request, responseObserver);
    }

    @Override
    public void getTransaction(CoreApi.GetTransactionRequest request, StreamObserver<CoreApi.Transaction> responseObserver) {
        handleRequest(GetTransactionHandler.class, request, responseObserver);
    }

    @Override
    public void getTransactionBytes(CoreApi.BasicTransaction request, StreamObserver<CoreApi.TransactionBytes> responseObserver) {
        handleRequest(GetTransactionBytesHandler.class, request, responseObserver);
    }

    @Override
    public void completeBasicTransaction(CoreApi.BasicTransaction request, StreamObserver<CoreApi.BasicTransaction> responseObserver) {
        handleRequest(CompleteBasicTransactionHandler.class, request, responseObserver);
    }

    @Override
    public void getCurrentTime(Empty request, StreamObserver<CoreApi.Time> responseObserver) {
        handleRequest(GetCurrentTimeHandler.class, request, responseObserver);
    }

    @Override
    public void broadcastTransaction(CoreApi.BasicTransaction request, StreamObserver<CoreApi.TransactionBroadcastResult> responseObserver) {
        handleRequest(BroadcastTransactionHandler.class, request, responseObserver);
    }

    @Override
    public void broadcastTransactionBytes(CoreApi.TransactionBytes request, StreamObserver<CoreApi.TransactionBroadcastResult> responseObserver) {
        handleRequest(BroadcastTransactionBytesHandler.class, request, responseObserver);
    }

    @Override
    public void getState(Empty request, StreamObserver<CoreApi.State> responseObserver) {
        handleRequest(GetStateHandler.class, request, responseObserver);
    }

    @Override
    public void getPeers(CoreApi.GetPeersRequest request, StreamObserver<CoreApi.Peers> responseObserver) {
        handleRequest(GetPeersHandler.class, request, responseObserver);
    }

    @Override
    public void getPeer(CoreApi.GetPeerRequest request, StreamObserver<CoreApi.Peer> responseObserver) {
        handleRequest(GetPeerHandler.class, request, responseObserver);
    }

    @Override
    public void suggestFee(Empty request, StreamObserver<CoreApi.FeeSuggestion> responseObserver) {
        handleRequest(SuggestFeeHandler.class, request, responseObserver);
    }

    @Override
    public void parseTransaction(CoreApi.TransactionBytes request, StreamObserver<CoreApi.BasicTransaction> responseObserver) {
        handleRequest(ParseTransactionHandler.class, request, responseObserver);
    }

    @Override
    public void getAccountATs(CoreApi.GetAccountRequest request, StreamObserver<CoreApi.AccountATs> responseObserver) {
        handleRequest(GetAccountATsHandler.class, request, responseObserver);
    }

    @Override
    public void getAT(CoreApi.GetByIdRequest request, StreamObserver<CoreApi.AT> responseObserver) {
        handleRequest(GetATHandler.class, request, responseObserver);
    }

    @Override
    public void getATIds(Empty request, StreamObserver<CoreApi.ATIds> responseObserver) {
        handleRequest(GetATIdsHandler.class, request, responseObserver);
    }

    @Override
    public void getAlias(CoreApi.GetAliasRequest request, StreamObserver<CoreApi.Alias> responseObserver) {
        handleRequest(GetAliasHandler.class, request, responseObserver);
    }

    @Override
    public void getAliases(CoreApi.GetAliasesRequest request, StreamObserver<CoreApi.Aliases> responseObserver) {
        handleRequest(GetAliasesHandler.class, request, responseObserver);
    }

    @Override
    public void getUnconfirmedTransactions(CoreApi.GetAccountRequest request, StreamObserver<CoreApi.UnconfirmedTransactions> responseObserver) {
        handleRequest(GetUnconfirmedTransactionsHandler.class, request, responseObserver);
    }

    @Override
    public void getAccountBlocks(CoreApi.GetAccountBlocksRequest request, StreamObserver<CoreApi.Blocks> responseObserver) {
        handleRequest(GetAccountBlocksHandler.class, request, responseObserver);
    }

    @Override
    public void getAccountCurrentOrders(CoreApi.GetAccountOrdersRequest request, StreamObserver<CoreApi.Orders> responseObserver) {
        handleRequest(GetAccountCurrentOrdersHandler.class, request, responseObserver);
    }

    @Override
    public void getAccountEscrowTransactions(CoreApi.GetAccountRequest request, StreamObserver<CoreApi.EscrowTransactions> responseObserver) {
        handleRequest(GetAccountEscrowTransactionsHandler.class, request, responseObserver);
    }

    @Override
    public void getAccountSubscriptions(CoreApi.GetAccountRequest request, StreamObserver<CoreApi.Subscriptions> responseObserver) {
        handleRequest(GetAccountSubscriptionsHandler.class, request, responseObserver);
    }

    @Override
    public void getAccountTransactions(CoreApi.GetAccountTransactionsRequest request, StreamObserver<CoreApi.Transactions> responseObserver) {
        handleRequest(GetAccountTransactionsHandler.class, request, responseObserver);
    }

    @Override
    public void getAsset(CoreApi.GetByIdRequest request, StreamObserver<CoreApi.Asset> responseObserver) {
        handleRequest(GetAssetHandler.class, request, responseObserver);
    }

    @Override
    public void getAssetBalances(CoreApi.GetAssetBalancesRequest request, StreamObserver<CoreApi.AssetBalances> responseObserver) {
        handleRequest(GetAssetBalancesHandler.class, request, responseObserver);
    }

    @Override
    public void getAssets(CoreApi.GetAssetsRequest request, StreamObserver<CoreApi.Assets> responseObserver) {
        handleRequest(GetAssetsHandler.class, request, responseObserver);
    }

    @Override
    public void getAssetsByIssuer(CoreApi.GetAccountRequest request, StreamObserver<CoreApi.Assets> responseObserver) {
        handleRequest(GetAssetsByIssuerHandler.class, request, responseObserver);
    }

    @Override
    public void getAssetTrades(CoreApi.GetAssetTransfersRequest request, StreamObserver<CoreApi.AssetTrades> responseObserver) {
        handleRequest(GetAssetTradesHandler.class, request, responseObserver);
    }

    @Override
    public void getAssetTransfers(CoreApi.GetAssetTransfersRequest request, StreamObserver<CoreApi.AssetTransfers> responseObserver) {
        handleRequest(GetAssetTransfersHandler.class, request, responseObserver);
    }

    @Override
    public void getBlocks(CoreApi.GetBlocksRequest request, StreamObserver<CoreApi.Blocks> responseObserver) {
        handleRequest(GetBlocksHandler.class, request, responseObserver);
    }

    @Override
    public void getConstants(Empty request, StreamObserver<CoreApi.Constants> responseObserver) {
        handleRequest(GetConstantsHandler.class, request, responseObserver);
    }

    @Override
    public void getCounts(Empty request, StreamObserver<CoreApi.Counts> responseObserver) {
        handleRequest(GetCountsHandler.class, request, responseObserver);
    }

    @Override
    public void getDgsGood(CoreApi.GetByIdRequest request, StreamObserver<CoreApi.DgsGood> responseObserver) {
        handleRequest(GetDgsGoodHandler.class, request, responseObserver);
    }

    @Override
    public void getDgsGoods(CoreApi.GetDgsGoodsRequest request, StreamObserver<CoreApi.DgsGoods> responseObserver) {
        handleRequest(GetDgsGoodsHandler.class, request, responseObserver);
    }

    @Override
    public void getDgsPendingPurchases(CoreApi.GetDgsPendingPurchasesRequest request, StreamObserver<CoreApi.DgsPurchases> responseObserver) {
        handleRequest(GetDgsPendingPurchasesHandler.class, request, responseObserver);
    }

    @Override
    public void getDgsPurchase(CoreApi.GetByIdRequest request, StreamObserver<CoreApi.DgsPurchase> responseObserver) {
        handleRequest(GetDgsPurchaseHandler.class, request, responseObserver);
    }

    @Override
    public void getDgsPurchases(CoreApi.GetDgsPurchasesRequest request, StreamObserver<CoreApi.DgsPurchases> responseObserver) {
        handleRequest(GetDgsPurchasesHandler.class, request, responseObserver);
    }

    @Override
    public void getEscrowTransaction(CoreApi.GetByIdRequest request, StreamObserver<CoreApi.EscrowTransaction> responseObserver) {
        handleRequest(GetEscrowTransactionHandler.class, request, responseObserver);
    }

    @Override
    public void getOrder(CoreApi.GetOrderRequest request, StreamObserver<CoreApi.Order> responseObserver) {
        handleRequest(GetOrderHandler.class, request, responseObserver);
    }

    @Override
    public void getOrders(CoreApi.GetOrdersRequest request, StreamObserver<CoreApi.Orders> responseObserver) {
        handleRequest(GetOrdersHandler.class, request, responseObserver);
    }

    @Override
    public void getSubscription(CoreApi.GetByIdRequest request, StreamObserver<CoreApi.Subscription> responseObserver) {
        handleRequest(GetSubscriptionHandler.class, request, responseObserver);
    }

    @Override
    public void getSubscriptionsToAccount(CoreApi.GetAccountRequest request, StreamObserver<CoreApi.Subscriptions> responseObserver) {
        handleRequest(GetSubscriptionsToAccountHandler.class, request, responseObserver);
    }

    private class HandlerNotFoundException extends Exception {
        public HandlerNotFoundException(String message) {
            super(message);
        }
    }
}
