package core.grpc.handlers;

import core.Asset;
import core.assetexchange.AssetExchange;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;

public class GetAssetsHandler implements GrpcApiHandler<CoreApi.GetAssetsRequest, CoreApi.Assets> {

    private final AssetExchange assetExchange;

    public GetAssetsHandler(AssetExchange assetExchange) {
        this.assetExchange = assetExchange;
    }

    @Override
    public CoreApi.Assets handleRequest(CoreApi.GetAssetsRequest getAssetsRequest) throws Exception {
        CoreApi.Assets.Builder builder = CoreApi.Assets.newBuilder();
        getAssetsRequest.getAssetList().forEach(assetId -> {
            Asset asset = assetExchange.getAsset(assetId);
            if (asset == null) return;
            builder.addAssets(ProtoBuilder.buildAsset(assetExchange, asset));
        });
        return builder.build();
    }
}
