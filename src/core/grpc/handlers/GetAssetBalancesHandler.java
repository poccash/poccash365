package core.grpc.handlers;

import core.Asset;
import core.assetexchange.AssetExchange;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.ApiException;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;

public class GetAssetBalancesHandler implements GrpcApiHandler<CoreApi.GetAssetBalancesRequest, CoreApi.AssetBalances> {

    private final AssetExchange assetExchange;

    public GetAssetBalancesHandler(AssetExchange assetExchange) {
        this.assetExchange = assetExchange;
    }

    @Override
    public CoreApi.AssetBalances handleRequest(CoreApi.GetAssetBalancesRequest request) throws Exception {
        long assetId = request.getAsset();
        CoreApi.IndexRange indexRange = ProtoBuilder.sanitizeIndexRange(request.getIndexRange());
        int firstIndex = indexRange.getFirstIndex();
        int lastIndex = indexRange.getLastIndex();
        int height = request.getHeight();

        Asset asset = assetExchange.getAsset(assetId);
        if (asset == null) throw new ApiException("Could not find asset");

        CoreApi.AssetBalances.Builder builder = CoreApi.AssetBalances.newBuilder();

        assetExchange.getAccountAssetsOverview(asset.getId(), height, firstIndex, lastIndex)
                .forEach(assetAccount -> builder.addAssetBalances(ProtoBuilder.buildAssetBalance(assetAccount)));

        return builder.build();
    }
}
