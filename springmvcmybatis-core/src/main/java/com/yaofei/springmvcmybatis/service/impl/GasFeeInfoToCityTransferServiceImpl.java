package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.GasFeeInfoToCityTransfer;
import com.yaofei.springmvcmybatis.repository.GasFeeInfoToCityTransferRepository;
import com.yaofei.springmvcmybatis.service.GasFeeInfoToCityTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("gasFeeInfoToCityTransferService")
public class GasFeeInfoToCityTransferServiceImpl extends AbstractBaseService<GasFeeInfoToCityTransfer> implements GasFeeInfoToCityTransferService {
	@Autowired
	private GasFeeInfoToCityTransferRepository gasFeeInfoToCityTransferRepository;

	@Override
	public void insertGasFee(GasFeeInfoToCityTransfer gasFeeInfoToCityTransfer) {
		gasFeeInfoToCityTransferRepository.insertGasFee(gasFeeInfoToCityTransfer);
	}
}
