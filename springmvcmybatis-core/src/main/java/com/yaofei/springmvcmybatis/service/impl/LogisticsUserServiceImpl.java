package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.LogisticsUser;
import com.yaofei.springmvcmybatis.exception.BussinessException;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.repository.LogisticsUserRepository;
import com.yaofei.springmvcmybatis.service.LogisticsUserService;
import com.yaofei.springmvcmybatis.utils.SignatureUtil;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("logisticsUserService")
public class LogisticsUserServiceImpl extends AbstractBaseService<LogisticsUser> implements LogisticsUserService {
    @Autowired
    private LogisticsUserRepository logisticsUserRepository;

    @Override
    protected void saveBefore(LogisticsUser logisticsUser){
        super.saveBefore(logisticsUser);

        // 检查用户名是否存在
        checkIsUsernameHasExist(logisticsUser.getUsername(), logisticsUser.getId());
        //生成密码
        generatePassword(logisticsUser);

        logisticsUser.setSeckey(genSecKey());
    }

    @Override
    protected void updateBefore(LogisticsUser logisticsUser) {
        super.updateBefore(logisticsUser);

        // 检查用户名是否存在
        checkIsUsernameHasExist(logisticsUser.getUsername(), logisticsUser.getId());
        //生成密码
        generatePassword(logisticsUser);

        //logisticsUser.setSeckey(genSecKey());
    }



    private void generatePassword(LogisticsUser logisticsUser) {
        SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();
        String passwordSalt = secureRandomNumberGenerator.nextBytes().toHex();
        String passwordSha256 = new Sha256Hash(logisticsUser.getPassword(), passwordSalt, 2).toString();
        logisticsUser.setPassword(passwordSha256);
        logisticsUser.setPasswordSalt(passwordSalt);
    }

    /**
     * 检查用户名是否存在
     *
     * @param username
     * @param userId
     */
    private void checkIsUsernameHasExist(String username, Long userId) {
        long count = logisticsUserRepository.queryTotalByUserNameAndId(username, userId);
        if (count > 0) {
            throw new BussinessException("用户名已经存在，请使用其他用户名！");
        }
    }

    @Override
    public List<LogisticsUser> queryLogisticsUsersByAreaId(Long areaId) {
        DataTablesRequest dataTablesRequest = new DataTablesRequest();
        Map<String, String> extraSearch = new HashMap<>();
        if (areaId != null) {
            extraSearch.put("areaId", areaId.toString());
        }
        dataTablesRequest.setExtraSearch(extraSearch);
        dataTablesRequest.setLength(10000);
        dataTablesRequest.setOrderString("id asc");
        return logisticsUserRepository.queryList(dataTablesRequest);
    }

    @Override
    public LogisticsUser queryLogisticsUsersByUserName(String username) {
        DataTablesRequest dataTablesRequest = new DataTablesRequest();
        Map<String, String> extraSearch = new HashMap<>();
        if (username != null) {
            extraSearch.put("username", username);
        }
        dataTablesRequest.setExtraSearch(extraSearch);
        dataTablesRequest.setLength(1);
        dataTablesRequest.setOrderString("id asc");
        List<LogisticsUser> logisticsUsers = logisticsUserRepository.queryList(dataTablesRequest);
        if(logisticsUsers!=null && logisticsUsers.size()>0){
            return logisticsUsers.get(0);
        }else {
            return null;
        }
    }

    private String genSecKey() {
        String encryptKey = "0c1232ee-ad05-4c1a-82ee-9ec83ce8cc25";

        String uuid = UUID.randomUUID().toString();
        try {
            uuid = SignatureUtil.encryptBASE64(SignatureUtil.hmacSHA1Encrypt(uuid.getBytes(), encryptKey));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uuid;
    }
}
