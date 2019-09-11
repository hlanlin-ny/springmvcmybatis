package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.CarGpsInfoToCityTransfer;

import java.util.List;

/**
 * 有线电视用户登记信息
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-09-07 07:47:48
 */
public interface CarGpsInfoToCityTransferRepository extends BaseRepository<CarGpsInfoToCityTransfer> {

    void insertCarGps(CarGpsInfoToCityTransfer carGpsInfoToCityTransfer);

    List<CarGpsInfoToCityTransfer> selectCar();
}
