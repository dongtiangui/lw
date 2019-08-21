package com.lw.utils;

import java.util.Collection;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 使用redis 作为shiro缓存 需要重写 cache
 * @author apple
 *
 * @param <K>
 * @param <V>
 */

public class RedisCache<K, V> implements Cache<K, V>{
	
	private static Logger logger = LoggerFactory.getLogger(RedisCache.class);
	
	private RedisUtil redisUtil;
	private String keyPrefix = "";
	private int expire = 0;
	private String principalIdFieldName = RedisCacheManager.DEFAULT_PRINCIPAL_ID_FIELD_NAME;
	
	

	public RedisCache(RedisUtil redisUtil, String keyPrefix, int expire, String principalIdFieldName) throws IllegalAccessException {
		if (redisUtil == null) {
			throw new IllegalAccessException("redisUtil not null"); 
		}
		this.redisUtil = redisUtil;
		if (keyPrefix!=null && !"".equals(keyPrefix)) {
			this.keyPrefix = keyPrefix;
		}
		if (expire != -1) {
			this.expire = expire;
		}
		if (principalIdFieldName != null && !"".equals(principalIdFieldName)) {
            this.principalIdFieldName = principalIdFieldName;
        }
	}

	@Override
	public void clear() throws CacheException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V get(K arg0) throws CacheException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<K> keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K arg0, V arg1) throws CacheException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(K arg0) throws CacheException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

}
