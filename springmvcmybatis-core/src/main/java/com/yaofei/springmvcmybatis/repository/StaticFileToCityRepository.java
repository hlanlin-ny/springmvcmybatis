package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.StaticFileClass;
import com.yaofei.springmvcmybatis.entity.StaticFileToCityTransfer;

/**
 * 静态文件上传类
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-02-24 14:11:22
 */
public interface StaticFileToCityRepository extends BaseRepository<StaticFileToCityTransfer> {

    void insert(StaticFileToCityTransfer staticFileToCityTransfer);
}
