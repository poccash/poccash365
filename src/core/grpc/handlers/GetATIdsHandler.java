package core.grpc.handlers;

import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import core.services.ATService;
import com.google.protobuf.Empty;

public class GetATIdsHandler implements GrpcApiHandler<Empty, CoreApi.ATIds> {

    private final ATService atService;

    public GetATIdsHandler(ATService atService) {
        this.atService = atService;
    }

    @Override
    public CoreApi.ATIds handleRequest(Empty empty) throws Exception {
        return CoreApi.ATIds.newBuilder()
                .addAllIds(atService.getAllATIds())
                .build();
    }
}
