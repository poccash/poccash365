package core.grpc.handlers;

import core.Account;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import core.services.AccountService;

import java.util.Collection;
import java.util.Objects;

public class GetAccountsHandler implements GrpcApiHandler<CoreApi.GetAccountsRequest, CoreApi.Accounts> {

    private final AccountService accountService;

    public GetAccountsHandler(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public CoreApi.Accounts handleRequest(CoreApi.GetAccountsRequest request) throws Exception {
        CoreApi.Accounts.Builder builder = CoreApi.Accounts.newBuilder();
        if (!Objects.equals(request.getName(), "")) {
            Collection<Account> accounts = accountService.getAccountsWithName(request.getName());
            accounts.forEach(account -> builder.addIds(account.getId()));
            if (request.getIncludeAccounts()) {
                accounts.forEach(account -> builder.addAccounts(ProtoBuilder.buildAccount(account, accountService)));
            }
        }
        if (request.getRewardRecipient() != 0) {
            Collection<Account.RewardRecipientAssignment> accounts = accountService.getAccountsWithRewardRecipient(request.getRewardRecipient());
            accounts.forEach(assignment -> builder.addIds(assignment.getAccountId()));
            if (request.getIncludeAccounts()) {
                accounts.forEach(assignment -> builder.addAccounts(ProtoBuilder.buildAccount(accountService.getAccount(assignment.getAccountId()), accountService)));
            }
        }
        return builder.build();
    }
}
