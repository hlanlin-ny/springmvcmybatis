package com.yaofei.springmvcmybatis.utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.*;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtils {
    /**
     * 发送HTTP_POST请求
     *
     * @param reqURL        请求地址
     * @param params        请求参数
     * @param encodeCharset 编码字符集,编码请求数据时用之,其为null时默认采用UTF-8解码
     * @param decodeCharset 解码字符集,解析响应数据时用之,其为null时默认采用UTF-8解码
     * @return 远程主机响应正文
     * @see 该方法会自动关闭连接,释放资源
     * @see 该方法会自动对<code>params</code>中的[中文][|][ ]等特殊字符进行 <code>URLEncoder.encode(string,encodeCharset)</code>
     */
    public static String sendPostRequest(String reqURL, Map<String, String> params, String encodeCharset,
                                         String decodeCharset) throws IOException {
        String responseContent = null;
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(reqURL);

        List<NameValuePair> formParams = new ArrayList<NameValuePair>(); // 创建参数队列
        for (Map.Entry<String, String> entry : params.entrySet()) {
            formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }

        //设置参数到请求对象中
        httpPost.setEntity(new UrlEncodedFormEntity(formParams, encodeCharset == null ? "UTF-8" : encodeCharset));

        //设置header信息
        //指定报文头【Content-type】、【User-Agent】
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        if (null != entity) {
            responseContent = EntityUtils.toString(entity, decodeCharset == null ? "UTF-8" : decodeCharset);
        }
        EntityUtils.consume(entity);
        //释放链接
        response.close();
        return responseContent;
    }


    public static String sendPostRequestNoUrlEncoded(String reqURL, Map<String, String> params, String encodeCharset,
                                                     String decodeCharset) throws IOException {
        String responseContent = null;
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(reqURL);

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {

            //String encodedName = encodeFormFields(entry.getKey(), Charset.forName("UTF-8"));
            //String encodedValue = encodeFormFields(entry.getValue(), Charset.forName("UTF-8"));

            String encodedName = entry.getKey();
            String encodedValue = entry.getValue();

            if (result.length() > 0) {
                result.append('&');
            }

            result.append(encodedName);
            if (encodedValue != null) {
                result.append("=");
                result.append(encodedValue);
            }
        }

        //设置参数到请求对象中
        httpPost.setEntity(new StringEntity(result.toString()));

        //设置header信息
        //指定报文头【Content-type】、【User-Agent】
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        if (null != entity)

        {
            responseContent = EntityUtils.toString(entity, decodeCharset == null ? "UTF-8" : decodeCharset);
        }

        EntityUtils.consume(entity);
        //释放链接
        response.close();
        return responseContent;
    }

    private static final BitSet URLENCODER = new BitSet(256);

    private static String encodeFormFields(String content, Charset charset) {
        return content == null ? null : urlEncode(content, charset != null ? charset : Consts.UTF_8, URLENCODER, true);
    }

    private static String urlEncode(String content, Charset charset, BitSet safechars, boolean blankAsPlus) {
        if (content == null) {
            return null;
        } else {
            StringBuilder buf = new StringBuilder();
            ByteBuffer bb = charset.encode(content);

            while (true) {
                while (bb.hasRemaining()) {
                    int b = bb.get() & 255;
                    if (safechars.get(b)) {
                        buf.append((char) b);
                    } else if (blankAsPlus && b == 32) {
                        buf.append('+');
                    } else {
                        buf.append("%");
                        char hex1 = Character.toUpperCase(Character.forDigit(b >> 4 & 15, 16));
                        char hex2 = Character.toUpperCase(Character.forDigit(b & 15, 16));
                        buf.append(hex1);
                        buf.append(hex2);
                    }
                }

                return buf.toString();
            }
        }
    }


    public static void main(String[] args) throws Exception {
        Map<String, String> sendData = new HashMap<String, String>();
        String imgA = "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";
        String imgB = imgA;
        sendData.put("app_id", "app_id");
        sendData.put("app_secret", "app_id");
        sendData.put("imgA", imgA);
        sendData.put("imgB", imgB);
        String jsonString = sendPostRequest("http://127.0.0.1:7000/face/tool/compare", sendData, null, null);
        System.out.println(jsonString);
    }
}
