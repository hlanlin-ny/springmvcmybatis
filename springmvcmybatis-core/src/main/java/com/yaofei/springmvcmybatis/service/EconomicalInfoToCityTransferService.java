package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.EconomicalInfoToCityTransfer;

/**
 * 静态文件上传类
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-02-24 14:11:22
 */
public interface EconomicalInfoToCityTransferService extends BaseService<EconomicalInfoToCityTransfer> {

    void insertEconomical(EconomicalInfoToCityTransfer economicalInfoToCityTransfer);
}
