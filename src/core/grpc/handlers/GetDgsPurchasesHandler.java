package core.grpc.handlers;

import core.DigitalGoodsStore;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import core.services.DGSGoodsStoreService;
import core.util.FilteringIterator;

import java.util.Collection;

public class GetDgsPurchasesHandler implements GrpcApiHandler<CoreApi.GetDgsPurchasesRequest, CoreApi.DgsPurchases> {
    
    private final DGSGoodsStoreService digitalGoodsStoreService;

    public GetDgsPurchasesHandler(DGSGoodsStoreService digitalGoodsStoreService) {
        this.digitalGoodsStoreService = digitalGoodsStoreService;
    }

    @Override
    public CoreApi.DgsPurchases handleRequest(CoreApi.GetDgsPurchasesRequest request) throws Exception {
        long sellerId = request.getSeller();
        long buyerId = request.getBuyer();
        CoreApi.IndexRange indexRange = ProtoBuilder.sanitizeIndexRange(request.getIndexRange());
        int firstIndex = indexRange.getFirstIndex();
        int lastIndex = indexRange.getLastIndex();
        boolean completed = request.getCompleted();


        Collection<DigitalGoodsStore.Purchase> purchases;
        if (sellerId == 0 && buyerId == 0) {
            purchases = digitalGoodsStoreService.getAllPurchases(firstIndex, lastIndex);
        } else if (sellerId != 0 && buyerId == 0) {
            purchases = digitalGoodsStoreService.getSellerPurchases(sellerId, firstIndex, lastIndex);
        } else if (sellerId == 0) {
            purchases = digitalGoodsStoreService.getBuyerPurchases(buyerId, firstIndex, lastIndex);
        } else {
            purchases = digitalGoodsStoreService.getSellerBuyerPurchases(sellerId, buyerId, firstIndex, lastIndex);
        }

        CoreApi.DgsPurchases.Builder builder = CoreApi.DgsPurchases.newBuilder();
        new FilteringIterator<>(purchases, purchase -> ! (completed && purchase.isPending()), firstIndex, lastIndex)
                .forEachRemaining(purchase -> builder.addDgsPurchases(ProtoBuilder.buildPurchase(purchase, digitalGoodsStoreService.getGoods(purchase.getGoodsId()))));
        return builder.build();
    }
}
