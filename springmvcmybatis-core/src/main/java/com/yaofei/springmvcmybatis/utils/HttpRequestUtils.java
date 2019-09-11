package com.yaofei.springmvcmybatis.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class HttpRequestUtils {

   // get请求
   // 实际的请求头设置还不完善，以后再补充
    public static JSON httpGet(Map<String, Object> params, String URL) throws IOException {
        HttpClient client = new HttpClient();
        GetMethod getMethod = new GetMethod(URL);
        int i = client.executeMethod(getMethod);
        JSON json = JSON.parseObject(new String(getMethod.getResponseBody(),"utf-8"));
        return json;
    }
    // post请求
    // 向第三方接口发送一个post 请求的参数的看具体的要求，该接口想要的数据是什么类型，如果是json，那就把参数转换为json类型，其他的转换为其它类型，如阿里的接口参数就有的不是json类型
    public static JSON httpPost(Map<String, Object> params, String URL) throws Exception {
        // json格式的参数，我们可以用map来封装参数，然后将参数转换为json格式
        String paramsJson = JSON.toJSONString(params); // 将参数转换为json字符串
        // 服务端通常是根据请求头（headers）中的 Content-Type 字段来获知请求中的消息主体是用何种方式编码，再对主体进行解析。所以说到 POST 提交数据方案，包含了 Content-Type 和消息主体编码方式两部分
        HttpClient client = new HttpClient(); // 客户端实例化
        PostMethod postMethod = new PostMethod(URL); // 请求方法post，可以将请求路径传入构造参数中
        postMethod.addRequestHeader("Content-type", "application/json; charset=utf-8");
        byte[] requestBytes = paramsJson.getBytes("utf-8"); // 将参数转为二进制流
        InputStream inputStream = new ByteArrayInputStream(requestBytes, 0,
                requestBytes.length);
        RequestEntity requestEntity = new InputStreamRequestEntity(inputStream,
                requestBytes.length, "application/json; charset=utf-8"); // 请求体
        postMethod.setRequestEntity(requestEntity);   // 将参数放入请求体
        int i = client.executeMethod(postMethod);  // 执行方法
        // 这里因该有判断的，根据请求状态判断请求是否成功，然后根据第三方接口返回的数据格式，解析出我们需要的数据
        byte[] responseBody = postMethod.getResponseBody(); // 得到相应数据
        JSON json = JSON.parseObject(new String(responseBody));
        return json;
    }
}