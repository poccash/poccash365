package core.grpc.handlers;

import core.Constants;
import core.Genesis;
import core.TransactionType;
import core.fluxcapacitor.FluxCapacitor;
import core.fluxcapacitor.FluxValues;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.CoreApi;
import com.google.protobuf.Empty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GetConstantsHandler implements GrpcApiHandler<Empty, CoreApi.Constants> {

    private final CoreApi.Constants constants;

    public GetConstantsHandler(FluxCapacitor fluxCapacitor) {
        List<CoreApi.Constants.TransactionType> transactionTypes = new ArrayList<>();
        TransactionType.getTransactionTypes()
                .forEach((key, value) -> transactionTypes
                        .add(CoreApi.Constants.TransactionType.newBuilder()
                                .setType(key)
                                .setDescription(TransactionType.getTypeDescription(key))
                                .addAllSubtypes(value.entrySet().stream()
                                        .map(entry -> CoreApi.Constants.TransactionType.TransactionSubtype.newBuilder()
                                                .setSubtype(entry.getKey())
                                                .setDescription(entry.getValue().getDescription())
                                                .build())
                                        .collect(Collectors.toList()))
                                .build()));

        this.constants =  CoreApi.Constants.newBuilder()
                .setGenesisBlock(Genesis.GENESIS_BLOCK_ID)
                .setGenesisAccount(Genesis.CREATOR_ID)
                .setMaxBlockPayloadLength(fluxCapacitor.getValue(FluxValues.MAX_PAYLOAD_LENGTH))
                .setMaxArbitraryMessageLength(Constants.MAX_ARBITRARY_MESSAGE_LENGTH)
                .addAllTransactionTypes(transactionTypes)
                .build();
    }

    @Override
    public CoreApi.Constants handleRequest(Empty empty) throws Exception {
        return constants;
    }
}
