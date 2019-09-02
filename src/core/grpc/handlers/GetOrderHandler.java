package core.grpc.handlers;

import core.Order;
import core.assetexchange.AssetExchange;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.ApiException;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;

public class GetOrderHandler implements GrpcApiHandler<CoreApi.GetOrderRequest, CoreApi.Order> {

    private final AssetExchange assetExchange;

    public GetOrderHandler(AssetExchange assetExchange) {
        this.assetExchange = assetExchange;
    }

    @Override
    public CoreApi.Order handleRequest(CoreApi.GetOrderRequest request) throws Exception {
        Order order;
        switch (request.getOrderType()) {
            case ASK:
                order = assetExchange.getAskOrder(request.getOrderId());
                break;
            case BID:
                order = assetExchange.getBidOrder(request.getOrderId());
                break;
            default:
                throw new ApiException("Order type unset");
        }
        if (order == null) throw new ApiException("Could not find order");
        return ProtoBuilder.buildOrder(order);
    }
}
