package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.EcoGpsInfoToCityTransfer;
import com.yaofei.springmvcmybatis.repository.EcoGpsInfoToCityTransferRepository;
import com.yaofei.springmvcmybatis.service.EcoGpsInfoToCityTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ecoGpsInfoToCityTransferService")
public class EcoGpsInfoToCityTransferServiceImpl extends AbstractBaseService<EcoGpsInfoToCityTransfer> implements EcoGpsInfoToCityTransferService {
	@Autowired
	private EcoGpsInfoToCityTransferRepository ecoGpsInfoToCityTransferRepository;

	@Override
	public void insertEcoGps(EcoGpsInfoToCityTransfer ecoGpsInfoToCityTransfer) {
		ecoGpsInfoToCityTransferRepository.insertEcoGps(ecoGpsInfoToCityTransfer);
	}
}
