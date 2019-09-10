package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.StaticFileClass;
import com.yaofei.springmvcmybatis.entity.StaticFileToCityTransfer;

import java.util.List;

/**
 * 静态文件上传类
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-02-24 14:11:22
 */
public interface StaticFileClassRepository extends BaseRepository<StaticFileClass> {

    void saveAll(List<StaticFileClass> staticFileClass );

    void updateAll(List<StaticFileClass> staticFileClass);
}
