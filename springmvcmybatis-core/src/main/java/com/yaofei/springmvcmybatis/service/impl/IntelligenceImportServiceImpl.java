package com.yaofei.springmvcmybatis.service.impl;

import com.alibaba.fastjson.JSON;
import com.yaofei.springmvcmybatis.dto.es.index.CommonIndex;
import com.yaofei.springmvcmybatis.dto.fileserver.uploadresponse.UploadResponse;
import com.yaofei.springmvcmybatis.entity.*;
import com.yaofei.springmvcmybatis.exception.BussinessException;
import com.yaofei.springmvcmybatis.repository.IntelligenceImportRepository;
import com.yaofei.springmvcmybatis.service.*;
import com.yaofei.springmvcmybatis.utils.DateTimeUtil;
import com.yaofei.springmvcmybatis.utils.ReadExcel;
import com.yaofei.springmvcmybatis.utils.WDWUtil;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.lang3.StringUtils;
import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service( "intelligenceImportService" )
public class IntelligenceImportServiceImpl extends AbstractBaseService<IntelligenceImport> implements IntelligenceImportService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static final String ES_ID_PREFIX = "IntelligenceImport_";

    //图片保存路径
    @Value( "${upload.temp.dir}" )
    private String upload_dir = "upload_temp";
    //文件服务器地址
    @Value( "${fileserver.upload.url}" )
    private String fileServerUploadUrl;

    @Autowired
    private IntelligenceImportRepository intelligenceImportRepository;
    @Autowired
    private IntelligenceBusinessTypeService intelligenceBusinessTypeService;
    @Autowired
    private SysAreaService sysAreaService;
    @Autowired
    private EsClientServiceCommonIndex esClientServiceCommonIndex;
    @Autowired
    private StaticFileClassService staticFileClassService;

    @Override
    public void addAndUpload(CommonsMultipartFile[] files, Long areaId, Long businessTypeId, Integer fileType, String fileDesc, String collectTime, String remark, String username, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获得原始文件名
        String originalFilename = files[0].getOriginalFilename();
        //截取文件名后缀
        String nameSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //保存文件到本地
        String tempFileName = saveTempFile(files[0], request, nameSuffix);
        IntelligenceImport intelligenceImport = new IntelligenceImport();
        intelligenceImport.setFileType(fileType);
        intelligenceImport.setBusinessTypeId(businessTypeId);
        intelligenceImport.setFilename(originalFilename);
        intelligenceImport.setFileDesc(fileDesc);
        intelligenceImport.setCollectTime(DateTimeUtil.parse(collectTime));
        intelligenceImport.setCreatedBy(username);
        intelligenceImport.setCreatedIp(request.getRemoteAddr());
        intelligenceImport.setRemark(remark);
        intelligenceImport.setAreaId(areaId);
        // 把内容保存到es
        List<CommonIndex> commonIndexes = null;
        List<CommonIndex> commonIndexes1 = null;

        if (fileType == 1) {//结构化数据
            List<StaticFileClass> staticFileClasses = parseFileData(tempFileName, username, request.getRemoteAddr(), areaId);
            /*String fileUrl = getUploadImageWebUrl(tempFileName);*/
            /*intelligenceImport.setFileUrl(fileUrl);*/
            intelligenceImportRepository.save(intelligenceImport);
            for (StaticFileClass staticFileClass : staticFileClasses) {
                /*commonIndexes = new ArrayList<>();*/
                staticFileClass.setBusinessTypeId(businessTypeId);
                staticFileClass.setFileType(fileType);
                staticFileClass.setCollectTime(DateTimeUtil.parse(collectTime));
                staticFileClassService.save(staticFileClass);
                /*staticFileClass.setDetailsUrl(fileUrl);*/
                /*CommonIndex commonIndex = getCommonIndex(staticFileClass, intelligenceImport);
                commonIndexes.add(commonIndex);
                String indexName = esClientServiceCommonIndex.createIndex(commonIndexes);
                staticFileClass.setEsIndexName(indexName);*/
                /*staticFileClassService.update(staticFileClass);*/
            }
        } else {
            commonIndexes = new ArrayList<>();
            commonIndexes1 = new ArrayList<>();
            intelligenceImportRepository.save(intelligenceImport);
            String fileContent = parseFileContent(fileType, tempFileName, username, request.getRemoteAddr(), areaId);
            CommonIndex commonIndex = getCommonIndex(fileContent, intelligenceImport);
            commonIndexes.add(commonIndex);
            String fileUrl = getUploadImageWebUrl(tempFileName);
            intelligenceImport.setFileUrl(fileUrl);
            /*CommonIndex commonIndex1 = getCommonIndex(fileContent, intelligenceImport);
            commonIndexes1.add(commonIndex1);
            String indexName = esClientServiceCommonIndex.createIndex(commonIndexes1);
            intelligenceImport.setEsIndexName(indexName);*/
            intelligenceImportRepository.update(intelligenceImport);
        }
    }
    private CommonIndex getCommonIndex(String fileContent, IntelligenceImport intelligenceImport) {
        CommonIndex commonIndex = new CommonIndex();
        commonIndex.setAreaId(intelligenceImport.getAreaId());
        commonIndex.setCollectTime(intelligenceImport.getCollectTime());
        commonIndex.setAreaName(sysAreaService.getParentString(intelligenceImport.getAreaId()));
        commonIndex.setBusinessTypeId(intelligenceImport.getBusinessTypeId());
        commonIndex.setBusinessTypeName(intelligenceBusinessTypeService.getParentString(intelligenceImport.getBusinessTypeId()));
        Integer fileType = intelligenceImport.getFileType();
        commonIndex.setCreatedTime(new Date());
        commonIndex.setFileType(intelligenceImport.getFileType());
        commonIndex.setId(ES_ID_PREFIX + intelligenceImport.getId());
        commonIndex.setSuggest(intelligenceImport.getFilename());
        //commonIndex.setTitle(intelligenceImport.getFilename());
        commonIndex.setName1(intelligenceImport.getFilename());
        commonIndex.setIdCardNum1("");
        commonIndex.setLocation1("");
        commonIndex.setDtTime(new Date());
        commonIndex.setName2("");
        commonIndex.setIdCardNum2("");
        commonIndex.setLocation2("");

        if (fileType == 2 || fileType == 3 || fileType == 4 || fileType == 5 || fileType == 6 || fileType == 7) {
            commonIndex.setContent("文件内容：" + fileContent + ";    文件内容描述：" + intelligenceImport.getFileDesc());
        } else {
            commonIndex.setContent("文件内容描述：" + intelligenceImport.getFileDesc());
        }

        commonIndex.setUrl(intelligenceImport.getFileUrl());
        return commonIndex;
    }

    private CommonIndex getCommonIndex(StaticFileClass staticFileClass, IntelligenceImport intelligenceImport) {
        CommonIndex commonIndex = new CommonIndex();
        commonIndex.setAreaId(intelligenceImport.getAreaId());
        commonIndex.setCollectTime(intelligenceImport.getCollectTime());
        commonIndex.setAreaName(sysAreaService.getParentString(intelligenceImport.getAreaId()));
        commonIndex.setBusinessTypeId(intelligenceImport.getBusinessTypeId());
        commonIndex.setBusinessTypeName(intelligenceBusinessTypeService.getParentString(intelligenceImport.getBusinessTypeId()));
        commonIndex.setCreatedTime(new Date());
        commonIndex.setFileType(intelligenceImport.getFileType());
        commonIndex.setId(ES_ID_PREFIX + staticFileClass.getId());
        commonIndex.setSuggest(staticFileClass.getName());
        //commonIndex.setTitle("姓名：" + staticFileClass.getName() + "身份证号：" + staticFileClass.getIdCardNo());
        commonIndex.setName1(staticFileClass.getName());
        commonIndex.setIdCardNum1(staticFileClass.getIdCardNo());
        commonIndex.setLocation1("");
        commonIndex.setDtTime(new Date());
        commonIndex.setName2("");
        commonIndex.setIdCardNum2("");
        commonIndex.setLocation2("");
        commonIndex.setContent(staticFileClass.toString());
        commonIndex.setUrl(staticFileClass.getDetailsUrl());
        //名称
        commonIndex.setInformationProvider("桐柏公安局");
        //地址
        commonIndex.setProviderAddress("桐柏公安局");
        //所属公安机关
        commonIndex.setPoliceOffice("桐柏公安局");
        //联系人
        commonIndex.setContactPerson("付科长");
        //联系电话
        commonIndex.setContactPhone("18336691166");
        return commonIndex;
    }


    public List<StaticFileClass> parseFileData(String tempFileName, String username, String ip, Long areaId) throws Exception {
        ReadExcel readExcel = new ReadExcel();
        List<StaticFileClass> staticFileClasses = readExcel.readExcelStatic(tempFileName, username, ip, areaId);
        return staticFileClasses;
    }

    public String parseFileContent(Integer fileType, String tempFileName, String username, String ip, Long areaId) throws Exception {
        if (fileType == 2 || fileType == 3 || fileType == 4 || fileType == 5 || fileType == 6 || fileType == 7) {
            Tika tika = new Tika();
            tika.setMaxStringLength(50000000);
            return tika.parseToString(new File(tempFileName));
        } else {
            return "";
        }
    }

    //保存文件到本地服务器
    private String saveTempFile(CommonsMultipartFile file, HttpServletRequest request, String nameSuffix) throws IOException {
        // 设定文件保存的目录
        String filePath = request.getSession().getServletContext().getRealPath("/") + upload_dir + File.separator;
        //判断文件是否存在
        judeDirExists(new File(filePath));
        //生成文件名字
        String tempFileName = filePath + getUUID() + nameSuffix;

        try (FileOutputStream fos = new FileOutputStream(tempFileName)) {

            try (InputStream in = file.getInputStream()) {
                byte[] buffer = new byte[1024];
                int b;
                while ((b = in.read(buffer)) > -1) {
                    fos.write(buffer, 0, b);
                }
                in.close();
            }

        }

        return tempFileName;
    }

    // 判断文件夹是否存在
    public void judeDirExists(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("dir exists");
            } else {
                System.out.println("the same name file exists, can not create dir");
            }
        } else {
            System.out.println("dir not exists, create it ...");
            file.mkdirs();
        }
    }

    public static String getUUID() {
        String s = UUID.randomUUID().toString();
        //去掉“-”符号
        return s.replace("-", "");
    }

    @Override
    protected void deleteBefore(Object id) throws IOException {
        IntelligenceImport intelligenceImport = intelligenceImportRepository.queryObject(id);
        /*if (StringUtils.isNotBlank(intelligenceImport.getEsIndexName())) {
            esClientServiceCommonIndex.deleteIndex(intelligenceImport.getEsIndexName(), ES_ID_PREFIX + id.toString());
        }*/
        super.deleteBefore(id);
    }

    @Override
    protected void deleteBatchBefore(Object[] ids) throws IOException {
        IntelligenceImport intelligenceImport;
       /* for (Object id : ids) {
            intelligenceImport = intelligenceImportRepository.queryObject(id);
            if (StringUtils.isNotBlank(intelligenceImport.getEsIndexName())) {
                esClientServiceCommonIndex.deleteIndex(intelligenceImport.getEsIndexName(), ES_ID_PREFIX + id.toString());
            }
        }*/
        super.deleteBatchBefore(ids);
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        PostMethod postMethod = new PostMethod(targetURL);
        try {
            //通过以下方法可以模拟页面参数提交
            //filePost.setParameter("name", "中文");
            //filePost.setParameter("pass", "1234");
            //FilePart：用来上传文件的类

            List<Part> partList = new ArrayList<>();
            FilePart filePart;
            String a = simpleDateFormat.format(new Date(System.currentTimeMillis()));
            for (File file : files) {
                filePart = new FilePart("uploadfile", file);
                partList.add(filePart);
            }

            Part[] parts = new Part[partList.size()];
            partList.toArray(parts);

            //对于MIME类型的请求，httpclient建议全用MulitPartRequestEntity进行包装
            MultipartRequestEntity mre = new MultipartRequestEntity(parts, postMethod.getParams());
            String b = simpleDateFormat.format(new Date(System.currentTimeMillis()));
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


    /**
     * 验证EXCEL文件
     *
     * @param filePath
     * @return
     */
    public boolean validateExcel(String filePath) {
        if (filePath == null || !(WDWUtil.isExcel2003(filePath) || WDWUtil.isExcel2007(filePath))) {
            return false;
        }
        return true;
    }

    public void fileUpload(String filePath, String filesName, Long areaId, Long businessTypeId, Integer fileType, String fileDesc,
                           String collectTime, String remark, String username, String ip) throws Exception  {
        // 获得原始文件名
        String originalFilename = filesName;
        //截取文件名后缀
        String nameSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //保存文件到本地
        String tempFileName = saveTempFileJava(filePath, nameSuffix);

        IntelligenceImport intelligenceImport = new IntelligenceImport();

        intelligenceImport.setFileType(fileType);
        intelligenceImport.setBusinessTypeId(businessTypeId);
        intelligenceImport.setFilename(originalFilename);
        intelligenceImport.setFileDesc(fileDesc);
        intelligenceImport.setCollectTime(DateTimeUtil.parse(collectTime));
        intelligenceImport.setCreatedBy(username);
        intelligenceImport.setCreatedIp(ip);
        intelligenceImport.setRemark(remark);
        intelligenceImport.setAreaId(areaId);

        // 把内容保存到es
        List<CommonIndex> commonIndexes = null;
        List<CommonIndex> commonIndexes1 = null;

        if (fileType == 1) {//结构化数据
            List<StaticFileClass> staticFileClasses = parseFileData(tempFileName, username, ip, areaId);
            String fileUrl = getUploadImageWebUrl(tempFileName);
            intelligenceImport.setFileUrl(fileUrl);
            intelligenceImportRepository.save(intelligenceImport);

            for (StaticFileClass staticFileClass : staticFileClasses) {
                commonIndexes = new ArrayList<>();
                staticFileClass.setBusinessTypeId(businessTypeId);
                staticFileClass.setFileType(fileType);
                staticFileClass.setCollectTime(DateTimeUtil.parse(collectTime));
                staticFileClassService.save(staticFileClass);
                staticFileClass.setDetailsUrl(fileUrl);
                /*CommonIndex commonIndex = getCommonIndex(staticFileClass, intelligenceImport);
                commonIndexes.add(commonIndex);
                String indexName = esClientServiceCommonIndex.createIndex(commonIndexes);
                staticFileClass.setEsIndexName(indexName);*/
                staticFileClassService.update(staticFileClass);
            }
        }
    }

    public void fileBatchUpload(String filePath, String filesName, Long areaId, Long businessTypeId, Integer fileType, String fileDesc,
                                String collectTime, String remark, String username, String ip) throws Exception {
        // 获得原始文件名
        String originalFilename = filesName;
        //截取文件名后缀
        String nameSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //保存文件到本地
        String tempFileName = saveTempFileJava(filePath, nameSuffix);

        IntelligenceImport intelligenceImport = new IntelligenceImport();

        intelligenceImport.setFileType(fileType);
        intelligenceImport.setBusinessTypeId(businessTypeId);
        intelligenceImport.setFilename(originalFilename);
        intelligenceImport.setFileDesc(fileDesc);
        intelligenceImport.setCollectTime(DateTimeUtil.parse(collectTime));
        intelligenceImport.setCreatedBy(username);
        intelligenceImport.setCreatedIp(ip);
        intelligenceImport.setRemark(remark);
        intelligenceImport.setAreaId(areaId);

        // 把内容保存到es
        List<CommonIndex> commonIndexes = null;

        if (fileType == 1) {//结构化数据
            List<StaticFileClass> staticFileClasses = parseFileData(tempFileName, username, ip, areaId);
            String fileUrl = getUploadImageWebUrl(tempFileName);
            intelligenceImport.setFileUrl(fileUrl);
            intelligenceImportRepository.save(intelligenceImport);
            int size = staticFileClasses.size();
            final int batchSize = 1000;
            for (int i = 0; i < size; i++) {
                List<StaticFileClass> staticFileClassesList = new ArrayList<StaticFileClass>();
                staticFileClassesList.add(staticFileClasses.get(i));
                if (i % batchSize == 0 || i == size - 1) {
                    //每1000个一提交
                    staticFileClassService.saveAll(staticFileClassesList);
                    for (StaticFileClass staticFileClass : staticFileClassesList) {
                        commonIndexes = new ArrayList<>();
                        staticFileClass.setBusinessTypeId(businessTypeId);
                        staticFileClass.setFileType(fileType);
                        staticFileClass.setCollectTime(DateTimeUtil.parse(collectTime));
                        staticFileClass.setDetailsUrl(fileUrl);
                        /*CommonIndex commonIndex = getCommonIndex(staticFileClass, intelligenceImport);
                        commonIndexes.add(commonIndex);
                        String indexName = esClientServiceCommonIndex.createIndex(commonIndexes);
                        staticFileClass.setEsIndexName(indexName);*/
                    }
                    staticFileClassService.updateAll(staticFileClassesList);
                    staticFileClassesList.clear();
                }
            }
        }
    }

    private String saveTempFileJava(String file, String nameSuffix) throws IOException {
        // 设定文件保存的目录
        /*HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();*/
        File directory = new File("");
        String path = directory.getAbsolutePath();
        String path1 = this.getClass().getClassLoader().getResource("").getPath();
        String filePath = path1 + "/" + upload_dir + File.separator;
        //判断文件是否存在
        judeDirExists(new File(filePath));
        //生成文件名字
        String tempFileName = filePath + getUUID() + nameSuffix;

        try (FileOutputStream fos = new FileOutputStream(tempFileName)) {
            try (InputStream in = new FileInputStream(file)) {
                byte[] buffer = new byte[1024];
                int b;
                while ((b = in.read(buffer)) > -1) {
                    fos.write(buffer, 0, b);
                }
                in.close();
            }

        }

        return tempFileName;
    }


}