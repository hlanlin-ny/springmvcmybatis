package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.CarGpsInfoToCityTransfer;

import java.util.List;

/**
 * 静态文件上传类
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-02-24 14:11:22
 */
public interface CarGpsInfoToCityTransferService extends BaseService<CarGpsInfoToCityTransfer> {

    void insertCarGps(CarGpsInfoToCityTransfer carGpsInfoToCityTransfer);

    List<CarGpsInfoToCityTransfer> selectCar();
}
