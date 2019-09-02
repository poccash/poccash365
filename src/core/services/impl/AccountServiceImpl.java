package core.services.impl;

import core.Account;
import core.Account.AccountAsset;
import core.Account.Event;
import core.Account.RewardRecipientAssignment;
import core.AssetTransfer;
import core.Pc365;
import core.Constants;
import core.crypto.Crypto;
import core.db.Pc365Key;
import core.db.Pc365Key.LinkKeyFactory;
import core.db.Pc365Key.LongKeyFactory;
import core.db.VersionedBatchEntityTable;
import core.db.VersionedEntityTable;
import core.db.store.AccountStore;
import core.db.store.AssetTransferStore;
import core.services.AccountService;
import core.util.Convert;
import core.util.Listener;
import core.util.Listeners;

import java.util.Arrays;
import java.util.Collection;

import static core.schema.Tables.ACCOUNT;

public class AccountServiceImpl implements AccountService {

  private final AccountStore accountStore;
  private final VersionedBatchEntityTable<Account> accountTable;
  private final LongKeyFactory<Account> accountPc365KeyFactory;
  private final VersionedEntityTable<AccountAsset> accountAssetTable;
  private final LinkKeyFactory<AccountAsset> accountAssetKeyFactory;
  private final VersionedEntityTable<RewardRecipientAssignment> rewardRecipientAssignmentTable;
  private final LongKeyFactory<RewardRecipientAssignment> rewardRecipientAssignmentKeyFactory;

  private final AssetTransferStore assetTransferStore;

  private final Listeners<Account, Event> listeners = new Listeners<>();
  private final Listeners<AccountAsset, Event> assetListeners = new Listeners<>();

  public AccountServiceImpl(AccountStore accountStore, AssetTransferStore assetTransferStore) {
    this.accountStore = accountStore;
    this.accountTable = accountStore.getAccountTable();
    this.accountPc365KeyFactory = accountStore.getAccountKeyFactory();
    this.assetTransferStore = assetTransferStore;
    this.accountAssetTable = accountStore.getAccountAssetTable();
    this.accountAssetKeyFactory = accountStore.getAccountAssetKeyFactory();
    this.rewardRecipientAssignmentTable = accountStore.getRewardRecipientAssignmentTable();
    this.rewardRecipientAssignmentKeyFactory = accountStore.getRewardRecipientAssignmentKeyFactory();
  }

  @Override
  public boolean addListener(Listener<Account> listener, Event eventType) {
    return listeners.addListener(listener, eventType);
  }

  @Override
  public boolean addAssetListener(Listener<AccountAsset> listener, Event eventType) {
    return assetListeners.addListener(listener, eventType);
  }

  @Override
  public Account getAccount(long id) {
    return id == 0 ? null : accountTable.get(accountPc365KeyFactory.newKey(id));
  }

  @Override
  public Account getAccount(long id, int height) {
    return id == 0 ? null : accountTable.get(accountPc365KeyFactory.newKey(id), height);
  }

  @Override
  public Account getAccount(byte[] publicKey) {
    final Account account = accountTable.get(accountPc365KeyFactory.newKey(getId(publicKey)));

    if (account == null) {
      return null;
    }

    if (account.getPublicKey() == null || Arrays.equals(account.getPublicKey(), publicKey)) {
      return account;
    }

    throw new RuntimeException("DUPLICATE KEY for account " + Convert.toUnsignedLong(account.getId())
        + " existing key " + Convert.toHexString(account.getPublicKey()) + " new key " + Convert.toHexString(publicKey));
  }

  @Override
  public Collection<AssetTransfer> getAssetTransfers(long accountId, int from, int to) {
    return assetTransferStore.getAccountAssetTransfers(accountId, from, to);
  }

  @Override
  public Collection<AccountAsset> getAssets(long accountId, int from, int to) {
    return accountStore.getAssets(from, to, accountId);
  }

  @Override
  public Collection<RewardRecipientAssignment> getAccountsWithRewardRecipient(Long recipientId) {
    return accountStore.getAccountsWithRewardRecipient(recipientId);
  }

