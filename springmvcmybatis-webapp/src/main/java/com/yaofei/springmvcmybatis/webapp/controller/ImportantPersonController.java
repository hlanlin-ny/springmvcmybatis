package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.ImportantPerson;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.service.ImportantPersonService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;

/**
 * 重点人员信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-09-14 09:30:59
 */
@Controller
@RequestMapping("/admin/importantperson")
public class ImportantPersonController extends BaseCRUDController<ImportantPerson>  {
	@Autowired
	private ImportantPersonService importantPersonService;


	@ResponseBody
	@RequestMapping(value = "/reply",method = RequestMethod.POST)
    public JsonResult reply(Long id,HttpServletRequest request) throws IOException {
		importantPersonService.reply(id);
		return  JsonResult.ok();
	}


	@ResponseBody
	@RequestMapping(value = "/control",method = RequestMethod.POST)
	public JsonResult control(Long id,HttpServletRequest request){
		importantPersonService.control(id,request,super.getUsername(),super.getUserId());
		return  JsonResult.ok();
	}


	//导出excel模板
	@RequestMapping(value = "/template/download", method = RequestMethod.POST)
	public void downLoadExcelModel( HttpServletRequest request,
									HttpServletResponse response) throws Exception {

       //获取要下载的模板名称
		String fileName = "重点人员信息模板.xlsx".toString();
		final String userAgent = request.getHeader("USER-AGENT");
		String finalFileName = null;
		if(StringUtils.contains(userAgent, "MSIE")){//IE浏览器
			finalFileName = URLEncoder.encode(fileName, "UTF8");
		}else if(StringUtils.contains(userAgent, "Mozilla")){//google,火狐浏览器
			finalFileName = new String(fileName.getBytes(), "ISO8859-1");
		}else{
			finalFileName = URLEncoder.encode(fileName,"UTF8");//其他浏览器
		}
       //这里设置一下让浏览器弹出下载提示框，而不是直接在浏览器中打开
		response.setHeader("Content-Disposition", "attachment; filename=\"" + finalFileName + "\"");
       //通知客服文件的MIME类型
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
       //获取文件的路径
		String filePath = request.getSession().getServletContext().getRealPath("/EXCEL")+"/"+fileName;
		filePath = filePath.replace("\\", "/");
		InputStream input = null;
		OutputStream out =null;
		try {
			input = new FileInputStream(filePath);
			out =response.getOutputStream();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] b = new byte[2048];
		int len;
		try {
			while((len=input.read(b))!=-1){
				out.write(b,0,len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	//导入excel数据
	@ResponseBody
	@RequestMapping(value = "/batch/import", method = RequestMethod.POST)
	public JsonResult batchimport(@RequestParam(value="filename") MultipartFile file,
							  HttpServletRequest request,HttpServletResponse response) throws IOException{
         //判断文件是否为空
		if(file==null) return null;
        //获取文件名
		String name=file.getOriginalFilename();
        //进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
		long size=file.getSize();
		if(name==null || ("").equals(name) && size==0) return null;

        //批量导入。参数：文件名，文件。
		String username = super.getUsername();
		String ip = request.getRemoteAddr();
		boolean b = importantPersonService.batchImport(name, file,username,ip,super.getAreaId());
		String result = null;
		if(b){
			String Msg ="批量导入EXCEL成功！";
			request.getSession().setAttribute("msg", Msg);
			System.out.println("批量导入EXCEL成功！");
			return JsonResult.ok().setMessage("导入成功");
		}else{
			String Msg ="批量导入EXCEL失败！";
			request.getSession().setAttribute("msg",Msg);
			System.out.println("批量导入EXCEL失败！");
			result = getViewPrefix() + "/list";
			return JsonResult.ok().setMessage("导入失败");
		}
	}



	@RequestMapping(value="/batch/export", method = RequestMethod.POST)
	public String export(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException, UnsupportedEncodingException {
		String fileName = "重点人员信息";
		final String userAgent = request.getHeader("USER-AGENT");
		String finalFileName;
		if(StringUtils.contains(userAgent, "MSIE")){//IE浏览器
			finalFileName = URLEncoder.encode(fileName, "UTF8");
		}else if(StringUtils.contains(userAgent, "Mozilla")){//google,火狐浏览器
			finalFileName = new String(fileName.getBytes(), "ISO8859-1");
		}else{
			finalFileName = URLEncoder.encode(fileName,"UTF8");//其他浏览器
		}
		if(finalFileName!=""){
			response.reset(); //清除buffer缓存
          // 指定下载的文件名
			response.setHeader("Content-Disposition", "attachment;filename="+finalFileName+".xls");
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			HSSFWorkbook workbook=null;
          //导出Excel对象
			workbook = importantPersonService.exportExcelInfo();
			OutputStream output;
			try {
				output = response.getOutputStream();
				BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
				bufferedOutPut.flush();
				workbook.write(bufferedOutPut);
				bufferedOutPut.close();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}


	public String queryTel(Long id){

		String tel = importantPersonService.queryTel(id);
		return tel;
	}

	public String queryIDcard(Long id){
		String idcard = importantPersonService.queryTel(id);
		return idcard;
	}

	@Override
	protected void addBefore(ImportantPerson entity, BindingResult result, HttpServletRequest request, HttpServletResponse response){
		super.addBefore(entity, result, request, response);
		Field[] declaredFields = this.entityClass.getDeclaredFields();
		for (Field declaredField : declaredFields) {
			switch (declaredField.getName()) {
				case "areaId":
					try {
						BeanUtils.setProperty(entity, "areaId", super.getAreaId());
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					break;
				default:
					break;
			}
		}
	}

	@Override
	protected void queryListBefore(HttpServletRequest request, HttpServletResponse response, DataTablesRequest dataTablesRequest) {
		Long areaId = super.getAreaId();
		dataTablesRequest.getExtraSearch().put("areaId", String.valueOf(areaId));
	}
}