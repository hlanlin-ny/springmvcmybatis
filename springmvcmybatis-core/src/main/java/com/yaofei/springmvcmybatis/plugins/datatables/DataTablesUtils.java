package com.yaofei.springmvcmybatis.plugins.datatables;

import com.yaofei.springmvcmybatis.utils.Underline2Camel;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.Order;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: DataTablesUtils.java
 * @Description: DataTable JQ插件的请求转换工具类
 * @since 2016-8-29
 */
public class DataTablesUtils {

    /**
     * 解析DataTable 请求参数为 DataTableRequest对象
     *
     * @param request
     * @return
     */
    public static DataTablesRequest getDataTableRequest(HttpServletRequest request) {

        DataTablesRequest dataTablesRequest = new DataTablesRequest();
        // 拓展搜索参数
        dataTablesRequest.setExtraSearch(getExtraSearchParam(request.getParameterMap()));

        // "draw", start",  "length"
        dataTablesRequest.setDraw(request.getParameter("draw") == null ? 0 : Integer.valueOf((String) (request.getParameter("draw"))));
        dataTablesRequest.setStart(request.getParameter("start") == null ? 0 : Long.valueOf((String) (request.getParameter("start"))));
        dataTablesRequest.setLength(request.getParameter("length") == null ? 0 : Long.valueOf((String) (request.getParameter("length"))));

        //全局搜索对象
        //Search search = new Search();
        //search.setValue(request.getParameter("search[value]"));
        //search.setRegex(request.getParameter("search[regex]") == null ? false : Boolean.valueOf(request.getParameter("search[regex]")));
        //dataTablesRequest.setSearch(search);

        //排序条件
        List<Order> orderList = new ArrayList<>();
        Integer numOrder = 0;
        String strOrder = "order[" + numOrder + "]";

        while (request.getParameter(strOrder + "[column]") != null) {
            Order order = new Order();

            order.setColumn(Integer.valueOf((String) (request.getParameter(strOrder + "[column]"))));
            order.setDir((String) request.getParameter(strOrder + "[dir]"));

            orderList.add(order);
            numOrder++;
            strOrder = "order[" + numOrder + "]";
        }
        dataTablesRequest.setOrder(orderList);

        // 得到列配置信息
        //List<Column> columns = new ArrayList<>();
        Integer num = 0;
        String str = "columns[" + num + "]";
        while (request.getParameter(str + "[searchable]") != null) {
            //Column column = new Column();

            dataTablesRequest.getColMap().put(num, request.getParameter(str + "[data]"));

            //column.setData(request.getParameter(str + "[data]"));
            //column.setName(request.getParameter(str + "[name]"));
            //column.setOrderable(request.getParameter(str + "[orderable]") == null ? false : Boolean.valueOf((String) request.getParameter(str + "[orderable]")));
            //
            //column.setSearchable(request.getParameter(str + "[searchable]".toString()) == null ? false : Boolean.valueOf((String) request.getParameter(str + "[searchable]")));

            //Search search2 = new Search();
            //search2.setValue((String) request.getParameter(str + "[search][value]"));
            //search2.setRegex(request.getParameter(str + "[search][regex]") == null ? false : Boolean.valueOf((String) request.getParameter(str + "[search][regex]")));
            //column.setSearch(search2);
            //columns.add(column);

            num++;
            str = "columns[" + num + "]";
        }

        //dataTablesRequest.setColumns(columns);

        // 生成排序字符串
        String orderString = "";
        Map<Integer, String> colMap = dataTablesRequest.getColMap();
        // 解析排序信息
        List<Order> orders = dataTablesRequest.getOrder();
        if (orders.size() > 0) {
            for (Order o : orders) {
                // 按那一列排序,由列编号转换为 排序名
                String colName = colMap.get(o.getColumn());
                colName = Underline2Camel.camel2Underline(colName);
                // 列名为空不操作
                if (colName != null && !"".equals(colName)) {
                    // 排序方式
                    if ("DESC".equalsIgnoreCase(o.getDir())) {
                        orderString += colName + " DESC,";
                    } else if ("ASC".equalsIgnoreCase(o.getDir())) {
                        orderString += colName + " ASC,";
                    }
                }
            }
            if (StringUtils.isNotBlank(orderString)) {
                orderString = orderString.substring(0, orderString.length() - 1);
            }
        }
        dataTablesRequest.setOrderString(orderString);

        return dataTablesRequest;
    }

    private static Map<String, String> getExtraSearchParam(Map<String, String[]> parameterMap) {
        Map<String, String> extraSearch = new HashMap<String, String>();

        for (String keyStr : parameterMap.keySet()) {
            if (keyStr != null && keyStr != "" && keyStr.startsWith("extra-search")) {
                String key = keyStr.substring(13, keyStr.length());
                String value = getFirstStr(parameterMap.get(keyStr));
                extraSearch.put(key, value);
            }
        }

        return extraSearch;
    }

    private static String getFirstStr(String[] strings) {
        String result = "";
        if (strings != null && strings.length > 0) {
            result = strings[0] == null ? "" : strings[0];
        }
        return result;
    }
}
