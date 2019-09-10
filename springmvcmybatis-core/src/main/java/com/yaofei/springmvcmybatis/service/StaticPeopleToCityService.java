package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.MedicalStaticPeopleToCityTransfer;
import com.yaofei.springmvcmybatis.entity.StaticTrifficPeopleToCityTransfer;
import com.yaofei.springmvcmybatis.entity.StaticWaterToCityTransfer;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;

import java.util.List;

/**
 * 静态文件上传类
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-02-24 14:11:22
 */
public interface StaticPeopleToCityService extends BaseService<MedicalStaticPeopleToCityTransfer> {

    void insert(MedicalStaticPeopleToCityTransfer medicalStaticPeopleToCityTransfer);
    List<MedicalStaticPeopleToCityTransfer> queryListPeople(DataTablesRequest dataTablesRequest);
}
