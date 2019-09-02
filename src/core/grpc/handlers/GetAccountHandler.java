package core.grpc.handlers;

import core.Account;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.ApiException;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import core.services.AccountService;

public class GetAccountHandler implements GrpcApiHandler<CoreApi.GetAccountRequest, CoreApi.Account> {
    private final AccountService accountService;

    public GetAccountHandler(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public CoreApi.Account handleRequest(CoreApi.GetAccountRequest request) throws Exception {
        Account account;
        try {
            account = accountService.getAccount(request.getAccountId());
            if (account == null) throw new NullPointerException();
        } catch (RuntimeException e) {
            throw new ApiException("Could not find account");
        }
        return ProtoBuilder.buildAccount(account, accountService);
    }
}
