package core.grpc.handlers;

import core.Subscription;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.ApiException;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import core.services.SubscriptionService;

public class GetSubscriptionHandler implements GrpcApiHandler<CoreApi.GetByIdRequest, CoreApi.Subscription> {

    private final SubscriptionService subscriptionService;

    public GetSubscriptionHandler(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @Override
    public CoreApi.Subscription handleRequest(CoreApi.GetByIdRequest request) throws Exception {
        long subscriptionId = request.getId();
        Subscription subscription = subscriptionService.getSubscription(subscriptionId);
        if (subscription == null) throw new ApiException("Could not find subscription");
        return ProtoBuilder.buildSubscription(subscription);
    }
}
