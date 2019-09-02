package core.http;

import core.Block;
import core.Blockchain;
import core.BlockchainProcessor;
import core.Pc365;
import core.peer.Peer;
import core.services.TimeService;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;

import static core.http.common.ResultFields.TIME_RESPONSE;

final class GetBlockchainStatus extends APIServlet.JsonRequestHandler {

  private final BlockchainProcessor blockchainProcessor;
  private final Blockchain blockchain;
  private final TimeService timeService;

  GetBlockchainStatus(BlockchainProcessor blockchainProcessor, Blockchain blockchain, TimeService timeService) {
    super(new APITag[]{APITag.BLOCKS, APITag.INFO});
    this.blockchainProcessor = blockchainProcessor;
    this.blockchain = blockchain;
    this.timeService = timeService;
  }

  @Override
  JsonElement processRequest(HttpServletRequest req) {
    JsonObject response = new JsonObject();
    response.addProperty("application", Pc365.APPLICATION);
    response.addProperty("version", Pc365.VERSION.toString());
    response.addProperty(TIME_RESPONSE, timeService.getEpochTime());
    Block lastBlock = blockchain.getLastBlock();
    response.addProperty("lastBlock", lastBlock.getStringId());
    response.addProperty("cumulativeDifficulty", lastBlock.getCumulativeDifficulty().toString());
    response.addProperty("numberOfBlocks", lastBlock.getHeight() + 1);
    Peer lastBlockchainFeeder = blockchainProcessor.getLastBlockchainFeeder();
    response.addProperty("lastBlockchainFeeder", lastBlockchainFeeder == null ? null : lastBlockchainFeeder.getAnnouncedAddress());
    response.addProperty("lastBlockchainFeederHeight", blockchainProcessor.getLastBlockchainFeederHeight());
    response.addProperty("isScanning", blockchainProcessor.isScanning());
    return response;
  }

}
