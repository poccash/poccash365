package core.grpc.handlers;

import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import core.peer.Peer;
import core.peer.Peers;

public class GetPeersHandler implements GrpcApiHandler<CoreApi.GetPeersRequest, CoreApi.Peers> {
    @Override
    public CoreApi.Peers handleRequest(CoreApi.GetPeersRequest getPeersRequest) throws Exception {
        boolean active = getPeersRequest.getActive();
        CoreApi.PeerState peerState = getPeersRequest.getState();
        CoreApi.Peers.Builder peers = CoreApi.Peers.newBuilder();
        for (Peer peer : active ? Peers.getActivePeers() : peerState == CoreApi.PeerState.PeerState_UNSET ? Peers.getAllPeers() : Peers.getPeers(Peer.State.fromProtobuf(peerState))) {
            peers.addPeerAddresses(peer.getAnnouncedAddress());
        }
        return peers.build();
    }
}
