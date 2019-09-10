package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.IntelligenceOfficer;

import java.util.List;

/**
 * 情报员信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-12 11:31:29
 */
public interface IntelligenceOfficerRepository extends BaseRepository<IntelligenceOfficer> {
    List<IntelligenceOfficer> queryOfficerNames(String areaId);
}
