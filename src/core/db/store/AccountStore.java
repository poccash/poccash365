package core.db.store;

import core.Account;
import core.db.Pc365Key;
import core.db.VersionedBatchEntityTable;
import core.db.VersionedEntityTable;

import java.util.Collection;

/**
 * Interface for Database operations related to Accounts
 */
public interface AccountStore {

  VersionedBatchEntityTable<Account> getAccountTable();

  VersionedEntityTable<Account.RewardRecipientAssignment> getRewardRecipientAssignmentTable();

  Pc365Key.LongKeyFactory<Account.RewardRecipientAssignment> getRewardRecipientAssignmentKeyFactory();

  Pc365Key.LinkKeyFactory<Account.AccountAsset> getAccountAssetKeyFactory();

  VersionedEntityTable<Account.AccountAsset> getAccountAssetTable();

  int getAssetAccountsCount(long assetId);

  Pc365Key.LongKeyFactory<Account> getAccountKeyFactory();

  Collection<Account.RewardRecipientAssignment> getAccountsWithRewardRecipient(Long recipientId);

  Collection<Account.AccountAsset> getAssets(int from, int to, Long id);

  Collection<Account.AccountAsset> getAssetAccounts(long assetId, int from, int to);

  Collection<Account.AccountAsset> getAssetAccounts(long assetId, int height, int from, int to);
  // returns true iff:
  // this.publicKey is set to null (in which case this.publicKey also gets set to key)
  // or
  // this.publicKey is already set to an array equal to key
  boolean setOrVerify(Account acc, byte[] key, int height);
}
