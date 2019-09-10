package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.GetLastTime;
import com.yaofei.springmvcmybatis.entity.IntelligenceImportCity;
import com.yaofei.springmvcmybatis.entity.StaticFileClass;

import java.util.Date;
import java.util.List;

/**
 * 情报导入记录
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-01 11:11:40
 */
public interface IntelligenceImportCityRepository extends BaseRepository<IntelligenceImportCity> {
    List<StaticFileClass> selectAll();
    void updateIfUpload(long id);
    List<StaticFileClass> selectAllWater();
    List<StaticFileClass> selectAllPeople();
    List<StaticFileClass> selectAllHealthy();
    List<GetLastTime> selectLastTime();
    void updateLastTime(Date now);
    List<StaticFileClass> selectAllNcms();
    List<StaticFileClass> selectmedicalinsurance();
    List<StaticFileClass> selectaccumulationfund();
    List<StaticFileClass> selectletterscalls();
    List<StaticFileClass> selectStudentToCitys();
    List<StaticFileClass> selectTelevisionToCitys();
    List<StaticFileClass> selectPhysicalExamination();
    List<StaticFileClass> selectPaking();
    List<StaticFileClass> selectVip();
    List<StaticFileClass> selectCarGps();
    List<StaticFileClass> selectVisitor();
    List<StaticFileClass> selectEconomical();
    List<StaticFileClass> selectGasFee();
    List<StaticFileClass> selectEcoGps();
    List<StaticFileClass> selectExpress();
    List<StaticFileClass> selectPower();
    List<StaticFileClass> selectPowerData();
    List<StaticFileClass> selectNewborn();
}
