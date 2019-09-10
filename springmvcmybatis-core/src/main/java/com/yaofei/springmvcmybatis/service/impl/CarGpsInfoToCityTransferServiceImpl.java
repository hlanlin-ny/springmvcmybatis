package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.CarGpsInfoToCityTransfer;
import com.yaofei.springmvcmybatis.repository.CarGpsInfoToCityTransferRepository;
import com.yaofei.springmvcmybatis.service.CarGpsInfoToCityTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("carGpsInfoToCityTransferService")
public class CarGpsInfoToCityTransferServiceImpl extends AbstractBaseService<CarGpsInfoToCityTransfer> implements CarGpsInfoToCityTransferService {
	@Autowired
	private CarGpsInfoToCityTransferRepository carGpsInfoToCityTransferRepository;

	@Override
	public void insertCarGps(CarGpsInfoToCityTransfer carGpsInfoToCityTransfer) {
		carGpsInfoToCityTransferRepository.insertCarGps(carGpsInfoToCityTransfer);
	}
}
