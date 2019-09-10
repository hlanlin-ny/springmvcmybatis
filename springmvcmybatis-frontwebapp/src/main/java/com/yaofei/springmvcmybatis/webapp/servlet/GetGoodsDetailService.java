package com.yaofei.springmvcmybatis.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class GetGoodsDetailService extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String snNumber = request.getParameter("snNumber");
		System.out.println(snNumber);
		snNumber = "fdsafads";
		List resultMapList = null;
		Map resultMap = null;
		if (StringUtils.isNotEmpty(snNumber)) {
			String sql = "SELECT go.`serial_number`,go.`quality_begin_date`,go.`quality_expiry_date`, "
					+ "go.`promise_begin_date`,go.`promise_expiry_date`,gtype.`type_name`, "
					+ "go.`flow_status`,go.`specification`,sup.`supplier_name`, "
					+ "inre.`instock_time`,bill.`outstock_time`,gset.`setup_time`, "
					+ "su.`real_name`,gset.`setup_position`,proj.`project_name`, "
					+ "cust.`customer_name`,sub.`real_name` real_name_d, "
					+ "mar.`is_marked`,sumar.`real_name` real_name_mar,go.`remark` "
					+ "FROM wms_goods go "
					+ "LEFT JOIN wms_goods_type gtype ON gtype.`id`=go.`type_id` "
					+ "LEFT JOIN wms_supplier sup ON sup.`id`=go.`supplier_id` "
					+ "LEFT JOIN wms_instock_record inre ON inre.`goods_id`=go.`id` "
					+ "LEFT JOIN wms_outstock_bill_item bitem ON bitem.`goods_id`=go.`id` "
					+ "LEFT JOIN wms_outstock_bill bill ON bill.`id`=bitem.`bill_id` "
					+ "LEFT JOIN wms_goods_setup gset ON gset.`goods_id`=go.`id` "
					+ "LEFT JOIN sys_user su ON su.`id`=gset.`setup_operator_id` "
					+ "LEFT JOIN wms_project proj ON proj.`id`=go.`project_id` "
					+ "LEFT JOIN wms_customer cust ON cust.`id`=proj.`customer_id` "
					+ "LEFT JOIN sys_user sub ON sub.`id`=bill.`delivery_operator_id` "
					+ "LEFT JOIN wms_goods_marker mar ON mar.`goods_id`=go.`id` "
					+ "LEFT JOIN sys_user sumar ON sumar.`id`=mar.`marked_operator_id`";
			String whereSql = " WHERE go.`is_deleted`=FALSE AND go.`serial_number`='"
					+ snNumber + "'";
			try {
//				resultMapList = JdbcHelper.query(sql+whereSql);
				if (resultMapList != null && resultMapList.size() > 0) {
					resultMap = (Map) resultMapList.get(0);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String strJson = JSON.toJSONString(resultMap);
		System.out.println(strJson);

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(strJson);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
