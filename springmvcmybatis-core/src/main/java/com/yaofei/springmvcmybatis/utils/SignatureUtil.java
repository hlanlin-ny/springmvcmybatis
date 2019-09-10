package com.yaofei.springmvcmybatis.utils;

import org.springframework.util.DigestUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class SignatureUtil {
	private static final String KEY_SHA = "SHA";
	private static final String KEY_MD5 = "MD5";
	private static final String MAC_NAME = "HmacSHA1";
	private static final String ENCODING = "UTF-8";

	public static byte[] decryptBASE64(String key) throws Exception {
		return (new BASE64Decoder()).decodeBuffer(key);
	}

	public static String encryptBASE64(byte[] key) throws Exception {
		return (new BASE64Encoder()).encode(key);
	}

	public static byte[] encryptMD5(byte[] data) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
		return md5.digest(data);
	}

	public static byte[] encryptSHA(byte[] data) throws Exception {
		MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
		sha.update(data);
		return sha.digest();
	}
	public static String encryptMD5(String str)throws Exception {
		MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
		return new String(md5.digest(str.getBytes()));
	}
	public static String md5(String plainText) {
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(plainText.getBytes("UTF8"));
			byte s[] = m.digest();
			String result = "";
			for (int i = 0; i < s.length; i++) {
				result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	/*
	 * 展示了一个生成指定算法密钥的过程 初始化HMAC密钥
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	public static SecretKey initMacKey() throws Exception {
		// 得到一个 指定算法密钥的密钥生成器
		KeyGenerator keyGenerator = KeyGenerator.getInstance(MAC_NAME);
		// 生成一个密钥
		return keyGenerator.generateKey();
	}

	/**
	 * 使用 HMAC-SHA1 签名方法对对encryptText进行签名
	 * 
	 * @param data
	 *            被签名的数据
	 * @param encryptKey
	 *            密钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] hmacSHA1Encrypt(byte[] data, String encryptKey) throws Exception {
		byte[] key = encryptKey.getBytes(ENCODING);
		// 根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
		SecretKey secretKey = new SecretKeySpec(key, MAC_NAME);
		// 生成一个指定 Mac 算法 的 Mac 对象
		Mac mac = Mac.getInstance(MAC_NAME);
		// 用给定密钥初始化 Mac 对象
		mac.init(secretKey);
		// 完成 Mac 操作
		return mac.doFinal(data);
	}
}
