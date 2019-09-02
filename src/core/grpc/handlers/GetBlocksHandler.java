package core.grpc.handlers;

import core.Blockchain;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import core.services.BlockService;

public class GetBlocksHandler implements GrpcApiHandler<CoreApi.GetBlocksRequest, CoreApi.Blocks> {

    private final Blockchain blockchain;
    private final BlockService blockService;

    public GetBlocksHandler(Blockchain blockchain, BlockService blockService) {
        this.blockchain = blockchain;
        this.blockService = blockService;
    }

    @Override
    public CoreApi.Blocks handleRequest(CoreApi.GetBlocksRequest request) throws Exception {
        CoreApi.IndexRange indexRange = ProtoBuilder.sanitizeIndexRange(request.getIndexRange());
        int firstIndex = indexRange.getFirstIndex();
        int lastIndex = indexRange.getLastIndex();
        boolean includeTransactions = request.getIncludeTransactions();
        CoreApi.Blocks.Builder builder = CoreApi.Blocks.newBuilder();
        blockchain.getBlocks(firstIndex, lastIndex)
                .forEach(block -> builder.addBlocks(ProtoBuilder.buildBlock(blockchain, blockService, block, includeTransactions)));
        return builder.build();
    }
}
