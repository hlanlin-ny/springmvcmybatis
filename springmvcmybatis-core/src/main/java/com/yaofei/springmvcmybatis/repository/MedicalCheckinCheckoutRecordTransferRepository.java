package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.MedicalCheckinCheckoutRecord;
import com.yaofei.springmvcmybatis.entity.MedicalCheckinCheckoutRecordTransfer;

import java.util.List;

/**
 * 医疗住（出）院信息传输
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-27 08:39:28
 */
public interface MedicalCheckinCheckoutRecordTransferRepository extends BaseRepository<MedicalCheckinCheckoutRecordTransfer> {

    List<MedicalCheckinCheckoutRecord> queryBatch();
	
}
