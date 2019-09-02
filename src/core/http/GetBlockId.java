package core.http;

import core.Blockchain;
import core.util.Convert;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;

import static core.http.JSONResponses.INCORRECT_HEIGHT;
import static core.http.JSONResponses.MISSING_HEIGHT;
import static core.http.common.Parameters.HEIGHT_PARAMETER;

final class GetBlockId extends APIServlet.JsonRequestHandler {

  private final Blockchain blockchain;

  GetBlockId(Blockchain blockchain) {
    super(new APITag[] {APITag.BLOCKS}, HEIGHT_PARAMETER);
    this.blockchain = blockchain;
  }

  @Override
  JsonElement processRequest(HttpServletRequest req) {

    int height;
    try {
      String heightValue = Convert.emptyToNull(req.getParameter(HEIGHT_PARAMETER));
      if (heightValue == null) {
        return MISSING_HEIGHT;
      }
      height = Integer.parseInt(heightValue);
    } catch (RuntimeException e) {
      return INCORRECT_HEIGHT;
    }

    try {
      JsonObject response = new JsonObject();
      response.addProperty("block", Convert.toUnsignedLong(blockchain.getBlockIdAtHeight(height)));
      return response;
    } catch (RuntimeException e) {
      return INCORRECT_HEIGHT;
    }

  }

}
