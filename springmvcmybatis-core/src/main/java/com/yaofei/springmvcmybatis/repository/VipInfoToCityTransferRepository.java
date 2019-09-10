package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.VipInfoToCityTransfer;

/**
 * 有线电视用户登记信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-09-07 07:47:48
 */
public interface VipInfoToCityTransferRepository extends BaseRepository<VipInfoToCityTransfer> {

    void insertVip(VipInfoToCityTransfer vipInfoToCityTransfer);
}
