package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.DispositionResult;

import java.util.List;

/**
 * 处置结果
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-23 09:26:05
 */
public interface DispositionResultRepository{

    int save(DispositionResult dispositionResult);

    List<DispositionResult> query(Long resultId);

    int update(DispositionResult dispositionResult);
}
