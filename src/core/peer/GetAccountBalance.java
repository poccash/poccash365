package core.peer;

import core.Account;
import core.services.AccountService;
import core.util.Convert;
import core.util.JSON;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * @deprecated This call is no longer made by the other peers so will soon be removed.
 */
@Deprecated
public class GetAccountBalance implements PeerServlet.PeerRequestHandler {

  private final AccountService accountService;

  static final String ACCOUNT_ID_PARAMETER_FIELD = "account";
  static final String BALANCE_NQT_RESPONSE_FIELD = "balanceNQT";

  @Deprecated
  GetAccountBalance(AccountService accountService) {
    this.accountService = accountService;
  }

  @Override
  public JsonElement processRequest(JsonObject request, Peer peer) {

    JsonObject response = new JsonObject();

    Long accountId = Convert.parseAccountId(JSON.getAsString(request.get(ACCOUNT_ID_PARAMETER_FIELD)));
    Account account = accountService.getAccount(accountId);
    if (account != null) {
      response.addProperty(BALANCE_NQT_RESPONSE_FIELD, Convert.toUnsignedLong(account.getBalanceNQT()));
    } else {
      response.addProperty(BALANCE_NQT_RESPONSE_FIELD, "0");
    }

    return response;
  }
}
