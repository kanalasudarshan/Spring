package com.ksr.util.cache;

import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilder;
import com.ksr.util.constants.KSRConstant;

@Configuration
@EnableCaching
public class KSRCacheManager {
	
	@Bean
	public CacheManager cacheManager() {
		SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
		GuavaCache cache1 = new GuavaCache(KSRConstant.USER_DTO_WITH_USER_NAME, CacheBuilder.newBuilder().build());
		GuavaCache cache2 = new GuavaCache(KSRConstant.USER_DTO_WITH_ID, CacheBuilder.newBuilder().build());
		simpleCacheManager.setCaches(Arrays.asList(cache1, cache2));
		return simpleCacheManager;
	}
}
