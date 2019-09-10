package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.EconomicalInfoToCityTransfer;
import com.yaofei.springmvcmybatis.repository.EconomicalInfoToCityTransferRepository;
import com.yaofei.springmvcmybatis.service.EconomicalInfoToCityTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("economicalInfoToCityTransferService")
public class EconomicalInfoToCityTransferServiceImpl extends AbstractBaseService<EconomicalInfoToCityTransfer> implements EconomicalInfoToCityTransferService {
	@Autowired
	private EconomicalInfoToCityTransferRepository economicalInfoToCityTransferRepository;

	@Override
	public void insertEconomical(EconomicalInfoToCityTransfer economicalInfoToCityTransfer) {
		economicalInfoToCityTransferRepository.insertEconomical(economicalInfoToCityTransfer);
	}

	@Override
	public long selectMaxID() {
		return economicalInfoToCityTransferRepository.selectMaxID();
	}
}
