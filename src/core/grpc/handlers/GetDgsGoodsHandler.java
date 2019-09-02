package core.grpc.handlers;

import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import core.services.DGSGoodsStoreService;

public class GetDgsGoodsHandler implements GrpcApiHandler<CoreApi.GetDgsGoodsRequest, CoreApi.DgsGoods> {

    private final DGSGoodsStoreService digitalGoodsStoreService;

    public GetDgsGoodsHandler(DGSGoodsStoreService digitalGoodsStoreService) {
        this.digitalGoodsStoreService = digitalGoodsStoreService;
    }

    @Override
    public CoreApi.DgsGoods handleRequest(CoreApi.GetDgsGoodsRequest request) throws Exception {
        long sellerId = request.getSeller();
        boolean inStockOnly = request.getInStockOnly();
        CoreApi.IndexRange indexRange = ProtoBuilder.sanitizeIndexRange(request.getIndexRange());
        int firstIndex = indexRange.getFirstIndex();
        int lastIndex = indexRange.getLastIndex();
        CoreApi.DgsGoods.Builder builder = CoreApi.DgsGoods.newBuilder();
        if (sellerId == 0) {
            (inStockOnly ? digitalGoodsStoreService.getGoodsInStock(firstIndex, lastIndex) : digitalGoodsStoreService.getAllGoods(firstIndex, lastIndex))
                    .forEach(goods -> builder.addGoods(ProtoBuilder.buildGoods(goods)));
        } else {
            digitalGoodsStoreService.getSellerGoods(sellerId, inStockOnly, firstIndex, lastIndex)
                    .forEach(goods -> builder.addGoods(ProtoBuilder.buildGoods(goods)));
        }
        return builder.build();
    }
}
