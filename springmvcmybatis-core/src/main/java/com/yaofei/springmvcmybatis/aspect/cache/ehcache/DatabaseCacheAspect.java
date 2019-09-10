//package com.yaofei.springmvcmybatis.aspect.cache.ehcache;
//
//import net.sf.ehcache.Cache;
//import net.sf.ehcache.Element;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.io.Serializable;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * 缓存及清理数据库缓存
// */
//@Order(1)
//@Component
//@Aspect
//public class DatabaseCacheAspect {
//    private static final Logger logger = LoggerFactory.getLogger(DatabaseCacheAspect.class);
//
//    @Autowired
//    private Cache cache;
//
//    public Cache getCache() {
//        return cache;
//    }
//
//    public void setCache(Cache cache) {
//        this.cache = cache;
//    }
//
//    private final static String CACHE_KEY_PREFIX = "databaseCache-";
//
//
//    //@Pointcut("execution(* com.yaofei.springmvcmybatis.service.impl.*.query*(..)) || execution(* com.yaofei.springmvcmybatis.service.impl.*.get*(..)) || execution(* com.yaofei.springmvcmybatis.service.impl.*.count*(..)) || execution(* com.yaofei.springmvcmybatis.service.impl.*.exists*(..))")
//    @Pointcut("execution(* com.yaofei.springmvcmybatis.service.*.query*(..)) || execution(* com.yaofei.springmvcmybatis.service.*.get*(..)) || execution(* com.yaofei.springmvcmybatis.service.*.count*(..)) || execution(* com.yaofei.springmvcmybatis.service.*.exists*(..))")
//    //@Pointcut("execution(* com.yaofei.springmvcmybatis.service.impl.*.query*(..))")
//    private void addDatabaseCachePointcut() {
//    }
//
//    //@Pointcut("execution(* com.yaofei.springmvcmybatis.service.impl.*.save*(..)) || execution(* com.yaofei.springmvcmybatis.service.impl.*.delete*(..))")
//    @Pointcut("execution(* com.yaofei.springmvcmybatis.service.*.save*(..)) || execution(* com.yaofei.springmvcmybatis.service.*.update*(..))|| execution(* com.yaofei.springmvcmybatis.service.*.delete*(..))")
//    private void removeDatabaseCachePointcut() {
//    }
//
//    /**
//     * 增加缓存
//     */
//    @Around("addDatabaseCachePointcut()")
//    public Object addDatabaseCacheAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//
//        Object result = null;
//
//        //前置通知
//        logger.debug("Enter: {}.{}() with argument[s] = {}", proceedingJoinPoint.getSignature().getDeclaringTypeName(),
//                proceedingJoinPoint.getSignature().getName(), Arrays.toString(proceedingJoinPoint.getArgs()));
//
//        //获取要拦截的类
//        String targetName = proceedingJoinPoint.getTarget().getClass().getName();
//        //获取要拦截的类的方法
//        String methodName = proceedingJoinPoint.getSignature().getName();
//        //获得要拦截的类的方法的参数
//        Object[] arguments = proceedingJoinPoint.getArgs();
//
//        //创建一个字符串，用来做cache中的key
//        String cacheKey = getCacheKey(targetName, methodName, arguments);
//        //从cache中获取数据
//        Element element;
//        synchronized (this) {
//            try {
//                element = cache.get(cacheKey);
//                if (element == null) {
//                    // 调用实际的方法
//                    //执行目标方法
//                    result = proceedingJoinPoint.proceed();
//                    //返回通知
//                    logger.debug("Return: {}.{}() with result = {}", proceedingJoinPoint.getSignature().getDeclaringTypeName(),
//                            proceedingJoinPoint.getSignature().getName(), result);
//
//                    if (cacheKey.indexOf("SysLog") == -1) {
//                        logger.info("加入到缓存，cacheKey： " + cacheKey);
//                        element = new Element(cacheKey, (Serializable) result);
//                        cache.put(element);
//                    }
//                } else {
//                    //如果cache中有数据，则查找cache
//                    logger.info("使用缓存，cacheKey： " + cacheKey);
//                }
//            } catch (IllegalArgumentException e) {
//                //异常通知
//                logger.error("Illegal argument: {} in {}.{}()", Arrays.toString(proceedingJoinPoint.getArgs()),
//                        proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName());
//
//                throw e;
//            }
//        }
//
//        //后置通知
//        logger.debug("Exit: {}.{}() with argument[s] = {}", proceedingJoinPoint.getSignature().getDeclaringTypeName(),
//                proceedingJoinPoint.getSignature().getName(), Arrays.toString(proceedingJoinPoint.getArgs()));
//
//        if (element != null) {
//            return element.getObjectValue();
//        } else {
//            return result;
//        }
//    }
//
//    /**
//     * 删除缓存
//     */
//    @AfterReturning("removeDatabaseCachePointcut()")
//    public void removeDatabaseCacheAfterReturning(JoinPoint joinPoint) {
//        String targetName = joinPoint.getTarget().getClass().getName();
//        if (targetName.contains("SysLog")) {
//            return;
//        }
//        String methodName = joinPoint.getSignature().getName();
//        String cacheKeyToBeRemove = CACHE_KEY_PREFIX + targetName;
//        logger.info("方法：" + targetName + "." + methodName + "导致了删除类：" + targetName + " 相关的缓存");
//
//        List list = cache.getKeys();
//        for (int i = 0; i < list.size(); i++) {
//            String cacheKey = String.valueOf(list.get(i));
//            if (cacheKey.startsWith(cacheKeyToBeRemove)) {
//                cache.remove(cacheKey);
//                logger.info("方法：" + targetName + "." + methodName + "导致了删除类：" + targetName + " 相关的缓存。cacheKey：" + cacheKey);
//            }
//        }
//    }
//
//    /**
//     * 获得cache的key的方法，cache的key是Cache中一个Element的唯一标识，
//     * 包括包名+类名+方法名，如：com.test.service.TestServiceImpl.getObject
//     *
//     * @param targetName 全路径
//     * @param methodName 方法名称
//     * @param arguments  参数
//     * @return 完整方法名称
//     */
//    private String getCacheKey(String targetName, String methodName, Object[] arguments) {
//        StringBuffer sb = new StringBuffer(CACHE_KEY_PREFIX);
//        sb.append(targetName).append(".").append(methodName);
//        if ((arguments != null) && (arguments.length != 0)) {
//            for (int i = 0; i < arguments.length; i++) {
//                sb.append(".").append(arguments[i]);
//            }
//        }
//        return sb.toString();
//    }
// }