  @Override
  public Collection<Account> getAccountsWithName(String name) {
    return accountTable.getManyBy(ACCOUNT.NAME.equalIgnoreCase(name), 0, -1);
  }

  @Override
  public Collection<Account> getAllAccounts(int from, int to) {
    return accountTable.getAll(from, to);
  }

  @Override
  public Account getOrAddAccount(long id) {
    Account account = accountTable.get(accountPc365KeyFactory.newKey(id));
    if (account == null) {
      account = new Account(id);
      accountTable.insert(account);
    }
    return account;
  }

  public static long getId(byte[] publicKey) {
    byte[] publicKeyHash = Crypto.sha256().digest(publicKey);
    return Convert.fullHashToId(publicKeyHash);
  }

  @Override
  public void flushAccountTable() {
    accountTable.finish();
  }

  @Override
  public int getCount() {
    return accountTable.getCount();
  }

  @Override
  public void addToForgedBalanceNQT(Account account, long amountNQT) {
    if (amountNQT == 0) {
      return;
    }
    account.setForgedBalanceNQT(Convert.safeAdd(account.getForgedBalanceNQT(), amountNQT));
    accountTable.insert(account);
  }

  @Override
  public void setAccountInfo(Account account, String name, String description) {
    account.setName(Convert.emptyToNull(name.trim()));
    account.setDescription(Convert.emptyToNull(description.trim()));
    accountTable.insert(account);
  }

  @Override
  public void addToAssetBalanceQNT(Account account, long assetId, long quantityQNT) {
    if (quantityQNT == 0) {
      return;
    }
    AccountAsset accountAsset;

    Pc365Key newKey = accountAssetKeyFactory.newKey(account.getId(), assetId);
    accountAsset = accountAssetTable.get(newKey);
    long assetBalance = accountAsset == null ? 0 : accountAsset.getQuantityQNT();
    assetBalance = Convert.safeAdd(assetBalance, quantityQNT);
    if (accountAsset == null) {
      accountAsset = new AccountAsset(newKey, account.getId(), assetId, assetBalance, 0);
    } else {
      accountAsset.setQuantityQNT(assetBalance);
    }
    saveAccountAsset(accountAsset);
    listeners.notify(account, Event.ASSET_BALANCE);
    assetListeners.notify(accountAsset, Event.ASSET_BALANCE);
  }

  @Override
  public void addToUnconfirmedAssetBalanceQNT(Account account, long assetId, long quantityQNT) {
    if (quantityQNT == 0) {
      return;
    }
    AccountAsset accountAsset;
    Pc365Key newKey = accountAssetKeyFactory.newKey(account.getId(), assetId);
    accountAsset = accountAssetTable.get(newKey);
    long unconfirmedAssetBalance = accountAsset == null ? 0 : accountAsset.getUnconfirmedQuantityQNT();
    unconfirmedAssetBalance = Convert.safeAdd(unconfirmedAssetBalance, quantityQNT);
    if (accountAsset == null) {
      accountAsset = new AccountAsset(newKey, account.getId(), assetId, 0, unconfirmedAssetBalance);
    } else {
      accountAsset.setUnconfirmedQuantityQNT(unconfirmedAssetBalance);
    }
    saveAccountAsset(accountAsset);
    listeners.notify(account, Event.UNCONFIRMED_ASSET_BALANCE);
    assetListeners.notify(accountAsset, Event.UNCONFIRMED_ASSET_BALANCE);
  }

