package core.assetexchange;

import core.Account.AccountAsset;
import core.*;
import core.db.Pc365Key;
import core.db.sql.EntitySqlTable;
import core.db.store.AssetStore;

import java.util.Collection;

class AssetServiceImpl {

  private final AssetStore assetStore;
  private final AssetAccountServiceImpl assetAccountService;
  private final TradeServiceImpl tradeService;
  private final AssetTransferServiceImpl assetTransferService;

  private final EntitySqlTable<Asset> assetTable;

  private final Pc365Key.LongKeyFactory<Asset> assetDbKeyFactory;

  public AssetServiceImpl(AssetAccountServiceImpl assetAccountService, TradeServiceImpl tradeService, AssetStore assetStore, AssetTransferServiceImpl assetTransferService) {
    this.assetAccountService = assetAccountService;
    this.tradeService = tradeService;
    this.assetStore = assetStore;
    this.assetTable = assetStore.getAssetTable();
    this.assetDbKeyFactory = assetStore.getAssetDbKeyFactory();
    this.assetTransferService = assetTransferService;
  }

  public Asset getAsset(long id) {
    return assetTable.get(assetDbKeyFactory.newKey(id));
  }

  public Collection<AccountAsset> getAccounts(long assetId, int from, int to) {
    return assetAccountService.getAssetAccounts(assetId, from, to);
  }

  public Collection<AccountAsset> getAccounts(long assetId, int height, int from, int to) {
    if (height < 0) {
      return getAccounts(assetId, from, to);
    }
    return assetAccountService.getAssetAccounts(assetId, height, from, to);
  }

  public Collection<Trade> getTrades(long assetId, int from, int to) {
    return tradeService.getAssetTrades(assetId, from, to);
  }

  public Collection<AssetTransfer> getAssetTransfers(long assetId, int from, int to) {
    return assetTransferService.getAssetTransfers(assetId, from, to);
  }

  public Collection<Asset> getAllAssets(int from, int to) {
    return assetTable.getAll(from, to);
  }

  public Collection<Asset> getAssetsIssuedBy(long accountId, int from, int to) {
    return assetStore.getAssetsIssuedBy(accountId, from, to);
  }

  public int getAssetsCount() {
    return assetTable.getCount();
  }

  public void addAsset(Transaction transaction, Attachment.ColoredCoinsAssetIssuance attachment) {
    final Pc365Key dbKey = assetDbKeyFactory.newKey(transaction.getId());
    assetTable.insert(new Asset(dbKey, transaction, attachment));
  }

}
