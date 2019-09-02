package core.grpc.handlers;

import core.assetexchange.AssetExchange;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;

public class GetAssetsByIssuerHandler implements GrpcApiHandler<CoreApi.GetAccountRequest, CoreApi.Assets> {

    private final AssetExchange assetExchange;

    public GetAssetsByIssuerHandler(AssetExchange assetExchange) {
        this.assetExchange = assetExchange;
    }

    @Override
    public CoreApi.Assets handleRequest(CoreApi.GetAccountRequest getAccountRequest) throws Exception {
        CoreApi.Assets.Builder builder = CoreApi.Assets.newBuilder();
        assetExchange.getAssetsIssuedBy(getAccountRequest.getAccountId(), 0, -1)
                .forEach(asset -> builder.addAssets(ProtoBuilder.buildAsset(assetExchange, asset)));
        return builder.build();
    }
}
