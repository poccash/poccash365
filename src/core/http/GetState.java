package core.http;

import core.*;
import core.assetexchange.AssetExchange;
import core.peer.Peer;
import core.peer.Peers;
import core.props.PropertyService;
import core.props.Props;
import core.services.AccountService;
import core.services.AliasService;
import core.services.EscrowService;
import core.services.TimeService;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;

import static core.http.common.Parameters.INCLUDE_COUNTS_PARAMETER;
import static core.http.common.ResultFields.TIME_RESPONSE;

final class GetState extends APIServlet.JsonRequestHandler {

  private final Blockchain blockchain;
  private final AssetExchange assetExchange;
  private final AccountService accountService;
  private final EscrowService escrowService;
  private final AliasService aliasService;
  private final TimeService timeService;
  private final Generator generator;
  private final PropertyService propertyService;

  GetState(Blockchain blockchain, AssetExchange assetExchange, AccountService accountService, EscrowService escrowService,
           AliasService aliasService, TimeService timeService, Generator generator, PropertyService propertyService) {
    super(new APITag[] {APITag.INFO}, INCLUDE_COUNTS_PARAMETER);
    this.blockchain = blockchain;
    this.assetExchange = assetExchange;
    this.accountService = accountService;
    this.escrowService = escrowService;
    this.aliasService = aliasService;
    this.timeService = timeService;
    this.generator = generator;
    this.propertyService = propertyService;
  }

  @Override
  JsonElement processRequest(HttpServletRequest req) {

    JsonObject response = new JsonObject();

    response.addProperty("application", Pc365.APPLICATION);
    response.addProperty("version", Pc365.VERSION.toString());
    response.addProperty(TIME_RESPONSE, timeService.getEpochTime());
    response.addProperty("lastBlock", blockchain.getLastBlock().getStringId());
    response.addProperty("cumulativeDifficulty", blockchain.getLastBlock().getCumulativeDifficulty().toString());

    if (!"false".equalsIgnoreCase(req.getParameter("includeCounts"))) {
      long totalEffectiveBalance = 0;
      for (Account account : accountService.getAllAccounts(0, -1)) {
        long effectiveBalancePC365 = account.getBalanceNQT();
        if (effectiveBalancePC365 > 0) {
          totalEffectiveBalance += effectiveBalancePC365;
        }
      }
      for (Escrow escrow : escrowService.getAllEscrowTransactions()) {
        totalEffectiveBalance += escrow.getAmountNQT();
      }
      response.addProperty("totalEffectiveBalanceNXT", totalEffectiveBalance / Constants.ONE_PC365);

      response.addProperty("numberOfBlocks", blockchain.getHeight() + 1);
      response.addProperty("numberOfTransactions", blockchain.getTransactionCount());
      response.addProperty("numberOfAccounts", accountService.getCount());
      response.addProperty("numberOfAssets", assetExchange.getAssetsCount());
      int askCount = assetExchange.getAskCount();
      int bidCount = assetExchange.getBidCount();
      response.addProperty("numberOfOrders", askCount + bidCount);
      response.addProperty("numberOfAskOrders", askCount);
      response.addProperty("numberOfBidOrders", bidCount);
      response.addProperty("numberOfTrades", assetExchange.getTradesCount());
      response.addProperty("numberOfTransfers", assetExchange.getAssetTransferCount());
      response.addProperty("numberOfAliases", aliasService.getAliasCount());
    }
    response.addProperty("numberOfPeers", Peers.getAllPeers().size());
    response.addProperty("numberOfUnlockedAccounts", generator.getAllGenerators().size());
    Peer lastBlockchainFeeder = Pc365.getBlockchainProcessor().getLastBlockchainFeeder();
    response.addProperty("lastBlockchainFeeder", lastBlockchainFeeder == null ? null : lastBlockchainFeeder.getAnnouncedAddress());
    response.addProperty("lastBlockchainFeederHeight", Pc365.getBlockchainProcessor().getLastBlockchainFeederHeight());
    response.addProperty("isScanning", Pc365.getBlockchainProcessor().isScanning());
    response.addProperty("availableProcessors", Runtime.getRuntime().availableProcessors());
    response.addProperty("maxMemory", Runtime.getRuntime().maxMemory());
    response.addProperty("totalMemory", Runtime.getRuntime().totalMemory());
    response.addProperty("freeMemory", Runtime.getRuntime().freeMemory());
    response.addProperty("indirectIncomingServiceEnabled", propertyService.getBoolean(Props.INDIRECT_INCOMING_SERVICE_ENABLE));
    boolean grpcApiEnabled = propertyService.getBoolean(Props.API_V2_SERVER);
    response.addProperty("grpcApiEnabled", grpcApiEnabled);
    if (grpcApiEnabled) response.addProperty("grpcApiPort", propertyService.getInt(propertyService.getBoolean(Props.DEV_TESTNET) ? Props.DEV_API_V2_PORT : Props.API_V2_PORT));

    return response;
  }
}
