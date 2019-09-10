package com.filesever;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by phoenix on 2017/6/9.
 */
public class Test {
    public static void main(String[] args) {

        String targetURL = "http://localhost:8088/UploadFile/Upload";
        List<File> files = new ArrayList<>();
        File targetFile = new File("D:\\Users\\phoenix\\Desktop\\images\\1_08.jpg");
        files.add(targetFile);
        targetFile = new File("D:\\Users\\phoenix\\Desktop\\images\\1_07.jpg");
        files.add(targetFile);
        targetFile = new File("D:\\Users\\phoenix\\Desktop\\images\\1_06.jpg");
        files.add(targetFile);
        uploadFile(files, targetURL);
    }

    public static void uploadFile(List<File> files, String targetURL) {
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
            int status = client.executeMethod(postMethod);
            System.out.println("=========== status:" + status);
            if (status == HttpStatus.SC_OK) {
                System.out.println(postMethod.getResponseBodyAsString());
            } else {
                System.out.println("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放连接
            postMethod.releaseConnection();
        }
    }

}
