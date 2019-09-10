package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.VipInfoToCityTransfer;
import com.yaofei.springmvcmybatis.repository.VipInfoToCityTransferRepository;
import com.yaofei.springmvcmybatis.service.VipInfoToCityTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("vipInfoToCityTransferService")
public class VipInfoToCityTransferServiceImpl extends AbstractBaseService<VipInfoToCityTransfer> implements VipInfoToCityTransferService {
	@Autowired
	private VipInfoToCityTransferRepository vipInfoToCityTransferRepository;

	@Override
	public void insertVip(VipInfoToCityTransfer vipInfoToCityTransfer) {
		vipInfoToCityTransferRepository.insertVip(vipInfoToCityTransfer);
	}
}
