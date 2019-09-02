package core.grpc.handlers;

import core.Asset;
import core.Trade;
import core.assetexchange.AssetExchange;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;

import java.util.Collection;

public class GetAssetTradesHandler implements GrpcApiHandler<CoreApi.GetAssetTransfersRequest, CoreApi.AssetTrades> {

    private final AssetExchange assetExchange;

    public GetAssetTradesHandler(AssetExchange assetExchange) {
        this.assetExchange = assetExchange;
    }

    @Override
    public CoreApi.AssetTrades handleRequest(CoreApi.GetAssetTransfersRequest request) throws Exception {
        long accountId = request.getAccount();
        long assetId = request.getAsset();
        CoreApi.IndexRange indexRange = ProtoBuilder.sanitizeIndexRange(request.getIndexRange());
        int firstIndex = indexRange.getFirstIndex();
        int lastIndex = indexRange.getLastIndex();
        Collection<Trade> trades;
        Asset asset = assetExchange.getAsset(assetId);
        if (accountId == 0) {
            trades = assetExchange.getTrades(assetId, firstIndex, lastIndex);
        } else if (assetId == 0) {
            trades = assetExchange.getAccountTrades(accountId, firstIndex, lastIndex);
        } else {
            trades = assetExchange.getAccountAssetTrades(accountId, assetId, firstIndex, lastIndex);
        }
        CoreApi.AssetTrades.Builder builder = CoreApi.AssetTrades.newBuilder();
        trades.forEach(trade -> builder.addTrades(ProtoBuilder.buildTrade(trade, asset == null ? assetExchange.getAsset(trade.getAssetId()) : asset)));
        return builder.build();
    }
}
