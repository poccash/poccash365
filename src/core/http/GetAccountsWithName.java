package core.http;

import core.Account;
import core.Pc365Exception;
import core.services.AccountService;
import core.util.Convert;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

import static core.http.common.Parameters.ACCOUNTS_RESPONSE;
import static core.http.common.Parameters.NAME_PARAMETER;

public class GetAccountsWithName extends APIServlet.JsonRequestHandler {

    private final AccountService accountService;

    GetAccountsWithName(AccountService accountService) {
        super(new APITag[] {APITag.ACCOUNTS}, NAME_PARAMETER);
        this.accountService = accountService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest request) throws Pc365Exception {
        Collection<Account> accounts = accountService.getAccountsWithName(request.getParameter(NAME_PARAMETER));
        JsonArray accountIds = new JsonArray();

        for (Account account : accounts) {
            accountIds.add(Convert.toUnsignedLong(account.id));
        }

        JsonObject response = new JsonObject();
        response.add(ACCOUNTS_RESPONSE, accountIds);
        return response;
    }
}
