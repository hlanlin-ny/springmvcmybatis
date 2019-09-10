package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.WarningDispostion;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

/**
 * 预警处置详情
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-21 11:14:23
 */
public interface WarningDispostionService extends BaseService<WarningDispostion> {

       List<Object> queryDisposition(Long id);

        List<Object> detail(Long id);

       WarningDispostion queryByRelateId(Long id);

        List<Object> queryFeedBack(Long id);

        boolean saveList(HttpServletRequest request,String name) throws ParseException;

        boolean saveDisposition(HttpServletRequest request,String name) throws Exception;

       public void claim(Long id);

       public List<WarningDispostion>compare();

       public int queryUnclaim();



}
