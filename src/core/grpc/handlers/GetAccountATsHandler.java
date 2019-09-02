package core.grpc.handlers;

import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import core.services.ATService;
import core.services.AccountService;

import java.util.stream.Collectors;

public class GetAccountATsHandler implements GrpcApiHandler<CoreApi.GetAccountRequest, CoreApi.AccountATs> {

    private final ATService atService;
    private final AccountService accountService;

    public GetAccountATsHandler(ATService atService, AccountService accountService) {
        this.atService = atService;
        this.accountService = accountService;
    }

    @Override
    public CoreApi.AccountATs handleRequest(CoreApi.GetAccountRequest getAccountRequest) throws Exception {
        return CoreApi.AccountATs.newBuilder()
                .addAllAts(atService.getATsIssuedBy(getAccountRequest.getAccountId())
                        .stream()
                        .map(atService::getAT)
                        .map(at -> ProtoBuilder.buildAT(accountService, at))
                        .collect(Collectors.toList()))
                .build();
    }
}
