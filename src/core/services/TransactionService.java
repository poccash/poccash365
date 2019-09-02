package core.services;

import core.Pc365Exception;
import core.Transaction;

public interface TransactionService {

  boolean verifyPublicKey(Transaction transaction);

  void validate(Transaction transaction) throws Pc365Exception.ValidationException;

  boolean applyUnconfirmed(Transaction transaction);

  void apply(Transaction transaction);

  void undoUnconfirmed(Transaction transaction);
}
