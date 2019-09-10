package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.ImportantPerson;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 重点人员信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-14 09:30:59
 */
public interface ImportantPersonService extends BaseService<ImportantPerson> {
    //批量插入数据
    boolean batchImport(String name, MultipartFile file, String username, String ip,Long areaId);
   //导出excel表的信息
   HSSFWorkbook exportExcelInfo();
    //查询手机号任务
    String queryTel(Long id);
    //查询身份证号码
    String queryIDcard(Long id);
    //通过身份证查询重点人员信息
    ImportantPerson queryPersonByIdcardno(String idcardno);
    //通过手机号查询重点人员信息
    ImportantPerson queryPersonByTel(String tel);

    public void reply(Long id) throws IOException;

    public void control(Long id,HttpServletRequest request,String userName,Long userId);
}
