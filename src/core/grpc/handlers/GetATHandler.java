package core.grpc.handlers;

import core.at.AT;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.ApiException;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import core.services.ATService;
import core.services.AccountService;

public class GetATHandler implements GrpcApiHandler<CoreApi.GetByIdRequest, CoreApi.AT> {

    private final ATService atService;
    private final AccountService accountService;

    public GetATHandler(ATService atService, AccountService accountService) {
        this.atService = atService;
        this.accountService = accountService;
    }

    @Override
    public CoreApi.AT handleRequest(CoreApi.GetByIdRequest getATRequest) throws Exception {
        AT at = atService.getAT(getATRequest.getId());
        if (at == null) throw new ApiException("AT not found");
        return ProtoBuilder.buildAT(accountService, at);
    }
}
