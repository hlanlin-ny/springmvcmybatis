package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.IntelligenceImport;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 情报导入记录
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-01 11:11:40
 */
public interface IntelligenceImportService extends BaseService<IntelligenceImport> {

    void addAndUpload(CommonsMultipartFile[] files,Long areaId, Long businessTypeId, Integer fileType, String fileDesc, String collectTime, String remark,String username, HttpServletRequest request, HttpServletResponse response) throws Exception;

}