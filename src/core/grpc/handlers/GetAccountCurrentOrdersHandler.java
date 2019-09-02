package core.grpc.handlers;

import core.assetexchange.AssetExchange;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.ApiException;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;

public class GetAccountCurrentOrdersHandler implements GrpcApiHandler<CoreApi.GetAccountOrdersRequest, CoreApi.Orders> {

    private final AssetExchange assetExchange;

    public GetAccountCurrentOrdersHandler(AssetExchange assetExchange) {
        this.assetExchange = assetExchange;
    }

    @Override
    public CoreApi.Orders handleRequest(CoreApi.GetAccountOrdersRequest request) throws Exception {
        long accountId = request.getAccount();
        long assetId = request.getAsset();
        CoreApi.IndexRange indexRange = ProtoBuilder.sanitizeIndexRange(request.getIndexRange());
        int firstIndex = indexRange.getFirstIndex();
        int lastIndex = indexRange.getLastIndex();

        CoreApi.Orders.Builder builder = CoreApi.Orders.newBuilder();
        switch (request.getOrderType()) {
            case ASK:
                (assetId == 0 ? assetExchange.getAskOrdersByAccount(accountId, firstIndex, lastIndex) : assetExchange.getAskOrdersByAccountAsset(accountId, assetId, firstIndex, lastIndex))
                        .forEach(order -> builder.addOrders(ProtoBuilder.buildOrder(order)));
                break;
            case BID:
                (assetId == 0 ? assetExchange.getBidOrdersByAccount(accountId, firstIndex, lastIndex) : assetExchange.getBidOrdersByAccountAsset(accountId, assetId, firstIndex, lastIndex))
                        .forEach(order -> builder.addOrders(ProtoBuilder.buildOrder(order)));
                break;
            default:
                throw new ApiException("Order Type not set");
        }
        return builder.build();
    }
}
