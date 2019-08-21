package com.lw.utils;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class RedisCacheManager implements CacheManager{
	
	private final Logger logger = LoggerFactory.getLogger(RedisCacheManager.class);
	
	private final  ConcurrentHashMap<String, Cache> map = new ConcurrentHashMap<String, Cache>();
	
	private RedisUtil redisUtil;
	
	 private static final int DEFAULT_EXPIRE = 1800;
	
	 private int expire = DEFAULT_EXPIRE;
	
	 public static final String DEFAULT_CACHE_KEY_PREFIX = "shiro:cache:";

	 private String keyPrefix = DEFAULT_CACHE_KEY_PREFIX;
	 
	 public static final String DEFAULT_PRINCIPAL_ID_FIELD_NAME = "authCacheKey or id";
	 
	 private String principalIdFieldName = DEFAULT_PRINCIPAL_ID_FIELD_NAME;
	 
	@Override
	public <K, V> Cache<K, V> getCache(String arg0) throws CacheException {
		// TODO Auto-generated method stub
		logger.debug(arg0);
		@SuppressWarnings("unchecked")
		Cache<K, V> cache = map.get(arg0);
		if (cache == null) {
			try {
				cache = new RedisCache<K, V>(redisUtil,keyPrefix + arg0 + ":", expire, principalIdFieldName);
				map.put(arg0, cache);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cache;
	}

	public RedisUtil getRedisUtil() {
		return redisUtil;
	}

	public void setRedisUtil(RedisUtil redisUtil) {
		this.redisUtil = redisUtil;
	}

	public int getExpire() {
		return expire;
	}

	public void setExpire(int expire) {
		this.expire = expire;
	}

	public String getKeyPrefix() {
		return keyPrefix;
	}

	public void setKeyPrefix(String keyPrefix) {
		this.keyPrefix = keyPrefix;
	}

	public String getPrincipalIdFieldName() {
		return principalIdFieldName;
	}

	public void setPrincipalIdFieldName(String principalIdFieldName) {
		this.principalIdFieldName = principalIdFieldName;
	}

}
