package com.yaofei.springmvcmybatis.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yaofei.springmvcmybatis.component.es.ESClient;
import com.yaofei.springmvcmybatis.dto.es.index.BaseIndex;
import com.yaofei.springmvcmybatis.service.BaseEsClientService;
import com.yaofei.springmvcmybatis.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 泛型依赖注入 Spring 4.x 中可以为子类注入子类对应的泛型类型的成员变量的引用 Created by f_yao on 2017/2/9.
 */
public abstract class AbstractBaseEsClientService<T extends BaseIndex> implements
        BaseEsClientService<T> {

    @Autowired
    protected ESClient esClient;

    /**
     * 实体类型
     */
    protected Class<T> entityClass;

    ////既是类名也是es的type名
    //private String entityClassName;

    private String typeName;

    protected AbstractBaseEsClientService() {

        this.entityClass = null;
        Class<?> c = this.getClass();// 获取实际运行的类的 Class
        Type type = c.getGenericSuperclass(); // 获取实际运行的类的直接超类的泛型类型
        if (type instanceof ParameterizedType) { // 如果该泛型类型是参数化类型
            Type[] parameterizedType = ((ParameterizedType) type)
                    .getActualTypeArguments();
            this.entityClass = (Class<T>) parameterizedType[0];
            String entityClassName = this.entityClass.getName();
            typeName = entityClassName.substring(entityClassName.lastIndexOf(".") + 1).toLowerCase();
            System.out.println("AbstractBaseEsClientService的泛型的真实实现类是："
                    + this.entityClass.getName());
        }
    }

    @Override
    public String createIndex(List<T> entitys) throws IOException {
        String indexName = typeName + "_index_" + DateTimeUtil.format(new Date(), "yyyy-MM");
        //判断是否存在
        if (!esClient.isIndexExist(indexName)) {
            //创建索引
            esClient.createIndex(indexName, null, null);
            //创建类型schema
            createIndexType(indexName, typeName);
        }

        addIndexDocument(indexName, typeName, entitys);
        return indexName;
    }

    protected abstract boolean createIndexType(String indexName, String typeName) throws IOException;

    private void addIndexDocument(String indexName, String typeName, List<T> entitys) {
        List<JSONObject> jsonObjects = new ArrayList<>();
        for (T t : entitys) {
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(t);
            jsonObjects.add(jsonObject);
        }
        esClient.addDocument(indexName, typeName, jsonObjects);
    }


    @Override
    public String updateIndex(String esIndexName, List<T> entitys) throws IOException {
        for (T t : entitys) {
            deleteIndex(esIndexName, t.getId().toString());
        }
        String indexName =  createIndex(entitys);
        return indexName;
    }

    @Override
    public void deleteIndex(String indexName, String id) throws IOException {
        //判断是否存在
        if (esClient.isIndexExist(indexName)) {
            //删除索引数据
            esClient.deleteIndexTypeDataById(indexName, typeName, id);
        }
    }
}