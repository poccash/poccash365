package core.http;

import core.Account;
import core.Attachment;
import core.Pc365Exception;
import com.google.gson.JsonElement;

import javax.servlet.http.HttpServletRequest;

public interface APITransactionManager {

  JsonElement createTransaction(HttpServletRequest req, Account senderAccount, Long recipientId, long amountNQT, Attachment attachment, long minimumFeeNQT) throws Pc365Exception;

}
