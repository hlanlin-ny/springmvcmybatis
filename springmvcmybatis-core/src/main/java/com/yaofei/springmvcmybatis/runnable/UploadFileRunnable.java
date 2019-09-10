package com.yaofei.springmvcmybatis.runnable;

import com.alibaba.fastjson.JSON;
import com.yaofei.springmvcmybatis.dto.fileserver.uploadresponse.UploadResponse;
import com.yaofei.springmvcmybatis.entity.IntelligenceImport;
import com.yaofei.springmvcmybatis.exception.BussinessException;
import com.yaofei.springmvcmybatis.repository.IntelligenceImportRepository;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by phoenix on 2017/7/20.
 */
public class UploadFileRunnable implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private String tempFileName;
    private String fileServerUploadUrl;
    private IntelligenceImportRepository intelligenceImportRepository;
    private Long intelligenceImportId;

    //public SaveSearchLogRunnable() {
    //}

    public UploadFileRunnable(String _tempFileName, String _fileServerUploadUrl, IntelligenceImportRepository _intelligenceImportRepository, Long _intelligenceImportId) {
        tempFileName = _tempFileName;
        fileServerUploadUrl = _fileServerUploadUrl;
        intelligenceImportRepository = _intelligenceImportRepository;
        intelligenceImportId = _intelligenceImportId;
    }

    @Override
    public void run() {
        try {
            // 上传到文件服务器
            String fileUrl = getUploadImageWebUrl(tempFileName);
            IntelligenceImport intelligenceImport = intelligenceImportRepository.queryObject(intelligenceImportId);
            intelligenceImport.setFileUrl(fileUrl);
            intelligenceImportRepository.update(intelligenceImport);
        } catch (Exception e) {
            logger.error("UploadFileRunnable.run() error", e);
        }
    }

    private String getUploadImageWebUrl(String fileName) throws Exception {

        List<File> files = new ArrayList<>();
        File targetFile = new File(fileName);
        files.add(targetFile);
        String uploadResponseString = uploadFile(files, fileServerUploadUrl);
        if (uploadResponseString == null) {
            logger.error(" uploadResponseString:" + uploadResponseString);
            throw new BussinessException("文件上传失败");
        }
        UploadResponse uploadResponse = JSON.parseObject(uploadResponseString, UploadResponse.class);
        if (uploadResponse == null || uploadResponse.getCode() != 0 || uploadResponse.getResult() == null || uploadResponse.getResult().size() == 0) {
            logger.error(" uploadResponseString:" + uploadResponseString);
            throw new BussinessException("文件上传失败");
        }
        //上传成功后，删除临时文件。后续再做一个定时任务，实时删除今天以前的所有临时文件
        deleteFile(fileName);
        return uploadResponse.getResult().get(0).getWebAccessUrl();
    }

    public String uploadFile(List<File> files, String targetURL) {
        int status = 0;
        String response = "";
        PostMethod postMethod = new PostMethod(targetURL);
        try {
            //通过以下方法可以模拟页面参数提交
            //filePost.setParameter("name", "中文");
            //filePost.setParameter("pass", "1234");
            //FilePart：用来上传文件的类

            List<Part> partList = new ArrayList<>();
            FilePart filePart;
            for (File file : files) {
                filePart = new FilePart("uploadfile", file);
                partList.add(filePart);
            }
            Part[] parts = new Part[partList.size()];
            partList.toArray(parts);

            //对于MIME类型的请求，httpclient建议全用MulitPartRequestEntity进行包装
            MultipartRequestEntity mre = new MultipartRequestEntity(parts, postMethod.getParams());
            postMethod.setRequestEntity(mre);

            HttpClient client = new HttpClient();
            client.getHttpConnectionManager().getParams().setConnectionTimeout(50000);// 设置连接时间
            status = client.executeMethod(postMethod);

            if (status == HttpStatus.SC_OK) {
                response = postMethod.getResponseBodyAsString();
            } else {
                System.out.println("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放连接
            postMethod.releaseConnection();
        }

        logger.debug("uploadFile. url:" + targetURL + ". status:" + status + " response:" + response);
        return response;
    }

    /**
     * 删除单个文件
     *
     * @param fileName 要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }
}