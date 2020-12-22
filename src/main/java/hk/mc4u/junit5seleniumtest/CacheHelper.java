package hk.mc4u.junit5seleniumtest;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;

public class CacheHelper {

	private CacheManager cacheManager;
	private Cache<Integer, Integer> squareNumberCache;

	public CacheHelper() {
		cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
				.with(CacheManagerBuilder.persistence("/tmp/"))
				.withCache("persistent-cache",
						CacheConfigurationBuilder.newCacheConfigurationBuilder(Integer.class, Integer.class,
								ResourcePoolsBuilder.newResourcePoolsBuilder()
								.heap(10, EntryUnit.ENTRIES)
								.offheap(20, MemoryUnit.MB)
								.disk(100, MemoryUnit.MB, true)))
				.build(true);

		squareNumberCache = cacheManager.createCache("squaredNumber", CacheConfigurationBuilder
				.newCacheConfigurationBuilder(Integer.class, Integer.class, ResourcePoolsBuilder.heap(10)));
		
	}

	public Cache<Integer, Integer> getSquareNumberCacheFromCacheManager() {
		return cacheManager.getCache("squaredNumber", Integer.class, Integer.class);
	}

	public Cache<Integer, Integer> getSquareNumberCache() {
		return squareNumberCache;
	}

	public void setSquareNumberCache(Cache<Integer, Integer> squareNumberCache) {
		this.squareNumberCache = squareNumberCache;
	}

	// standard getters and setters

}
