package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.SysArea;

import java.util.List;

/**
 * 系统行政区划表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-07-31 08:07:18
 */
public interface SysAreaRepository extends BaseRepository<SysArea> {

    List<SysArea> getParentList(Long areaId);
}
