package com.yaofei.springmvcmybatis.task.quartz;

import com.alibaba.fastjson.JSON;
import com.yaofei.springmvcmybatis.entity.SysSearchwarningConfig;
import com.yaofei.springmvcmybatis.entity.SysSearchwarningLog;
import com.yaofei.springmvcmybatis.service.SearchService;
import com.yaofei.springmvcmybatis.service.SysSearchwarningLogService;
import com.yaofei.springmvcmybatis.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by 87796 on 2017/8/30.
 */
@Component("warnSearchJob")
public class WarnSearchScheduleJob {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private SysSearchwarningLogService logService;
    @Autowired
    private SearchService searchservice;
    @Autowired
    private SysUserService userService;

    public void run(SysSearchwarningConfig params){
//        logger.info("搜索预警功能的后台任务，正在被执行，参数为：" + params.toString());
//        //搜索
//        Long result = search(params);
//        //搜索结果入库,并发送联系人
//        if(result!=null&&result>0L){
//            Long freq = Long.parseLong(params.getNoticeFrequency())*60;
//            Long nowDate = (new Date()).getTime();
//            Date lastDate = logService.queryLastNoticeTime(params.getId());
//            String noticeT0Email = userService.queryObject(params.getNoticeTo()).getEmail();
//            String messageFrom = "xxxxxxxx@qq.com";//发件人
//            String password = "ofyzryvdhnyxxjnc";//发件人邮箱密码，QQ邮箱的16为授权密码
//            String fromName = "fromName";//发件人昵称
//            String toName = "toName";//收件人昵称
//            String subject = "邮箱测试！！！";//邮件主题
//            String content = "你好，邮箱测试！！！";//邮件内容
//            if(lastDate==null){
//                //搜索结果入库
//                resuleInsert(params,result);
//                //通知联系人
////                try {
////                    toNotice(messageFrom,fromName,password, noticeT0Email,toName,subject,content);
////                } catch (IOException e) {
////                    e.printStackTrace();
////                } catch (MessagingException e) {
////                    e.printStackTrace();
////                } catch (GeneralSecurityException e) {
////                    e.printStackTrace();
////                }
//
//            }else {
//                if (nowDate >= lastDate.getTime() + freq) {
//                    //搜索结果入库
//                    resuleInsert(params,result);
//                    //通知联系人
//                    try {
//                        toNotice(messageFrom,fromName,password, noticeT0Email,toName,subject,content);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    } catch (MessagingException e) {
//                        e.printStackTrace();
//                    } catch (GeneralSecurityException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//        }
    }

    //搜索
    private Long search(SysSearchwarningConfig params){
        logger.info("搜索预警功能的后台任务，正在被执行，search()方法：");
        List<Long> bussinesstypeIds =  JSON.parseArray(params.getBusinesstypeid(), Long.class);
        List<Integer> fileTypes = JSON.parseArray(params.getFiletype(),Integer.class);
        Long result = searchservice.querySearchResult(bussinesstypeIds,params.getKeywords(),params.getIsExactMatching(),
                Long.valueOf(params.getNoticeTo()),params.getAreaId(),params.getNoticeToName(),
                fileTypes,params.getStartTime()).getTotalHits();
        return result;
    }
    //搜索结果入库
    private void resuleInsert(SysSearchwarningConfig params,Long result){
        logger.info("搜索预警功能的后台任务，正在被执行，resuleInsert()方法：");
        SysSearchwarningLog entiy = new SysSearchwarningLog();
        entiy.setSearchwarningConfigId(params.getId());
        entiy.setRecordCount(result);
        entiy.setKeywords(params.getKeywords());
        entiy.setCreatedTime(new Date());
        logService.save(entiy);
    }
    //通知联系人
    /*
     * messageFrom:发件人邮箱
     * fromName：发件人昵称
     * password：发件邮箱密码或授权密码
     * messageTo：收件人邮箱
     * toName：收件人昵称
     * subject：邮件主题
     * content：邮件内容
     */
    private void toNotice(String messageFrom,String fromName,String password,String messageTo,String toName,String subject,String content) throws IOException, MessagingException, GeneralSecurityException {
        logger.info("搜索预警功能的后台任务，正在被执行，toNotice()方法：");

        // 用于连接邮件服务器的参数配置（发送邮件时才需要用到）
        Properties props = new Properties();
        // 开启debug调试
        props.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp.qq.com");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");

        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        // 根据参数配置，创建会话对象（为了发送邮件准备的）
        Session session= Session.getDefaultInstance(props);
        session.setDebug(true);
        // 创建邮件对象
        Message message = new MimeMessage(session);

        // 2. From: 发件人
        //    其中 InternetAddress 的三个参数分别为: 邮箱, 显示的昵称(只用于显示, 没有特别的要求), 昵称的字符集编码
        //    真正要发送时, 邮箱必须是真实有效的邮箱。
        message.setFrom(new InternetAddress(messageFrom, fromName, "UTF-8"));

        // 3. To: 收件人
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(messageTo, toName, "UTF-8"));

        // 4. Subject: 邮件主题
        message.setSubject(subject);

        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent(content, "text/html;charset=UTF-8");

        // 6. 设置显示的发件时间
        message.setSentDate(new Date());

        message.saveChanges();//存储邮件信息

        //7. 发送邮件
        Transport transport = session.getTransport();
        // 连接邮件服务器
        transport.connect(messageFrom,password);
        // 发送邮件
        transport.sendMessage(message, new Address[] {new InternetAddress(messageTo)});
        // 关闭连接
        transport.close();
    }

    public static void main(String[] args){
        String messageFrom = "877962769@qq.com";//发件人
        String password = "ofxzeydhnxojbchh";//发件人邮箱密码，QQ邮箱的16为授权密码
        String fromName = "fromName";//发件人昵称
        String messageT0 = "3535230263@qq.com";//收件人
        String toName = "toName";//收件人昵称
        String subject = "邮箱测试！！！";//邮件主题
        String content = "你好，邮箱测试！！！";//邮件内容
        WarnSearchScheduleJob testJob = new WarnSearchScheduleJob();
        try {
            testJob.toNotice(messageFrom,fromName,password, messageT0,toName,subject,content);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

    }

}
