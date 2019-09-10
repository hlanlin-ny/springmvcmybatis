package com.yaofei.springmvcmybatis.plugins.quartz;

import com.yaofei.springmvcmybatis.component.SpringContextUtils;
import com.yaofei.springmvcmybatis.entity.SysSearchwarningConfig;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * Created by 87796 on 2017/8/31.
 */
public class WarnQuartzRunnable  implements Runnable{
    private Object target;
    private Method method;
    private SysSearchwarningConfig params;

    public WarnQuartzRunnable(String beanName, String methodName, SysSearchwarningConfig params) throws NoSuchMethodException, SecurityException {
        this.target = SpringContextUtils.getBean(beanName);
        this.params = params;

        this.method = target.getClass().getDeclaredMethod(methodName, SysSearchwarningConfig.class);

    }

    @Override
    public void run() {
        try {
            ReflectionUtils.makeAccessible(method);
            method.invoke(target, params);
        }catch (Exception e) {
            throw new QuartzJobException("执行定时任务失败", e);
        }
    }
}
