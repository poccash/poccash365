package core.grpc.handlers;

import core.assetexchange.AssetExchange;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.ApiException;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;

public class GetOrdersHandler implements GrpcApiHandler<CoreApi.GetOrdersRequest, CoreApi.Orders> {

    private final AssetExchange assetExchange;

    public GetOrdersHandler(AssetExchange assetExchange) {
        this.assetExchange = assetExchange;
    }

    @Override
    public CoreApi.Orders handleRequest(CoreApi.GetOrdersRequest request) throws Exception {
        CoreApi.Orders.Builder builder = CoreApi.Orders.newBuilder();
        long assetId = request.getAsset();
        CoreApi.IndexRange indexRange = ProtoBuilder.sanitizeIndexRange(request.getIndexRange());
        int firstIndex = indexRange.getFirstIndex();
        int lastIndex = indexRange.getLastIndex();
        if (assetId == 0) {
            // Get all open orders
            switch (request.getOrderType()) {
                case ASK:
                    assetExchange.getAllAskOrders(firstIndex, lastIndex)
                            .forEach(order -> builder.addOrders(ProtoBuilder.buildOrder(order)));
                    break;
                case BID:
                    assetExchange.getAllAskOrders(firstIndex, lastIndex)
                            .forEach(order -> builder.addOrders(ProtoBuilder.buildOrder(order)));
                    break;
                default:
                    throw new ApiException("Order type unset");
            }
        } else {
            // Get orders under that asset
            switch (request.getOrderType()) {
                case ASK:
                    assetExchange.getSortedAskOrders(assetId, firstIndex, lastIndex)
                            .forEach(order -> builder.addOrders(ProtoBuilder.buildOrder(order)));
                    break;
                case BID:
                    assetExchange.getSortedBidOrders(assetId, firstIndex, lastIndex)
                            .forEach(order -> builder.addOrders(ProtoBuilder.buildOrder(order)));
                    break;
                default:
                    throw new ApiException("Order type unset");
            }
        }
        return builder.build();
    }
}
