package core.http;

import com.google.gson.JsonElement;

import javax.servlet.http.HttpServletRequest;

import static core.http.common.Parameters.HEX_STRING_PARAMETER;

final class GetATLong extends APIServlet.JsonRequestHandler {

  static final GetATLong instance = new GetATLong();

  private GetATLong() {
    super(new APITag[] {APITag.AT}, HEX_STRING_PARAMETER);
  }

  @Override
  JsonElement processRequest(HttpServletRequest req) {
    return JSONData.hex2long(ParameterParser.getATLong(req));
  }

}
