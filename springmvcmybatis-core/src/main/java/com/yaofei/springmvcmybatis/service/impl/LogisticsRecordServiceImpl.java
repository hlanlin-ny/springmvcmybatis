package com.yaofei.springmvcmybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.yaofei.springmvcmybatis.repository.LogisticsRecordRepository;
import com.yaofei.springmvcmybatis.entity.LogisticsRecord;
import com.yaofei.springmvcmybatis.service.LogisticsRecordService;

@Service("logisticsRecordService")
public class LogisticsRecordServiceImpl extends AbstractBaseService<LogisticsRecord> implements LogisticsRecordService {
	@Autowired
	private LogisticsRecordRepository logisticsRecordRepository;

}
