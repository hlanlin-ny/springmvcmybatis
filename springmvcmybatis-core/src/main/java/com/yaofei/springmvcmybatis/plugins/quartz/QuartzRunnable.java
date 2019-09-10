package com.yaofei.springmvcmybatis.plugins.quartz;

import com.yaofei.springmvcmybatis.component.SpringContextUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * 执行定时任务
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2016年11月30日 下午12:49:33
 */
public class QuartzRunnable implements Runnable {
	private Object target;
	private Method method;
	private String params;

	private Logger logger = LoggerFactory.getLogger(getClass());

	public QuartzRunnable(String beanName, String methodName, String params) throws NoSuchMethodException, SecurityException {
		this.target = SpringContextUtils.getBean(beanName);
		this.params = params;
		
		if(StringUtils.isNotBlank(params)){
			this.method = target.getClass().getDeclaredMethod(methodName, String.class);
		}else{
			this.method = target.getClass().getDeclaredMethod(methodName);
		}
	}

	@Override
	public void run() {
		try {
			ReflectionUtils.makeAccessible(method);
			if(StringUtils.isNotBlank(params)){
				method.invoke(target, params);
			}else{
				method.invoke(target);
			}
		}catch (Exception e) {
			logger.error("执行定时任务失败:"+e.toString());
			throw new QuartzJobException("执行定时任务失败", e);
		}
	}

}
