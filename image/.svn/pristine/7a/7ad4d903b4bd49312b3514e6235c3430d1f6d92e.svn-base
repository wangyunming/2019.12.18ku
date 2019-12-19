package com.haoyin.image.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author Summer
 *
 *         2016年3月9日
 */
public class PasswordHashed {

	private static final int DEFAULT_ITERATIONS = 0x2;

	private String credentialsSalt;

	public static PasswordHashed getInstance() {
		return new PasswordHashed();
	}

	public String encryptToHex(String plaintext) {
		return getSimpleHash(plaintext).toHex();
	}

	public String encryptToBase64(String plaintext) {
		return getSimpleHash(plaintext).toBase64();
	}

	public SimpleHash getSimpleHash(String plaintext) {
		String algorithm = Sha256Hash.ALGORITHM_NAME;

		credentialsSalt = new SecureRandomNumberGenerator().nextBytes().toHex();
		ByteSource byteSalt = ByteSource.Util.bytes(credentialsSalt);

		return new SimpleHash(algorithm, plaintext, byteSalt, DEFAULT_ITERATIONS);
	}

	/**
	 * @return the {@link #credentialsSalt}
	 */
	public String getCredentialsSalt() {
		return credentialsSalt;
	}

	/**
	 * @param credentialsSalt
	 *            the {@link #credentialsSalt} to set
	 */
	public void setCredentialsSalt(String credentialsSalt) {
		this.credentialsSalt = credentialsSalt;
	}
	/**
	 * md5
	 * @param password
	 * @return
	 */
	 public String md5Password(String password) {

	        try {
	            // 得到一个信息摘要器
	            MessageDigest digest = MessageDigest.getInstance("md5");
	            byte[] result = digest.digest(password.getBytes());
	            StringBuffer buffer = new StringBuffer();
	            // 把每一个byte 做一个与运算 0xff;
	            for (byte b : result) {
	                // 与运算
	                int number = b & 0xff;// 加盐
	                String str = Integer.toHexString(number);
	                if (str.length() == 1) {
	                    buffer.append("0");
	                }
	                buffer.append(str);
	            }

	            // 标准的md5加密后的结果
	            return buffer.toString();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	            return "";
	        }
			
	 }
	public static void main(String[] args) {
		PasswordHashed ph = PasswordHashed.getInstance();
		System.out.println(ph.encryptToHex("123456"));
		System.out.println(ph.getCredentialsSalt());
		System.out.println(new SimpleHash("SHA-256", "123456", "b6ca2672d801c6ba9cb6a9fbd9276910", DEFAULT_ITERATIONS));
	}

}
