package core.grpc.handlers;

import core.Alias;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import core.services.AliasService;
import core.util.FilteringIterator;

public class GetAliasesHandler implements GrpcApiHandler<CoreApi.GetAliasesRequest, CoreApi.Aliases> {

    private final AliasService aliasService;

    public GetAliasesHandler(AliasService aliasService) {
        this.aliasService = aliasService;
    }

    @Override
    public CoreApi.Aliases handleRequest(CoreApi.GetAliasesRequest getAliasesRequest) throws Exception {
        final int timestamp = getAliasesRequest.getTimestamp();
        final long accountId = getAliasesRequest.getOwner();
        int firstIndex = getAliasesRequest.getIndexRange().getFirstIndex();
        int lastIndex = getAliasesRequest.getIndexRange().getLastIndex();
        CoreApi.Aliases.Builder aliases = CoreApi.Aliases.newBuilder();
        FilteringIterator<Alias> aliasIterator = new FilteringIterator<>(aliasService.getAliasesByOwner(accountId, 0, -1), alias -> alias.getTimestamp() >= timestamp, firstIndex, lastIndex);
        while (aliasIterator.hasNext()) {
            final Alias alias = aliasIterator.next();
            final Alias.Offer offer = aliasService.getOffer(alias);
            aliases.addAliases(ProtoBuilder.buildAlias(alias, offer));
        }
        return aliases.build();
    }
}
