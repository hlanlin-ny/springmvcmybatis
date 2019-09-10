package com.yaofei.springmvcmybatis.service.impl;

import com.alibaba.fastjson.JSON;
import com.yaofei.springmvcmybatis.dto.fileserver.uploadresponse.UploadResponse;
import com.yaofei.springmvcmybatis.entity.SysConfig;
import com.yaofei.springmvcmybatis.exception.BussinessException;
import com.yaofei.springmvcmybatis.repository.SysConfigRepository;
import com.yaofei.springmvcmybatis.service.SysConfigService;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("sysConfigService")
public class SysConfigServiceImpl extends AbstractBaseService<SysConfig> implements SysConfigService {
	@Autowired
	private SysConfigRepository sysConfigRepository;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	//图片保存路径
	@Value("${upload.temp.dir}")
	private String upload_dir = "upload_temp";
	//文件服务器地址
	@Value("${fileserver.upload.url}")
	private String fileServerUploadUrl;

	@Override
	public String uploadImage(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 获得原始文件名
		String originalFilename = file.getOriginalFilename();
		//截取文件名后缀
		String nameSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
		String tempFileName = saveTempFile(file, request, nameSuffix);
		String fileUrl = getUploadImageWebUrl(tempFileName);
		return fileUrl;
	}

	@Override
	public String uploadWarningMusic(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 获得原始文件名
		String originalFilename = file.getOriginalFilename();
		//截取文件名后缀
		String nameSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
		String tempFileName = saveTempFile(file, request, nameSuffix);
		String fileUrl = getUploadImageWebUrl(tempFileName);
		return fileUrl;
	}

	@Override
	public String uploadBgMusic(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 获得原始文件名
		String originalFilename = file.getOriginalFilename();
		//截取文件名后缀
		String nameSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
		String tempFileName = saveTempFile(file, request, nameSuffix);
		String fileUrl = getUploadImageWebUrl(tempFileName);
		return fileUrl;
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


	//保存文件到本地服务器
	private String saveTempFile(MultipartFile file, HttpServletRequest request, String nameSuffix) throws IOException {
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