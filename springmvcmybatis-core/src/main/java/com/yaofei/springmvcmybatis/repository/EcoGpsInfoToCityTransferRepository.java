package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.EcoGpsInfoToCityTransfer;

/**
 * 有线电视用户登记信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-09-07 07:47:48
 */
public interface EcoGpsInfoToCityTransferRepository extends BaseRepository<EcoGpsInfoToCityTransfer> {

    void insertEcoGps(EcoGpsInfoToCityTransfer ecoGpsInfoToCityTransfer);
}
