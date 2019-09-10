package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.SysWechat;
import com.yaofei.springmvcmybatis.repository.SysWechatRepository;
import com.yaofei.springmvcmybatis.service.SysWechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysWechatService")
public class SysWechatServiceImpl extends AbstractBaseService<SysWechat> implements SysWechatService {
	@Autowired
	private SysWechatRepository sysWechatRepository;

}
