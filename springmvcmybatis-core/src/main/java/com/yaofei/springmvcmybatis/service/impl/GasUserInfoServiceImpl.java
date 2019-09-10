package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.GasUserInfo;
import com.yaofei.springmvcmybatis.service.GasUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("gasUserInfoService")
public class GasUserInfoServiceImpl extends AbstractBaseService<GasUserInfo> implements GasUserInfoService {
	@Autowired
	private com.yaofei.springmvcmybatis.repository.GasUserInfoRepository GasUserInfoRepository;


}
