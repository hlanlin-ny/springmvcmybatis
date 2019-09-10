package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.SysSearchwarningConfig;
import org.apache.ibatis.annotations.Param;

/**
 * 搜索预警配置表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-24 17:12:36
 */
public interface SysSearchwarningConfigRepository extends BaseRepository<SysSearchwarningConfig> {
    int updateStatusByIds(@Param("ids") Long[] ids, @Param("status") int status);
}
