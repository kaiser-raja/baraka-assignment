package com.baraka.assignment.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    private static final String TEST_CACHE = "test_cache";

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(TEST_CACHE);
    }
}