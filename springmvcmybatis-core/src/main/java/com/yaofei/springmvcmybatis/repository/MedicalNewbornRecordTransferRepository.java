package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.MedicalNewbornRecordTransfer;

import java.util.List;

/**
 * 新生儿出生信息ZQH-22-113600005 传输
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-01-16 13:24:41
 */
public interface MedicalNewbornRecordTransferRepository extends BaseRepository<MedicalNewbornRecordTransfer> {

    List<MedicalNewbornRecordTransfer> queryBatch();
}
