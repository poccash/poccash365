package core.grpc.handlers;

import core.Asset;
import core.AssetTransfer;
import core.assetexchange.AssetExchange;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import core.services.AccountService;

import java.util.Collection;

public class GetAssetTransfersHandler implements GrpcApiHandler<CoreApi.GetAssetTransfersRequest, CoreApi.AssetTransfers> {

    private final AssetExchange assetExchange;
    private final AccountService accountService;

    public GetAssetTransfersHandler(AssetExchange assetExchange, AccountService accountService) {
        this.assetExchange = assetExchange;
        this.accountService = accountService;
    }

    @Override
    public CoreApi.AssetTransfers handleRequest(CoreApi.GetAssetTransfersRequest request) throws Exception {
        long accountId = request.getAccount();
        long assetId = request.getAsset();
        CoreApi.IndexRange indexRange = ProtoBuilder.sanitizeIndexRange(request.getIndexRange());
        int firstIndex = indexRange.getFirstIndex();
        int lastIndex = indexRange.getLastIndex();
        Collection<AssetTransfer> transfers;
        Asset asset = assetExchange.getAsset(assetId);
        if (accountId == 0) {
            transfers = assetExchange.getAssetTransfers(asset.getId(), firstIndex, lastIndex);
        } else if (assetId == 0) {
            transfers = accountService.getAssetTransfers(accountId, firstIndex, lastIndex);
        } else {
            transfers = assetExchange.getAccountAssetTransfers(accountId, assetId, firstIndex, lastIndex);
        }
        CoreApi.AssetTransfers.Builder builder = CoreApi.AssetTransfers.newBuilder();
        transfers.forEach(transfer -> builder.addAssetTransfers(ProtoBuilder.buildTransfer(transfer, asset == null ? assetExchange.getAsset(transfer.getAssetId()) : asset)));
        return builder.build();
    }
}
