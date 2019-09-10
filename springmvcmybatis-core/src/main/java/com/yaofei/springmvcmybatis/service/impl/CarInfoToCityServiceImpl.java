package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.CarInfoTransfer;
import com.yaofei.springmvcmybatis.repository.CarInfoToCityRepository;
import com.yaofei.springmvcmybatis.service.CarInfoToCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("carInfoToCityService")
public class CarInfoToCityServiceImpl extends AbstractBaseService<CarInfoTransfer> implements CarInfoToCityService {
	@Autowired
	private CarInfoToCityRepository carInfoToCityRepository;


	@Override
	public void insert(CarInfoTransfer carInfoTransfer) {
		carInfoToCityRepository.insert(carInfoTransfer);
	}

	@Override
	public void insertRMYY(CarInfoTransfer carInfoTransfer) {
		carInfoToCityRepository.insertRMYY(carInfoTransfer);
	}
}
