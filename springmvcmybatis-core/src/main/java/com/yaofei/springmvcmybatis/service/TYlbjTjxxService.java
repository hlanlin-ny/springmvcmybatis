package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.TYlbjTjxx;

/**
 * 学生信息登记上传类
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2018-09-06 16:18:01
 */
public interface TYlbjTjxxService extends BaseService<TYlbjTjxx> {

    void insert(TYlbjTjxx tYlbjTjxx);
}
