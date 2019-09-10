package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.ExpressRecord;
import com.yaofei.springmvcmybatis.repository.ExpressRecordRepository;
import com.yaofei.springmvcmybatis.service.ExpressRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("expressRecordService")
public class ExpressRecordServiceImpl extends AbstractBaseService<ExpressRecord> implements ExpressRecordService {
	@Autowired
	private ExpressRecordRepository expressRecordRepository;

}
