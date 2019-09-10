package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.ImportantPerson;

import java.util.List;

/**
 * 重点人员信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-14 09:30:59
 */
public interface ImportantPersonRepository extends BaseRepository<ImportantPerson> {

        void batchAdd(List<ImportantPerson> importantPersons);

        List<ImportantPerson> queryBatch();

        ImportantPerson queryPerson(String idcardno);

        String queryTel(Long id);

        String queryIDcard(Long id);

        ImportantPerson queryByTel(String tel);

        ImportantPerson queryByCard(String card);

}
