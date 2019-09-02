package core.services.impl;

import core.*;
import core.services.AccountService;
import core.services.TransactionService;

public class TransactionServiceImpl implements TransactionService {

  private final AccountService accountService;
  private final Blockchain blockchain;

  public TransactionServiceImpl(AccountService accountService, Blockchain blockchain) {
    this.accountService = accountService;
    this.blockchain = blockchain;
  }

  @Override
  public boolean verifyPublicKey(Transaction transaction) {
    Account account = accountService.getAccount(transaction.getSenderId());
    if (account == null) {
      return false;
    }
    if (transaction.getSignature() == null) {
      return false;
    }
    return account.setOrVerify(transaction.getSenderPublicKey(), transaction.getHeight());
  }

  @Override
  public void validate(Transaction transaction) throws Pc365Exception.ValidationException {
    for (Appendix.AbstractAppendix appendage : transaction.getAppendages()) {
      appendage.validate(transaction);
    }
    long minimumFeeNQT = transaction.getType().minimumFeeNQT(blockchain.getHeight(), transaction.getAppendagesSize());
    if (transaction.getFeeNQT() < minimumFeeNQT) {
      throw new Pc365Exception.NotCurrentlyValidException(String.format("Transaction fee %d less than minimum fee %d at height %d",
          transaction.getFeeNQT(), minimumFeeNQT, blockchain.getHeight()));
    }
  }

  @Override
  public boolean applyUnconfirmed(Transaction transaction) {
    Account senderAccount = accountService.getAccount(transaction.getSenderId());
    return senderAccount != null && transaction.getType().applyUnconfirmed(transaction, senderAccount);
  }

  @Override
  public void apply(Transaction transaction) {
    Account senderAccount = accountService.getAccount(transaction.getSenderId());
    senderAccount.apply(transaction.getSenderPublicKey(), transaction.getHeight());
    Account recipientAccount = accountService.getOrAddAccount(transaction.getRecipientId());
    for (Appendix.AbstractAppendix appendage : transaction.getAppendages()) {
      appendage.apply(transaction, senderAccount, recipientAccount);
    }
  }

  @Override
  public void undoUnconfirmed(Transaction transaction) {
    final Account senderAccount = accountService.getAccount(transaction.getSenderId());
    transaction.getType().undoUnconfirmed(transaction, senderAccount);
  }

}
