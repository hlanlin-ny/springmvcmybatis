package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.DisposalMeasures;

/**
 * 处置措施表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-23 09:26:15
 */
public interface DisposalMeasuresRepository extends BaseRepository<DisposalMeasures> {

    int save(DisposalMeasures disposalMeasures);

    DisposalMeasures query(Long resultId);

    int update(DisposalMeasures disposalMeasures);
}
