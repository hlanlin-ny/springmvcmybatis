package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.SysSearchwarningConfig;

/**
 * 搜索预警配置表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-24 17:12:36
 */
public interface SysSearchwarningConfigService extends BaseService<SysSearchwarningConfig> {

    /**
     * 立即执行
     */
    void run(Long[] ids);

    /**
     * 暂停运行
     */
    void updateToPause(Long[] ids);

    /**
     * 恢复运行
     */
    void updateToResume(Long[] ids);
}
