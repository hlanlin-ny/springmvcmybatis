package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.HospitalUser;
import com.yaofei.springmvcmybatis.exception.BussinessException;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.repository.HospitalUserRepository;
import com.yaofei.springmvcmybatis.service.HospitalUserService;
import com.yaofei.springmvcmybatis.utils.SignatureUtil;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("hospitalUserService")
public class HospitalUserServiceImpl extends AbstractBaseService<HospitalUser> implements HospitalUserService {
	@Autowired
	private HospitalUserRepository hospitalUserRepository;

	@Override
	protected void saveBefore(HospitalUser hospitalUser) {
		super.saveBefore(hospitalUser);

		// 检查用户名是否存在
		checkIsUsernameHasExist(hospitalUser.getUsername(), hospitalUser.getId());
		//生成密码
		generatePassword(hospitalUser);

		hospitalUser.setSeckey(genSecKey());
	}

	@Override
	protected void updateBefore(HospitalUser hospitalUser) {
		super.updateBefore(hospitalUser);

		// 检查用户名是否存在
		checkIsUsernameHasExist(hospitalUser.getUsername(), hospitalUser.getId());

		HospitalUser hospitalUser1 = hospitalUserRepository.queryObject(hospitalUser.getId());

		if(hospitalUser.getPassword().equals(hospitalUser1.getPassword())){
			  return;
		}
		//生成密码
		generatePassword(hospitalUser);

	}



	private void generatePassword(HospitalUser hospitalUser) {
		SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();
		String passwordSalt = secureRandomNumberGenerator.nextBytes().toHex();
		String passwordSha256 = new Sha256Hash(hospitalUser.getPassword(), passwordSalt, 2).toString();
		hospitalUser.setPassword(passwordSha256);
		hospitalUser.setPasswordSalt(passwordSalt);
	}

	/**
	 * 检查用户名是否存在
	 *
	 * @param username
	 * @param userId
	 */
	private void checkIsUsernameHasExist(String username, Long userId) {
		long count = hospitalUserRepository.queryTotalByUserNameAndId(username, userId);
		if (count > 0) {
			throw new BussinessException("用户名已经存在，请使用其他用户名！");
		}
	}

	@Override
	public List<HospitalUser> queryHospitalUsersByAreaId(Long areaId) {
		DataTablesRequest dataTablesRequest = new DataTablesRequest();
		Map<String, String> extraSearch = new HashMap<>();
		if (areaId != null) {
			extraSearch.put("areaId", areaId.toString());
		}
		dataTablesRequest.setExtraSearch(extraSearch);
		dataTablesRequest.setLength(10000);
		dataTablesRequest.setOrderString("id asc");
		return hospitalUserRepository.queryList(dataTablesRequest);
	}

	@Override
	public HospitalUser queryHospitalUsersByUserName(String username) {
		DataTablesRequest dataTablesRequest = new DataTablesRequest();
		Map<String, String> extraSearch = new HashMap<>();
		if (username != null) {
			extraSearch.put("username", username);
		}
		dataTablesRequest.setExtraSearch(extraSearch);
		dataTablesRequest.setLength(1);
		dataTablesRequest.setOrderString("id asc");
		List<HospitalUser> hospitalUser = hospitalUserRepository.queryList(dataTablesRequest);
		if(hospitalUser!=null && hospitalUser.size()>0){
			return hospitalUser.get(0);
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
