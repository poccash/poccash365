package core.grpc.handlers;

import core.Block;
import core.Blockchain;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.ApiException;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import core.services.BlockService;

public class GetBlockHandler implements GrpcApiHandler<CoreApi.GetBlockRequest, CoreApi.Block> {

    private final Blockchain blockchain;
    private final BlockService blockService;

    public GetBlockHandler(Blockchain blockchain, BlockService blockService) {
        this.blockchain = blockchain;
        this.blockService = blockService;
    }

    @Override
    public CoreApi.Block handleRequest(CoreApi.GetBlockRequest request) throws Exception {
        long blockId = request.getBlockId();
        int blockHeight = request.getHeight();
        int timestamp = request.getTimestamp();

        Block block;
        if (blockId > 0) {
            try {
                block = blockchain.getBlock(blockId);
            } catch (RuntimeException e) {
                throw new ApiException("Incorrect Block ID");
            }
        } else if (blockHeight > 0) {
            try {
                if (blockHeight > blockchain.getHeight()) {
                    throw new ApiException("Incorrect Block Height");
                }
                block = blockchain.getBlockAtHeight(blockHeight);
            } catch (RuntimeException e) {
                throw new ApiException("Incorrect Block Height");
            }
        } else if (timestamp > 0) {
            try {
                block = blockchain.getLastBlock(timestamp);
            } catch (RuntimeException e) {
                throw new ApiException("Incorrect Timestamp");
            }
        } else {
            block = blockchain.getLastBlock();
        }

        if (block == null) {
            throw new ApiException("Unknown Block");
        }

        boolean includeTransactions = request.getIncludeTransactions();

        return ProtoBuilder.buildBlock(blockchain, blockService, block, includeTransactions);
    }
}
