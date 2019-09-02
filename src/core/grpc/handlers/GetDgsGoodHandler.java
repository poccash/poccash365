package core.grpc.handlers;

import core.DigitalGoodsStore;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.ApiException;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import core.services.DGSGoodsStoreService;

public class GetDgsGoodHandler implements GrpcApiHandler<CoreApi.GetByIdRequest, CoreApi.DgsGood> {

    private final DGSGoodsStoreService digitalGoodsStoreService;

    public GetDgsGoodHandler(DGSGoodsStoreService digitalGoodsStoreService) {
        this.digitalGoodsStoreService = digitalGoodsStoreService;
    }

    @Override
    public CoreApi.DgsGood handleRequest(CoreApi.GetByIdRequest request) throws Exception {
        long goodsId = request.getId();
        DigitalGoodsStore.Goods goods = digitalGoodsStoreService.getGoods(goodsId);
        if (goods == null) throw new ApiException("Could not find goods");
        return ProtoBuilder.buildGoods(goods);
    }
}
