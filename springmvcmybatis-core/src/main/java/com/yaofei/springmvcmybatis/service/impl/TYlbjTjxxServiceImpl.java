package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.TYlbjTjxx;
import com.yaofei.springmvcmybatis.repository.TYlbjTjxxRepository;
import com.yaofei.springmvcmybatis.service.TYlbjTjxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tYlbjTjxxService")
public class TYlbjTjxxServiceImpl extends AbstractBaseService<TYlbjTjxx> implements TYlbjTjxxService {
	@Autowired
	private TYlbjTjxxRepository tYlbjTjxxRepository;

	@Override
	public void insert(TYlbjTjxx tYlbjTjxx) {
		tYlbjTjxxRepository.insert(tYlbjTjxx);
	}

}
