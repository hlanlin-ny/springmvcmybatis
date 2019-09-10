package com.yaofei.springmvcmybatis.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 输错5次密码锁定半小时，ehcache.xml配置
 */
public class RetryLimitCredentialsMatcher extends HashedCredentialsMatcher implements InitializingBean {

	private static final Logger logger = LoggerFactory.getLogger(RetryLimitCredentialsMatcher.class);

	private final static String DEFAULT_CHACHE_NAME = "retryLimitCache";
	
	private final CacheManager cacheManager;
	private String retryLimitCacheName;
	private Cache<String, AtomicInteger> passwordRetryCache;
	
	public RetryLimitCredentialsMatcher(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
		this.retryLimitCacheName = DEFAULT_CHACHE_NAME;
	}
	
	public String getRetryLimitCacheName() {
		return retryLimitCacheName;
	}
	public void setRetryLimitCacheName(String retryLimitCacheName) {
		this.retryLimitCacheName = retryLimitCacheName;
	}
	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
		String username = (String) authcToken.getPrincipal();
		//retry count + 1
		AtomicInteger retryCount = passwordRetryCache.get(username);
		if(retryCount == null) {
			retryCount = new AtomicInteger(0);
			passwordRetryCache.put(username, retryCount);
		}
		if(retryCount.incrementAndGet() > 5000) {
			//if retry count > 5 throw
			logger.warn("username: " + username + " tried to login more than 5 times in period");  
			throw new ExcessiveAttemptsException("用户名: " + username + " 密码连续输入错误超过5次，锁定半小时！"); 
		}

		boolean matches = super.doCredentialsMatch(authcToken, info);
		if(matches) {
			//clear retry data
			passwordRetryCache.remove(username);
		}
		return matches;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.passwordRetryCache = cacheManager.getCache(retryLimitCacheName);
	}
}
