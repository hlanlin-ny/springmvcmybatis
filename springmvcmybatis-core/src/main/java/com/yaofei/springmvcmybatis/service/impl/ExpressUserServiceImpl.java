package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.ExpressUser;
import com.yaofei.springmvcmybatis.exception.BussinessException;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.repository.ExpressUserRepository;
import com.yaofei.springmvcmybatis.service.ExpressUserService;
import com.yaofei.springmvcmybatis.utils.SignatureUtil;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("expressUserService")
public class ExpressUserServiceImpl extends AbstractBaseService<ExpressUser> implements ExpressUserService {
    @Autowired
    private ExpressUserRepository expressUserRepository;

    @Override
    protected void saveBefore(ExpressUser expressUser) {
        super.saveBefore(expressUser);

        // 检查用户名是否存在
        checkIsUsernameHasExist(expressUser.getUsername(), expressUser.getId());
        //生成密码
        generatePassword(expressUser);

        expressUser.setSeckey(genSecKey());
    }

    @Override
    protected void updateBefore(ExpressUser expressUser) {
        super.updateBefore(expressUser);

        // 检查用户名是否存在
        checkIsUsernameHasExist(expressUser.getUsername(), expressUser.getId());
        //生成密码
        generatePassword(expressUser);

        //expressUser.setSeckey(genSecKey());
    }



    private void generatePassword(ExpressUser expressUser) {
        SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();
        String passwordSalt = secureRandomNumberGenerator.nextBytes().toHex();
        String passwordSha256 = new Sha256Hash(expressUser.getPassword(), passwordSalt, 2).toString();
        expressUser.setPassword(passwordSha256);
        expressUser.setPasswordSalt(passwordSalt);
    }

    /**
     * 检查用户名是否存在
     *
     * @param username
     * @param userId
     */
    private void checkIsUsernameHasExist(String username, Long userId) {
        long count = expressUserRepository.queryTotalByUserNameAndId(username, userId);
        if (count > 0) {
            throw new BussinessException("用户名已经存在，请使用其他用户名！");
        }
    }

    @Override
    public List<ExpressUser> queryExpressUsersByAreaId(Long areaId) {
        DataTablesRequest dataTablesRequest = new DataTablesRequest();
        Map<String, String> extraSearch = new HashMap<>();
        if (areaId != null) {
            extraSearch.put("areaId", areaId.toString());
        }
        dataTablesRequest.setExtraSearch(extraSearch);
        dataTablesRequest.setLength(10000);
        dataTablesRequest.setOrderString("id asc");
        return expressUserRepository.queryList(dataTablesRequest);
    }

    @Override
    public ExpressUser queryExpressUsersByUserName(String username) {
        DataTablesRequest dataTablesRequest = new DataTablesRequest();
        Map<String, String> extraSearch = new HashMap<>();
        if (username != null) {
            extraSearch.put("username", username);
        }
        dataTablesRequest.setExtraSearch(extraSearch);
        dataTablesRequest.setLength(1);
        dataTablesRequest.setOrderString("id asc");
        List<ExpressUser> expressUsers = expressUserRepository.queryList(dataTablesRequest);
        if(expressUsers!=null && expressUsers.size()>0){
            return expressUsers.get(0);
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
