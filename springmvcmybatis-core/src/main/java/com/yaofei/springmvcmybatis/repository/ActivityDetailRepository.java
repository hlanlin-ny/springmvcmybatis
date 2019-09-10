package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.ActivityDetail;
import com.yaofei.springmvcmybatis.entity.MedicalCheckinCheckoutRecordTransfer;
import com.yaofei.springmvcmybatis.entity.MedicalOutpatientRecordTransfer;
import com.yaofei.springmvcmybatis.entity.MedicalPatientRecordTransfer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 87796 on 2017/9/21.
 */
public interface ActivityDetailRepository{
   //插入数据
    int save(ActivityDetail activityDetail);
   //通过关联id查询数据
    ActivityDetail queryByRelateId(Long relateId);
    //更新数据
    int update(ActivityDetail activityDetail);

    public ActivityDetail queryAlikeByImportant(@Param(value = "providerAddress")String providerAddress,@Param(value = "name")String name);

    public ActivityDetail queryAlikeByControl(@Param(value = "providerAddress")String providerAddress,@Param(value = "name")String name);

    public void claim(Long id);

    public ActivityDetail queryObject(Long id);

    List<MedicalCheckinCheckoutRecordTransfer> selectMarder(@Param(value = "idCard")String idCard, @Param(value = "name")String name);

    List<MedicalOutpatientRecordTransfer> selectPatient(@Param(value = "idCard")String idCard, @Param(value = "name")String name);
}
