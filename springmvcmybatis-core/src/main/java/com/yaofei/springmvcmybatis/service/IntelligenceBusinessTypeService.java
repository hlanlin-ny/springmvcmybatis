package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.IntelligenceBusinessType;

import java.util.List;

/**
 * 情报业务类型
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-01 08:56:47
 */
public interface IntelligenceBusinessTypeService extends BaseService<IntelligenceBusinessType> {
    List<IntelligenceBusinessType> queryListOrderByOrderNum(Long areaId);

    String getParentString(Long businessTypeId);

    List<IntelligenceBusinessType> queryAllRightIntelligenceBusinessType(Long areaId);

    //Map querySysUserDepartmentIdNameMap();
    IntelligenceBusinessType queryBusinessTypeName(Long typeId);
}
