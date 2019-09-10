package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.BaseEntity;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.repository.BaseRepository;
import com.yaofei.springmvcmybatis.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 泛型依赖注入 Spring 4.x 中可以为子类注入子类对应的泛型类型的成员变量的引用 Created by f_yao on 2017/2/9.
 */
public class AbstractBaseService<T extends BaseEntity> implements
		BaseService<T> {

	@Autowired
	protected BaseRepository<T> baseRepository;

	/**
	 * 实体类型
	 */
	protected Class<T> entityClass;

	protected AbstractBaseService() {

		this.entityClass = null;
		Class<?> c = this.getClass();// 获取实际运行的类的 Class
		Type type = c.getGenericSuperclass(); // 获取实际运行的类的直接超类的泛型类型
		if (type instanceof ParameterizedType) { // 如果该泛型类型是参数化类型
			Type[] parameterizedType = ((ParameterizedType) type)
					.getActualTypeArguments();
			this.entityClass = (Class<T>) parameterizedType[0];
			System.out.println("AbstractBaseService的泛型的真实实现类是："
					+ this.entityClass.getName());
		}
	}

	@Override
	public void save(T t) {
		saveBefore(t);
		int n = baseRepository.save(t);
		saveAfter(t);
	}

	@Override
	public int update(T t) {
		updateBefore(t);
		int result = baseRepository.update(t);
		updateAfter(t);
		return result;
	}

	@Override
	public int delete(Object id) throws IOException {
		deleteBefore(id);
		int result = baseRepository.delete(id);
		deleteAfter(id);
		return result;
	}

	@Override
	public int deleteBatch(Object[] ids) throws IOException {
		deleteBatchBefore(ids);
		int result = baseRepository.deleteBatch(ids);
		deleteBatchAfter(ids);
		return result;
	}

	@Override
	public T queryObject(Object id) {
		queryObjectBefore(id);
		T result = baseRepository.queryObject(id);
		queryObjectAfter(id, result);
		return result;
	}

	@Override
	public List<T> queryList(DataTablesRequest dataTablesRequest) {
		queryListBefore(dataTablesRequest);
		System.out.print(dataTablesRequest.getExtraSearch().get("beginTime")+"接受时间"+dataTablesRequest.getExtraSearch().get("endTime"));
		List<T> result = baseRepository.queryList(dataTablesRequest);
		queryListAfter(dataTablesRequest, result);
		return result;
	}

	@Override
	public List<T> queryAll() {
		queryAllBefore();
		DataTablesRequest dataTablesRequest = new DataTablesRequest();
		dataTablesRequest.setLength(10000);
		List<T> result = baseRepository.queryList(dataTablesRequest);
		queryAllAfter(result);
		return result;
	}

	@Override
	public long queryTotal() {
		queryTotalBefore();
		long result = baseRepository.queryTotal();
		queryTotalAfter();
		return result;
	}

	@Override
	public long queryTotal(DataTablesRequest dataTablesRequest) {
		queryTotalBefore(dataTablesRequest);
		long result = baseRepository.queryListTotal(dataTablesRequest);
		queryTotalAfter(dataTablesRequest);
		return result;
	}

	// 扩展方法

	protected void saveBefore(T t)  {
	}

	protected void saveAfter(T t) {
	}

	protected void updateBefore(T t) {
	}

	protected void updateAfter(T t) {
	}

	protected void deleteBefore(Object id) throws IOException {
	}

	protected void deleteAfter(Object id) {
	}

	protected void deleteBatchBefore(Object[] ids) throws IOException {
	}

	protected void deleteBatchAfter(Object[] ids) {
	}

	protected void queryObjectBefore(Object id) {
	}

	protected void queryObjectAfter(Object id, T result) {
	}

	protected void queryListBefore(DataTablesRequest dataTablesRequest) {
	}

	protected void queryListAfter(DataTablesRequest dataTablesRequest,
			List<T> result) {
	}

	protected void queryAllBefore() {
	}

	protected void queryAllAfter(List<T> result) {
	}

	protected void queryTotalBefore() {
	}

	protected void queryTotalAfter() {
	}

	protected void queryTotalBefore(DataTablesRequest dataTablesRequest) {
	}

	protected void queryTotalAfter(DataTablesRequest dataTablesRequest) {
	}

}