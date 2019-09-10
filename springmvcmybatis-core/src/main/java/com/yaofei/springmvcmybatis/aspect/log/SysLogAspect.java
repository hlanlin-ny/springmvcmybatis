package com.yaofei.springmvcmybatis.aspect.log;

import com.yaofei.springmvcmybatis.entity.SysLog;
import com.yaofei.springmvcmybatis.service.SysLogService;
import com.yaofei.springmvcmybatis.shiro.domain.ShiroUser;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * AOP 日志
 * Created by f_yao on 2017/2/21.
 */
@Order(10)
@Aspect
@Component
public class SysLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(SysLogAspect.class);

    @Autowired
    private SysLogService sysLogService;

    /**
     * 定义一个方法, 用于声明切入点表达式. 一般地, 该方法中再不需要添入其他的代码.
     * 使用 @Pointcut 来声明切入点表达式.
     * 后面的其他通知直接使用方法名来引用当前的切入点表达式.
     */
    //@Pointcut("execution(* com.yaofei.springmvcmybatis.repository.*.*(..)) && !execution(* com.yaofei.springmvcmybatis.repository.SysLogRepository.*(..))")
    @Pointcut("execution(* com.yaofei.springmvcmybatis.service.*.*(..)) && !execution(void com.yaofei.springmvcmybatis.service.impl.AbstractBaseService.save(..))")
    public void sysLogPointcut() {
    }

    /**
     * 操作完成以后记录日志
     *
     * @param joinPoint
     */
    @AfterReturning("sysLogPointcut()")
    public void saveSysLogAfterReturning(JoinPoint joinPoint) {
        try {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            if (requestAttributes == null) {
                return;
            }
            String opertionClassName = joinPoint.getTarget().getClass().getName();
            String opertionMethodName = joinPoint.getSignature().getName();
            String opertionParamValue = Arrays.asList(joinPoint.getArgs()).toString();
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            SysLog sysLog = new SysLog();
            ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
            if (null != shiroUser) {
                sysLog.setUsername(shiroUser.getUsername());
                sysLog.setUserRealName(shiroUser.getUserRealName());
            }
            sysLog.setOpertionClassName(opertionClassName);
            sysLog.setOpertionMethodName(opertionMethodName);
            sysLog.setOpertionParamValue(opertionParamValue);
            if (request != null) {
                sysLog.setClientIp(request.getRemoteAddr());
            }
            sysLogService.save(sysLog);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }


    ///**
    // * 环绕通知需要携带 ProceedingJoinPoint 类型的参数.
    // * 环绕通知类似于动态代理的全过程: ProceedingJoinPoint 类型的参数可以决定是否执行目标方法.
    // * 且环绕通知必须有返回值, 返回值即为目标方法的返回值
    // */
    //@Around("sysLogPointcut()")
    //public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    //
    //    Object result;
    //
    //    //前置通知
    //    logger.debug("Enter: {}.{}() with argument[s] = {}", proceedingJoinPoint.getSignature().getDeclaringTypeName(),
    //            proceedingJoinPoint.getSignature().getName(), Arrays.toString(proceedingJoinPoint.getArgs()));
    //    try {
    //        //执行目标方法
    //        result = proceedingJoinPoint.proceed();
    //        //返回通知
    //        logger.debug("Return: {}.{}() with result = {}", proceedingJoinPoint.getSignature().getDeclaringTypeName(),
    //                proceedingJoinPoint.getSignature().getName(), result);
    //    } catch (IllegalArgumentException e) {
    //        //异常通知
    //        logger.error("Illegal argument: {} in {}.{}()", Arrays.toString(proceedingJoinPoint.getArgs()),
    //                proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName());
    //
    //        throw e;
    //    }
    //
    //    //后置通知
    //    logger.debug("Exit: {}.{}() with argument[s] = {}", proceedingJoinPoint.getSignature().getDeclaringTypeName(),
    //            proceedingJoinPoint.getSignature().getName(), Arrays.toString(proceedingJoinPoint.getArgs()));
    //
    //    return result;
    //}


    ///**
    // * 在每一个实现类的每一个方法开始之前执行一段代码
    // */
    //@Before("loggingPointcut()")
    //public void beforeMethod(JoinPoint joinPoint) {
    //    String methodName = joinPoint.getSignature().getName();
    //    Object[] args = joinPoint.getArgs();
    //    logger.info("The method " + methodName + " begins with " + Arrays.asList(args));
    //}
    //
    ///**
    // * 在方法执行之后执行的代码. 无论该方法是否出现异常
    // */
    //@After("loggingPointcut()")
    //public void afterMethod(JoinPoint joinPoint) {
    //    String methodName = joinPoint.getSignature().getName();
    //    logger.info("The method " + methodName + " ends");
    //}
    //
    ///**
    // * 在方法法正常结束受执行的代码
    // * 返回通知是可以访问到方法的返回值的!
    // */
    //@AfterReturning(value = "loggingPointcut()",
    //        returning = "result")
    //public void afterReturning(JoinPoint joinPoint, Object result) {
    //    String methodName = joinPoint.getSignature().getName();
    //    logger.info("The method " + methodName + " ends with " + result);
    //}
    //
    ///**
    // * 在目标方法出现异常时会执行的代码.
    // * 可以访问到异常对象; 且可以指定在出现特定异常时在执行通知代码
    // */
    //@AfterThrowing(value = "loggingPointcut()", throwing = "e")
    //public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
    //    if (env.acceptsProfiles(Constants.PROFILE_DEVELOPMENT)) {
    //        logger.error("Exception in {}.{}() with cause = \'{}\' and exception = \'{}\'", joinPoint.getSignature().getDeclaringTypeName(),
    //                joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL", e.getMessage(), e);
    //
    //    } else {
    //        logger.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
    //                joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
    //    }
    //}

}
