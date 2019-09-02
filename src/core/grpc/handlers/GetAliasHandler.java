package core.grpc.handlers;

import core.Alias;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.ApiException;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import core.services.AliasService;

public class GetAliasHandler implements GrpcApiHandler<CoreApi.GetAliasRequest, CoreApi.Alias> {

    private final AliasService aliasService;

    public GetAliasHandler(AliasService aliasService) {
        this.aliasService = aliasService;
    }

    @Override
    public CoreApi.Alias handleRequest(CoreApi.GetAliasRequest getAliasRequest) throws Exception {
        Alias alias = getAliasRequest.getName().equals("") ? aliasService.getAlias(getAliasRequest.getId()) : aliasService.getAlias(getAliasRequest.getName());
        if (alias == null) throw new ApiException("Alias not found");
        return ProtoBuilder.buildAlias(alias, aliasService.getOffer(alias));
    }
}