  @Override
  public void addToAssetAndUnconfirmedAssetBalanceQNT(Account account, long assetId, long quantityQNT) {
    if (quantityQNT == 0) {
      return;
    }
    AccountAsset accountAsset;
    Pc365Key newKey = accountAssetKeyFactory.newKey(account.getId(), assetId);
    accountAsset = accountAssetTable.get(newKey);
    long assetBalance = accountAsset == null ? 0 : accountAsset.getQuantityQNT();
    assetBalance = Convert.safeAdd(assetBalance, quantityQNT);
    long unconfirmedAssetBalance = accountAsset == null ? 0 : accountAsset.getUnconfirmedQuantityQNT();
    unconfirmedAssetBalance = Convert.safeAdd(unconfirmedAssetBalance, quantityQNT);
    if (accountAsset == null) {
      accountAsset = new AccountAsset(newKey, account.getId(), assetId, assetBalance, unconfirmedAssetBalance);
    } else {
      accountAsset.setQuantityQNT(assetBalance);
      accountAsset.setUnconfirmedQuantityQNT(unconfirmedAssetBalance);
    }
    saveAccountAsset(accountAsset);
    listeners.notify(account, Event.ASSET_BALANCE);
    listeners.notify(account, Event.UNCONFIRMED_ASSET_BALANCE);
    assetListeners.notify(accountAsset, Event.ASSET_BALANCE);
    assetListeners.notify(accountAsset, Event.UNCONFIRMED_ASSET_BALANCE);
  }

  @Override
  public void addToBalanceNQT(Account account, long amountNQT) {
    if (amountNQT == 0) {
      return;
    }
    account.setBalanceNQT(Convert.safeAdd(account.getBalanceNQT(), amountNQT));
    account.checkBalance();
    accountTable.insert(account);
    listeners.notify(account, Event.BALANCE);
  }

  @Override
  public void addToUnconfirmedBalanceNQT(Account account, long amountNQT) {
    if (amountNQT == 0) {
      return;
    }
    account.setUnconfirmedBalanceNQT(Convert.safeAdd(account.getUnconfirmedBalanceNQT(), amountNQT));
    account.checkBalance();
    accountTable.insert(account);
    listeners.notify(account, Event.UNCONFIRMED_BALANCE);
  }

  @Override
  public void addToBalanceAndUnconfirmedBalanceNQT(Account account, long amountNQT) {
    if (amountNQT == 0) {
      return;
    }
    account.setBalanceNQT(Convert.safeAdd(account.getBalanceNQT(), amountNQT));
    account.setUnconfirmedBalanceNQT(Convert.safeAdd(account.getUnconfirmedBalanceNQT(), amountNQT));
    account.checkBalance();
    accountTable.insert(account);
    listeners.notify(account, Event.BALANCE);
    listeners.notify(account, Event.UNCONFIRMED_BALANCE);
  }

  @Override
  public RewardRecipientAssignment getRewardRecipientAssignment(Account account) {
    return getRewardRecipientAssignment(account.getId());
  }

  private RewardRecipientAssignment getRewardRecipientAssignment(Long id) {
    return rewardRecipientAssignmentTable.get(rewardRecipientAssignmentKeyFactory.newKey(id));
  }

  @Override
  public void setRewardRecipientAssignment(Account account, Long recipient) {
    int currentHeight = Pc365.getBlockchain().getLastBlock().getHeight();
    RewardRecipientAssignment assignment = getRewardRecipientAssignment(account.getId());
    if (assignment == null) {
      Pc365Key pc365Key = rewardRecipientAssignmentKeyFactory.newKey(account.getId());
      assignment = new RewardRecipientAssignment(account.getId(), account.getId(), recipient, (int) (currentHeight + Constants.PC365_REWARD_RECIPIENT_ASSIGNMENT_WAIT_TIME), pc365Key);
    } else {
      assignment.setRecipient(recipient, (int) (currentHeight + Constants.PC365_REWARD_RECIPIENT_ASSIGNMENT_WAIT_TIME));
    }
    rewardRecipientAssignmentTable.insert(assignment);
  }

  @Override
  public long getUnconfirmedAssetBalanceQNT(Account account, long assetId) {
    Pc365Key newKey = Pc365.getStores().getAccountStore().getAccountAssetKeyFactory().newKey(account.getId(), assetId);
    AccountAsset accountAsset = accountAssetTable.get(newKey);
    return accountAsset == null ? 0 : accountAsset.getUnconfirmedQuantityQNT();
  }


  private void saveAccountAsset(AccountAsset accountAsset) {
    accountAsset.checkBalance();
    if (accountAsset.getQuantityQNT() > 0 || accountAsset.getUnconfirmedQuantityQNT() > 0) {
      accountAssetTable.insert(accountAsset);
    } else {
      accountAssetTable.delete(accountAsset);
    }
  }
}
