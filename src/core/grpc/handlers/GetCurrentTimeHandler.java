package core.grpc.handlers;

import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import core.services.TimeService;
import com.google.protobuf.Empty;

public class GetCurrentTimeHandler implements GrpcApiHandler<Empty, CoreApi.Time> {

    private final TimeService timeService;

    public GetCurrentTimeHandler(TimeService timeService) {
        this.timeService = timeService;
    }

    @Override
    public CoreApi.Time handleRequest(Empty empty) {
        return CoreApi.Time.newBuilder()
                .setTime(timeService.getEpochTime())
                .build();
    }
}
