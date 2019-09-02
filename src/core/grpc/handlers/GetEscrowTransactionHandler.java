package core.grpc.handlers;

import core.Escrow;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.ApiException;
import core.grpc.proto.CoreApi;
import core.grpc.proto.ProtoBuilder;
import core.services.EscrowService;

public class GetEscrowTransactionHandler implements GrpcApiHandler<CoreApi.GetByIdRequest, CoreApi.EscrowTransaction> {

    private final EscrowService escrowService;

    public GetEscrowTransactionHandler(EscrowService escrowService) {
        this.escrowService = escrowService;
    }

    @Override
    public CoreApi.EscrowTransaction handleRequest(CoreApi.GetByIdRequest request) throws Exception {
        long escrowId = request.getId();
        Escrow escrow = escrowService.getEscrowTransaction(escrowId);
        if (escrow == null) throw new ApiException("Could not find escrow");
        return ProtoBuilder.buildEscrowTransaction(escrow);
    }
}
