package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.ExpressInfoToCityTransfer;
import com.yaofei.springmvcmybatis.repository.ExpressInfoToCityTransferRepository;
import com.yaofei.springmvcmybatis.service.ExpressInfoToCityTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("expressInfoToCityTransferService")
public class ExpressInfoToCityTransferServiceImpl extends AbstractBaseService<ExpressInfoToCityTransfer> implements ExpressInfoToCityTransferService {
	@Autowired
	private ExpressInfoToCityTransferRepository expressInfoToCityTransferRepository;

	@Override
	public void insertExpress(ExpressInfoToCityTransfer expressInfoToCityTransfer) {
		expressInfoToCityTransferRepository.insertExpress(expressInfoToCityTransfer);
	}
}
