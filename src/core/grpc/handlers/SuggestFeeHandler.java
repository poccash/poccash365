package core.grpc.handlers;

import core.feesuggestions.FeeSuggestion;
import core.feesuggestions.FeeSuggestionCalculator;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import com.google.protobuf.Empty;

public class SuggestFeeHandler implements GrpcApiHandler<Empty, CoreApi.FeeSuggestion> {

    private final FeeSuggestionCalculator feeSuggestionCalculator;

    public SuggestFeeHandler(FeeSuggestionCalculator feeSuggestionCalculator) {
        this.feeSuggestionCalculator = feeSuggestionCalculator;
    }

    @Override
    public CoreApi.FeeSuggestion handleRequest(Empty empty) throws Exception {
        FeeSuggestion feeSuggestion = feeSuggestionCalculator.giveFeeSuggestion();
        return CoreApi.FeeSuggestion.newBuilder()
                .setCheap(feeSuggestion.getCheapFee())
                .setStandard(feeSuggestion.getStandardFee())
                .setPriority(feeSuggestion.getPriorityFee())
                .build();
    }
}
