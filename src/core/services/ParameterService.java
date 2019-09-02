package core.services;

import core.*;
import core.at.AT;
import core.crypto.EncryptedData;
import core.http.ParameterException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ParameterService {

  Account getAccount(HttpServletRequest req) throws Pc365Exception;

  List<Account> getAccounts(HttpServletRequest req) throws ParameterException;

  Account getSenderAccount(HttpServletRequest req) throws ParameterException;

  Alias getAlias(HttpServletRequest req) throws ParameterException;

  Asset getAsset(HttpServletRequest req) throws ParameterException;

  DigitalGoodsStore.Goods getGoods(HttpServletRequest req) throws ParameterException;

  DigitalGoodsStore.Purchase getPurchase(HttpServletRequest req) throws ParameterException;

  EncryptedData getEncryptedMessage(HttpServletRequest req, Account recipientAccount, byte[] publicKey) throws ParameterException;

  EncryptedData getEncryptToSelfMessage(HttpServletRequest req) throws ParameterException;

  String getSecretPhrase(HttpServletRequest req) throws ParameterException;

  int getNumberOfConfirmations(HttpServletRequest req) throws ParameterException;

  int getHeight(HttpServletRequest req) throws ParameterException;

  Transaction parseTransaction(String transactionBytes, String transactionJSON) throws ParameterException;

  AT getAT(HttpServletRequest req) throws ParameterException;

  boolean getIncludeIndirect(HttpServletRequest req);
}
