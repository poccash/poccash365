package core.grpc.handlers;

import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import core.services.SubscriptionService;

public class GetAccountSubscriptionsHandler implements GrpcApiHandler<CoreApi.GetAccountRequest, CoreApi.Subscriptions> {

    private final SubscriptionService subscriptionService;

    public GetAccountSubscriptionsHandler(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @Override
    public CoreApi.Subscriptions handleRequest(CoreApi.GetAccountRequest request) throws Exception {
        long accountId = request.getAccountId();
        CoreApi.Subscriptions.Builder builder = CoreApi.Subscriptions.newBuilder();
        subscriptionService.getSubscriptionsByParticipant(accountId)
                .forEach(subscription -> builder.addSubscriptions(ProtoBuilder.buildSubscription(subscription)));
        return builder.build();
    }
}
