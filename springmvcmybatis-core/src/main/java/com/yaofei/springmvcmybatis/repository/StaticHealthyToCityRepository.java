package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.StaticHealthyToCityTransfer;
import com.yaofei.springmvcmybatis.entity.StaticWaterToCityTransfer;

/**
 * 静态文件上传类
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-02-24 14:11:22
 */
public interface StaticHealthyToCityRepository extends BaseRepository<StaticHealthyToCityTransfer> {

    void insert(StaticHealthyToCityTransfer staticHealthyToCityTransfer);
}
