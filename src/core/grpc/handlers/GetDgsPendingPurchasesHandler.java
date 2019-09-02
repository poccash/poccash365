package core.grpc.handlers;

import core.grpc.GrpcApiHandler;
import core.grpc.proto.ApiException;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import core.services.DGSGoodsStoreService;

public class GetDgsPendingPurchasesHandler implements GrpcApiHandler<CoreApi.GetDgsPendingPurchasesRequest, CoreApi.DgsPurchases> {

    private final DGSGoodsStoreService digitalGoodsStoreService;

    public GetDgsPendingPurchasesHandler(DGSGoodsStoreService digitalGoodsStoreService) {
        this.digitalGoodsStoreService = digitalGoodsStoreService;
    }

    @Override
    public CoreApi.DgsPurchases handleRequest(CoreApi.GetDgsPendingPurchasesRequest request) throws Exception {
        long sellerId = request.getSeller();
        CoreApi.IndexRange indexRange = ProtoBuilder.sanitizeIndexRange(request.getIndexRange());
        int firstIndex = indexRange.getFirstIndex();
        int lastIndex = indexRange.getLastIndex();
        if (sellerId == 0) throw new ApiException("Seller ID not set");
        CoreApi.DgsPurchases.Builder builder = CoreApi.DgsPurchases.newBuilder();
        digitalGoodsStoreService.getPendingSellerPurchases(sellerId, firstIndex, lastIndex)
                .forEach(purchase -> builder.addDgsPurchases(ProtoBuilder.buildPurchase(purchase, digitalGoodsStoreService.getGoods(purchase.getGoodsId()))));
        return builder.build();
    }
}
