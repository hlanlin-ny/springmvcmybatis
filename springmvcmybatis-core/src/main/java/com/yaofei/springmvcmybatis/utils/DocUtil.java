package com.yaofei.springmvcmybatis.utils;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.Map;

/**
 * Created by phoenix on 2017/9/18.
 */
public class DocUtil {
    public Configuration configure = null;

    public DocUtil() {
        configure = new Configuration(Configuration.VERSION_2_3_22);
        configure.setDefaultEncoding("utf-8");
    }

    /**
     * 根据Doc模板生成word文件
     *
     * @param dataMap      需要填入模板的数据
     * @param downloadType 文件名称
     * @param savePath     保存路径
     */
    public void createDoc(Map<String, Object> dataMap, String downloadType, String savePath) throws IOException, TemplateException {
        //加载需要装填的模板
        Template template = null;
        //设置模板装置方法和路径，FreeMarker支持多种模板装载方法。可以从servlet，classpath,数据库装载。
        //加载模板文件，放在testDoc下
        configure.setClassForTemplateLoading(this.getClass(), "/filetemplate");
        //设置对象包装器
//            configure.setObjectWrapper(new DefaultObjectWrapper());
        //设置异常处理器
        configure.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        //定义Template对象，注意模板类型名字与downloadType要一致
        template = configure.getTemplate(downloadType + ".xml");
        File outFile = new File(savePath);
        try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"))) {
            template.process(dataMap, out);
        }
    }

    public String getImageStr(String imgFile) {
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
}
