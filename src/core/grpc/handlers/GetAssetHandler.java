package core.grpc.handlers;

import core.Asset;
import core.assetexchange.AssetExchange;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.ApiException;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;

public class GetAssetHandler implements GrpcApiHandler<CoreApi.GetByIdRequest, CoreApi.Asset> {

    private final AssetExchange assetExchange;

    public GetAssetHandler(AssetExchange assetExchange) {
        this.assetExchange = assetExchange;
    }

    @Override
    public CoreApi.Asset handleRequest(CoreApi.GetByIdRequest getByIdRequest) throws Exception {
        Asset asset = assetExchange.getAsset(getByIdRequest.getId());
        if (asset == null) throw new ApiException("Could not find asset");
        return ProtoBuilder.buildAsset(assetExchange, asset);
    }
}
