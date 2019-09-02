package core.grpc.handlers;

import core.DigitalGoodsStore;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.ApiException;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import core.services.DGSGoodsStoreService;

public class GetDgsPurchaseHandler implements GrpcApiHandler<CoreApi.GetByIdRequest, CoreApi.DgsPurchase> {

    private final DGSGoodsStoreService digitalGoodsStoreService;

    public GetDgsPurchaseHandler(DGSGoodsStoreService digitalGoodsStoreService) {
        this.digitalGoodsStoreService = digitalGoodsStoreService;
    }

    @Override
    public CoreApi.DgsPurchase handleRequest(CoreApi.GetByIdRequest request) throws Exception {
        DigitalGoodsStore.Purchase purchase = digitalGoodsStoreService.getPurchase(request.getId());
        if (purchase == null) throw new ApiException("Could not find purchase");
        return ProtoBuilder.buildPurchase(purchase, digitalGoodsStoreService.getGoods(purchase.getGoodsId()));
    }
}
