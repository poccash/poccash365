package core.db.cache;

import core.Account;
import core.db.Pc365Key;
import core.statistics.StatisticsManagerImpl;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.Status;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import java.util.HashMap;
import java.util.Map;

public class DBCacheManagerImpl {

  private final CacheManager cacheManager;

  private final StatisticsManagerImpl statisticsManager;

  private final boolean statisticsEnabled;

  private final HashMap<String, CacheConfiguration<Pc365Key, ?>> caches = new HashMap<>();

  public DBCacheManagerImpl(StatisticsManagerImpl statisticsManager) {
    this.statisticsManager = statisticsManager;
    statisticsEnabled = true;

    caches.put("account", CacheConfigurationBuilder.newCacheConfigurationBuilder(Pc365Key.class, Account.class, ResourcePoolsBuilder.heap(8192)).build());

    CacheManagerBuilder cacheBuilder = CacheManagerBuilder.newCacheManagerBuilder();
    for (Map.Entry<String, CacheConfiguration<Pc365Key, ?>> cache : caches.entrySet()) {
      cacheBuilder = cacheBuilder.withCache(cache.getKey(), cache.getValue());
    }
    cacheManager = cacheBuilder.build(true);
  }

  public void close() {
    if ( cacheManager.getStatus().equals(Status.AVAILABLE) ) {
      cacheManager.close();
    }
  }

  private <V> Cache<Pc365Key, V> getEHCache(String name, Class<V> valueClass) {
    return cacheManager.getCache(name, Pc365Key.class, valueClass);
  }

  public <V> Cache<Pc365Key, V> getCache(String name, Class<V> valueClass) {
    Cache<Pc365Key, V> cache = getEHCache(name, valueClass);
    return statisticsEnabled ? new StatisticsCache<>(cache, name, statisticsManager) : cache;
  }

  public void flushCache() {
    for (Map.Entry<String, CacheConfiguration<Pc365Key, ?>> cacheEntry : caches.entrySet()) {
      Cache<?,?> cache = getEHCache(cacheEntry.getKey(), cacheEntry.getValue().getValueType());
      if ( cache != null )
        cache.clear();
    }
  }
}
