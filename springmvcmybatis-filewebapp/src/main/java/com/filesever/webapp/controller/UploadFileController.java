package com.filesever.webapp.controller;

import com.filesever.webapp.dto.JsonResult;
import com.filesever.webapp.dto.UploadFileInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by phoenix on 2017/6/9.
 */
@Controller
@RequestMapping(value = "/UploadFile")
public class UploadFileController {

    private final static String UPLOAD_DIR = "upload";

    public static String getUUID() {
        String s = UUID.randomUUID().toString();
        //去掉“-”符号
        return s.replace("-", "");
    }

    @ResponseBody
    @RequestMapping(value = "/Upload")
    public JsonResult uploadImg(@RequestParam("uploadfile") CommonsMultipartFile files[], HttpServletRequest request) {
        try {
            SimpleDateFormat yearDateFormat = new SimpleDateFormat("yyyy");
            SimpleDateFormat monthDateFormat = new SimpleDateFormat("MM");
            SimpleDateFormat dayDateFormat = new SimpleDateFormat("dd");
            //SimpleDateFormat timeDateFormat = new SimpleDateFormat("HH_mm_ss");
            Date dateNow = new Date();
            String year = yearDateFormat.format(dateNow);
            String month = monthDateFormat.format(dateNow);
            String day = dayDateFormat.format(dateNow);
            //String time = timeDateFormat.format(dateNow);

            // 设定文件保存的目录
            String filePath = request.getSession().getServletContext().getRealPath("/") + UPLOAD_DIR + File.separator + year + File.separator + month + File.separator + day + File.separator;
            judeDirExists(new File(filePath));

            String baseUrlPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/" + UPLOAD_DIR + "/";

            String newFileName;
            String originalFilename;
            List<UploadFileInfo> uploadFileInfos = new ArrayList<>();
            UploadFileInfo uploadFileInfo;
            for (int i = 0; i < files.length; i++) {
                uploadFileInfo = new UploadFileInfo();
                // 获得原始文件名
                originalFilename = files[i].getOriginalFilename();
                // 新文件名
                //newFileName = getUUID() + "_" + originalFilename;
                newFileName = originalFilename;

                uploadFileInfo.setOriginalFilename(originalFilename);
                uploadFileInfo.setNewFileName(newFileName);

                if (!files[i].isEmpty()) {

                    newFileName = filePath + newFileName;

                    try (FileOutputStream fos = new FileOutputStream(newFileName)) {

                        try (InputStream in = files[i].getInputStream()) {
                            int b;
                            while ((b = in.read()) != -1) {
                                fos.write(b);
                            }
                        }
                    }

                    //得到url
                    uploadFileInfo.setWebAccessUrl(baseUrlPath + year + "/" + month + "/" + day + "/" + uploadFileInfo.getNewFileName());
                    uploadFileInfos.add(uploadFileInfo);
                }
            }

            return JsonResult.ok().addResult(uploadFileInfos);
        } catch (Exception e) {
            return JsonResult.error(e.getMessage());
        }
    }

    // 判断文件夹是否存在
    public void judeDirExists(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                //System.out.println("dir exists");
            } else {
                //System.out.println("the same name file exists, can not create dir");
            }
        } else {
            //System.out.println("dir not exists, create it ...");
            file.mkdirs();
        }
    }
}