package com.yaofei.springmvcmybatis.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AfterSalesService extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sql = "SELECT gser.`id`,su.`real_name`,gser.`service_time`,gser.`service_content`, "
				+ "gser.`service_type`,gser.`is_resolved` "
				+ "FROM wms_goods_service gser "
				+ "LEFT JOIN sys_user su ON su.`id`=gser.`service_operator_id` "
				+ "WHERE gser.`is_deleted`=FALSE";
		List result=null;
		try {
//			result=JdbcHelper.query(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("resultList", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/android/AfterSalesServiceInfo.jsp");
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
