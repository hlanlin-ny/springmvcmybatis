package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.CommonTool;

import java.util.List;

/**
 * 常用工具表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-03 17:45:49
 */
public interface CommonToolService extends BaseService<CommonTool> {

    List<CommonTool> queryAllByAreaId(Long areaId);
}
