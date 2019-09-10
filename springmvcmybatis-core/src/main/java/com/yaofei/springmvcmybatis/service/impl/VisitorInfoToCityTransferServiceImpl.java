package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.VisitorInfoToCityTransfer;
import com.yaofei.springmvcmybatis.repository.VisitorInfoToCityTransferRepository;
import com.yaofei.springmvcmybatis.service.VisitorInfoToCityTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("visitorInfoToCityTransferService")
public class VisitorInfoToCityTransferServiceImpl extends AbstractBaseService<VisitorInfoToCityTransfer> implements VisitorInfoToCityTransferService {
	@Autowired
	private VisitorInfoToCityTransferRepository visitorInfoToCityTransferRepository;
    @Override
	public void insertVisitor(VisitorInfoToCityTransfer visitorInfoToCityTransfer) {
		visitorInfoToCityTransferRepository.insertVisitor(visitorInfoToCityTransfer);
	}
}
