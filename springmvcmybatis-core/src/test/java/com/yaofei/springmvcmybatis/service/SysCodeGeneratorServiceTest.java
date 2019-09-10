//package com.yaofei.springmvcmybatis.service;
//
//import com.yaofei.springmvcmybatis.BaseSpringJunit4Test;
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.IOUtils;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipInputStream;
//
//public class SysCodeGeneratorServiceTest extends BaseSpringJunit4Test {
//	@Autowired
//	private SysCodeGeneratorService sysCodeGeneratorService;
//	//zip输出路径
//	String zipPath = "c://test//code.zip";
//	//表名
//	String[] tableNames = new String[] {"sys_user"};
//
//	@Test
//	public void testGeneratorCode() throws IOException {
//		byte[] data = sysCodeGeneratorService.generatorCode(tableNames);
//		File file = new File(zipPath);
//		if(!file.getParentFile().exists()){
//			file.getParentFile().mkdirs();
//		}
//		FileUtils.writeByteArrayToFile(file, data);
//
//
//		//解压zip
//		ZipInputStream zip = new ZipInputStream(new FileInputStream(zipPath));
//		ZipEntry entry;
//		while((entry = zip.getNextEntry()) != null) {
//			file = new File("c://testio//" + entry.getName());
//			if(!file.getParentFile().exists()){
//				file.getParentFile().mkdirs();
//			}
//			FileOutputStream out = new FileOutputStream(file);
//			IOUtils.copy(zip, out);
//		}
//		zip.close();
//	}
//
//}
