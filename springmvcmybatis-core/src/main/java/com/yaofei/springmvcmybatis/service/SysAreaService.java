package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.SysArea;

import java.util.List;
import java.util.Map;

/**
 * 系统行政区划表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-07-31 08:07:18
 */
public interface SysAreaService extends BaseService<SysArea> {

    List<SysArea> queryListOrderByOrderNum();

    Map querySysAreaIdNameMap();

    String getParentString(Long areaId);
}
