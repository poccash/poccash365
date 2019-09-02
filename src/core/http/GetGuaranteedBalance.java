package core.http;

import core.Account;
import core.Pc365Exception;
import core.services.ParameterService;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServletRequest;

import static core.http.common.Parameters.ACCOUNT_PARAMETER;
import static core.http.common.Parameters.NUMBER_OF_CONFIRMATIONS_PARAMETER;
import static core.http.common.ResultFields.GUARANTEED_BALANCE_NQT_RESPONSE;

/**
 * @deprecated This call is superseded by GetBalance which does what this does and more.
 */
@Deprecated
public final class GetGuaranteedBalance extends APIServlet.JsonRequestHandler {

    private final ParameterService parameterService;

    @Deprecated
    GetGuaranteedBalance(ParameterService parameterService) {
        super(new APITag[] {APITag.ACCOUNTS}, ACCOUNT_PARAMETER, NUMBER_OF_CONFIRMATIONS_PARAMETER);
        this.parameterService = parameterService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws Pc365Exception {
        Account account = parameterService.getAccount(req);
        JsonObject response = new JsonObject();
        if (account == null) {
            response.addProperty(GUARANTEED_BALANCE_NQT_RESPONSE, "0");
        } else {
            response.addProperty(GUARANTEED_BALANCE_NQT_RESPONSE, String.valueOf(account.getBalanceNQT()));
        }
        return response;
    }

}