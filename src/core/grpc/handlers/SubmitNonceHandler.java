package core.grpc.handlers;

import core.Account;
import core.Blockchain;
import core.Generator;
import core.crypto.Crypto;
import core.grpc.GrpcApiHandler;
import core.grpc.proto.ApiException;
import core.grpc.proto.CoreApi;
import core.props.PropertyService;
import core.props.Props;
import core.services.AccountService;
import pc365.kit.crypto.Pc365Crypto;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SubmitNonceHandler implements GrpcApiHandler<CoreApi.SubmitNonceRequest, CoreApi.SubmitNonceResponse> {
    private final Blockchain blockchain;
    private final AccountService accountService;
    private final Generator generator;
    private final Map<Long, String> passphrases;
    private final boolean allowOtherSoloMiners;

    public SubmitNonceHandler(PropertyService propertyService, Blockchain blockchain, AccountService accountService, Generator generator) {
        this.blockchain = blockchain;
        this.accountService = accountService;
        this.generator = generator;

        this.passphrases = propertyService.getStringList(Props.SOLO_MINING_PASSPHRASES)
                .stream()
                .collect(Collectors.toMap(passphrase -> Pc365Crypto.getInstance().getPc365AddressFromPassphrase(passphrase).getPc365ID().getSignedLongId(), Function.identity()));
        this.allowOtherSoloMiners = propertyService.getBoolean(Props.ALLOW_OTHER_SOLO_MINERS);
    }

    @Override
    public CoreApi.SubmitNonceResponse handleRequest(CoreApi.SubmitNonceRequest request) throws Exception {
        String secret = request.getSecretPhrase();
        long nonce = request.getNonce();
        long accountId = request.getAccount();
        int submissionHeight = request.getBlockHeight();

        if (submissionHeight != 0 && submissionHeight != blockchain.getHeight() + 1) {
            throw new ApiException("Given block height does not match current blockchain height");
        }

        if (Objects.equals(secret, "")) {
            if (passphrases.containsKey(accountId)) {
                secret = passphrases.get(accountId);
            } else {
                throw new ApiException("Missing Passphrase and account passphrase not in solo mining config");
            }
        }

        if (!allowOtherSoloMiners && !passphrases.containsValue(secret)) {
            throw new ApiException("This account is not allowed to mine on this node as the whitelist is enabled and it is not whitelisted.");
        }

        byte[] secretPublicKey = Crypto.getPublicKey(secret);
        Account secretAccount = accountService.getAccount(secretPublicKey);
        if(secretAccount != null) {
            verifySecretAccount(accountService, blockchain, secretAccount, accountId);
        }

        Generator.GeneratorState generatorState;
        if (accountId == 0 || secretAccount == null) {
            generatorState = generator.addNonce(secret, nonce);
        }
        else {
            Account genAccount = accountService.getAccount(accountId);
            if (genAccount == null || genAccount.getPublicKey() == null) {
                throw new ApiException("Passthrough mining requires public key in blockchain");
            }
            else {
                byte[] publicKey = genAccount.getPublicKey();
                generatorState = generator.addNonce(secret, nonce, publicKey);
            }
        }

        if (generatorState == null) {
            throw new ApiException("Failed to create generator");
        }

        return CoreApi.SubmitNonceResponse.newBuilder().setDeadline(generatorState.getDeadline().longValueExact()).build();
    }

    public static void verifySecretAccount(AccountService accountService, Blockchain blockchain, Account secretAccount, long accountId) throws ApiException {
        Account genAccount;
        if (accountId != 0) {
            genAccount = accountService.getAccount(accountId);
        }
        else {
            genAccount = secretAccount;
        }

        if (genAccount != null) {
            Account.RewardRecipientAssignment assignment = accountService.getRewardRecipientAssignment(genAccount);
            long rewardId;
            if (assignment == null) {
                rewardId = genAccount.getId();
            } else if (assignment.getFromHeight() > blockchain.getLastBlock().getHeight() + 1) {
                rewardId = assignment.getPrevRecipientId();
            } else {
                rewardId = assignment.getRecipientId();
            }
            if (rewardId != secretAccount.getId()) {
                throw new ApiException("Passphrase does not match reward recipient");
            }
        }
        else {
            throw new ApiException("Passphrase is for a different account");
        }
    }
}
