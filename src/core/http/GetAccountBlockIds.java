package core.http;

import core.Account;
import core.Block;
import core.Blockchain;
import core.Pc365Exception;
import core.services.ParameterService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;

import static core.http.common.Parameters.*;
import static core.http.common.ResultFields.BLOCK_IDS_RESPONSE;

public final class GetAccountBlockIds extends APIServlet.JsonRequestHandler {

  private final ParameterService parameterService;
  private final Blockchain blockchain;

  GetAccountBlockIds(ParameterService parameterService, Blockchain blockchain) {
    super(new APITag[] {APITag.ACCOUNTS}, ACCOUNT_PARAMETER, TIMESTAMP_PARAMETER, FIRST_INDEX_PARAMETER, LAST_INDEX_PARAMETER);
    this.parameterService = parameterService;
    this.blockchain = blockchain;
  }

  @Override
  JsonElement processRequest(HttpServletRequest req) throws Pc365Exception {
    Account account = parameterService.getAccount(req);

    int timestamp = ParameterParser.getTimestamp(req);
    int firstIndex = ParameterParser.getFirstIndex(req);
    int lastIndex = ParameterParser.getLastIndex(req);

    JsonArray blockIds = new JsonArray();
    for (Block block : blockchain.getBlocks(account, timestamp, firstIndex, lastIndex)) {
      blockIds.add(block.getStringId());
    }

    JsonObject response = new JsonObject();
    response.add(BLOCK_IDS_RESPONSE, blockIds);

    return response;
  }

}
