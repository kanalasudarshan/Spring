package com.ksr.util.ecdc;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;

import com.ksr.util.logger.KSRLogger;

@Component("encriptDecriptUtil")
public class EncriptDecriptUtil {
	
	private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";    
    private Class<EncriptDecriptUtil> classObj=EncriptDecriptUtil.class;
    
	public String encript(String key,String data){
		return doCript(Cipher.ENCRYPT_MODE, key, data);
	}
	
	public String decript(String key,String data){
		return doCript(Cipher.DECRYPT_MODE, key, data);
	}
	
	private String doCript(int cipherMode,String key,String data){
		String criptData=null;
		try{
			Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
			Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			cipher.init(cipherMode, secretKey);
			byte[] encryptedTextBytes = cipher.doFinal(data.getBytes("UTF-8"));
			criptData= Base64.encode(encryptedTextBytes).toString();            
		} catch (Exception exception) {
           KSRLogger.error(classObj, exception);
        }
		return criptData;
	}
}
