package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.WarningDispostion;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 预警处置详情
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-21 11:14:23
 */
public interface WarningDispostionRepository extends BaseRepository<WarningDispostion> {

    WarningDispostion queryByRelateId(Long relateId);

    public void claim(Long id);

    public int updateDispostionStatus(@Param("relateId")Long relateId,@Param("dispositionTime")Date dispositionTime);

    public List<WarningDispostion>queryByTime(@Param("time")Date time,@Param("newTime")Date newTime);

    public int queryUnClaim();

}
