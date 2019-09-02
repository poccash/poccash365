package core.grpc.handlers;

import core.*;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import core.peer.Peer;
import core.peer.Peers;
import core.props.PropertyService;
import core.props.Props;
import core.services.TimeService;
import com.google.protobuf.Empty;

public class GetStateHandler implements GrpcApiHandler<Empty, CoreApi.State> {

    private final TimeService timeService;
    private final Blockchain blockchain;
    private final Generator generator;
    private final BlockchainProcessor blockchainProcessor;
    private final PropertyService propertyService;

    public GetStateHandler(TimeService timeService, Blockchain blockchain, Generator generator, BlockchainProcessor blockchainProcessor, PropertyService propertyService) {
        this.timeService = timeService;
        this.blockchain = blockchain;
        this.generator = generator;
        this.blockchainProcessor = blockchainProcessor;
        this.propertyService = propertyService;
    }

    @Override
    public CoreApi.State handleRequest(Empty empty) throws Exception {
        Block lastBlock = blockchain.getLastBlock();
        Peer lastBlockchainFeeder = blockchainProcessor.getLastBlockchainFeeder();
        return CoreApi.State.newBuilder()
                .setApplication(Pc365.APPLICATION)
                .setVersion(Pc365.VERSION.toString())
                .setTime(CoreApi.Time.newBuilder().setTime(timeService.getEpochTime()).build())
                .setLastBlock(lastBlock.getId())
                .setLastHeight(blockchain.getHeight())
                .setCumulativeDifficulty(lastBlock.getCumulativeDifficulty().toString())
                .setNumberOfPeers(Peers.getAllPeers().size())
                .setNumberOfActivePeers(Peers.getActivePeers().size())
                .setNumberOfForgers(generator.getAllGenerators().size())
                .setLastBlockchainFeeder(lastBlockchainFeeder == null ? "null" : lastBlockchainFeeder.getAnnouncedAddress())
                .setLastBlockchainFeederHeight(blockchainProcessor.getLastBlockchainFeederHeight())
                .setIsScanning(blockchainProcessor.isScanning())
                .setAvailableProcessors(Runtime.getRuntime().availableProcessors())
                .setMaxMemory(Runtime.getRuntime().maxMemory())
                .setTotalMemory(Runtime.getRuntime().totalMemory())
                .setFreeMemory(Runtime.getRuntime().freeMemory())
                .setIndirectIncomingServiceEnabled(propertyService.getBoolean(Props.INDIRECT_INCOMING_SERVICE_ENABLE))
                .build();
    }
}
