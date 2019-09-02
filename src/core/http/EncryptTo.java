package core.http;

import core.Account;
import core.Pc365Exception;
import core.crypto.EncryptedData;
import core.services.AccountService;
import core.services.ParameterService;
import com.google.gson.JsonElement;

import javax.servlet.http.HttpServletRequest;

import static core.http.JSONResponses.INCORRECT_RECIPIENT;
import static core.http.common.Parameters.*;

final class EncryptTo extends APIServlet.JsonRequestHandler {

  private final ParameterService parameterService;
  private final AccountService accountService;

  EncryptTo(ParameterService parameterService, AccountService accountService) {
    super(new APITag[]{APITag.MESSAGES}, RECIPIENT_PARAMETER, MESSAGE_TO_ENCRYPT_PARAMETER, MESSAGE_TO_ENCRYPT_IS_TEXT_PARAMETER, SECRET_PHRASE_PARAMETER);
    this.parameterService = parameterService;
    this.accountService = accountService;
  }

  @Override
  JsonElement processRequest(HttpServletRequest req) throws Pc365Exception {

    long recipientId = ParameterParser.getRecipientId(req);
    Account recipientAccount = accountService.getAccount(recipientId);
    if (recipientAccount == null || recipientAccount.getPublicKey() == null) {
      return INCORRECT_RECIPIENT;
    }

    EncryptedData encryptedData = parameterService.getEncryptedMessage(req, recipientAccount, recipientAccount.getPublicKey());
    return JSONData.encryptedData(encryptedData);

  }

}
