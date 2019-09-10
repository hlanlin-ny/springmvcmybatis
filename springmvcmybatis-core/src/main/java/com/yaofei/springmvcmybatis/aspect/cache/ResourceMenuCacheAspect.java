//package com.yaofei.springmvcmybatis.aspect.cache;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
///**
// * 缓存及清理菜单缓存
// */
//@Component
//@Aspect
//public class ResourceMenuCacheAspect extends BaseCacheAspect {
//
//    public ResourceMenuCacheAspect() {
//        setCacheName("sys-menuCache");
//    }
//
//    private String menusKeyPrefix = "menus-";
//
//
//    @Pointcut(value = "target(com.sishuok.es.sys.resource.service.ResourceService)")
//    private void resourceServicePointcut() {
//    }
//
//    @Pointcut(value = "execution(* save(..)) || execution(* update(..)) || execution(* delete(..))")
//    private void resourceCacheEvictAllPointcut() {
//    }
//
//    @Pointcut(value = "execution(* findMenus(*)) && args(arg)", argNames = "arg")
//    private void resourceCacheablePointcut(User arg) {
//    }
//
//    @Before(value = "resourceServicePointcut() && resourceCacheEvictAllPointcut()")
//    public void findRolesCacheableAdvice() throws Throwable {
//        clear();
//    }
//
//    @Around(value = "resourceServicePointcut() && resourceCacheablePointcut(arg)", argNames = "pjp,arg")
//    public Object findRolesCacheableAdvice(ProceedingJoinPoint pjp, User arg) throws Throwable {
//
//        User user = arg;
//
//        String key = menusKey(user.getId());
//        Object retVal = get(key);
//
//        if (retVal != null) {
//            logger.debug("cacheName:{}, method:findRolesCacheableAdvice, hit key:{}", cacheName, key);
//            return retVal;
//        }
//        logger.debug("cacheName:{}, method:findRolesCacheableAdvice, miss key:{}", cacheName, key);
//
//        retVal = pjp.proceed();
//
//        put(key, retVal);
//
//        return retVal;
//    }
//
//
//    public void evict(Long userId) {
//        evict(menusKey(userId));
//    }
//
//
//    private String menusKey(Long userId) {
//        return this.menusKeyPrefix + userId;
//    }
//}