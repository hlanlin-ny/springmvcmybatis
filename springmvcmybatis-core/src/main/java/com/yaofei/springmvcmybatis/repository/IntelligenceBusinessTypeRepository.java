package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.IntelligenceBusinessType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 情报业务类型
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-01 08:56:47
 */
public interface IntelligenceBusinessTypeRepository extends BaseRepository<IntelligenceBusinessType> {

    List<IntelligenceBusinessType> getParentList(Long businessTypeId);

    IntelligenceBusinessType queryBusinessTypeName(@Param(value = "businessTypeId")Long businessTypeId);
}
