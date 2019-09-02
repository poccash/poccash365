package core.grpc.handlers;

import core.grpc.GrpcApiHandler;
import core.grpc.proto.ApiException;
import core.grpc.proto.CoreApi;
import core.peer.Peer;
import core.peer.Peers;

public class GetPeerHandler implements GrpcApiHandler<CoreApi.GetPeerRequest, CoreApi.Peer> {
    @Override
    public CoreApi.Peer handleRequest(CoreApi.GetPeerRequest getPeerRequest) throws Exception {
        Peer peer = Peers.getPeer(getPeerRequest.getPeerAddress());
        if (peer == null) throw new ApiException("Could not find peer");
        return CoreApi.Peer.newBuilder()
                .setState(peer.getState().toProtobuf())
                .setAnnouncedAddress(peer.getAnnouncedAddress())
                .setShareAddress(peer.shareAddress())
                .setDownloadedVolume(peer.getDownloadedVolume())
                .setUploadedVolume(peer.getUploadedVolume())
                .setApplication(peer.getApplication())
                .setVersion(peer.getVersion().toStringIfNotEmpty())
                .setPlatform(peer.getPlatform())
                .setBlacklisted(peer.isBlacklisted())
                .setLastUpdated(peer.getLastUpdated())
                .build();
    }
}
