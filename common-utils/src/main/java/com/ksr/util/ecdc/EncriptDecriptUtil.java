package com.ksr.util.ecdc;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.ksr.util.logger.KSRLogger;

@Component("encriptDecriptUtil")
public class EncriptDecriptUtil {
	
	private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";  
    private static final byte[] INITIAL_IV = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};  
    private Class<EncriptDecriptUtil> classObj=EncriptDecriptUtil.class;
    private static String stringKey="86ILWOrtmYDUNxCxJTGE7Q==";
    
    static{  
    	try{    		
	    	/*KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM);
	        generator.init(128);	
	        Key key = generator.generateKey();
	        byte[] ecodedKey=Base64.encode(key.getEncoded());
	        stringKey=new String(ecodedKey);*/
	        System.out.println(stringKey);
    	}catch(Exception exception){
    		exception.printStackTrace();
    	}
    }   
    
    public static EncriptDecriptUtil getInstance(){
    	return new EncriptDecriptUtil();
    }   
    
	public String encript(String data){		
		if(!StringUtils.isEmpty(data)){
			Cipher cipher=getCipherInstance(Cipher.ENCRYPT_MODE);
			return doEncript(cipher, data);
		}else{
			return null;
		}
	}	
	public String decript(String data){
		if(!StringUtils.isEmpty(data)){
			Cipher cipher=getCipherInstance(Cipher.DECRYPT_MODE);
			return doDecript(cipher, data);
		}else{
			return null;
		}
	}	
	private Cipher getCipherInstance(int cipherMode){
		Cipher cipher=null;
		try{
			if(stringKey!=null){
				byte[] keyByte=Base64.decode(stringKey.getBytes("UTF-8"));
				Key key = new SecretKeySpec(keyByte, ALGORITHM);
				cipher = Cipher.getInstance(TRANSFORMATION);
				IvParameterSpec iv = new IvParameterSpec(INITIAL_IV);
				cipher.init(cipherMode, key,iv);
			}else{
				KSRLogger.warn(classObj, "Security Key not found");
			}
		} catch (Exception exception) {
           KSRLogger.error(classObj, exception);
        }
		return cipher;
	}
	private String doDecript(Cipher cipher,String data){
		String criptData=null;
		try{			
			byte[] encryptedTextBytes = Base64.decode(data.getBytes("UTF-8"));
            byte[] decryptedTextBytes = cipher.doFinal(encryptedTextBytes);
            criptData=new String(decryptedTextBytes);
		} catch (Exception exception) {
           KSRLogger.error(classObj, exception);
        }
		return criptData;
	}		
	private String doEncript(Cipher cipher,String data){
		String criptData=null;
		try{		
			byte[] encryptedTextBytes = cipher.doFinal(data.getBytes("UTF-8"));
			byte[] nomalTextBytes=Base64.encode(encryptedTextBytes);
			criptData= new String(nomalTextBytes);          
		} catch (Exception exception) {
           KSRLogger.error(classObj, exception);
        }
		return criptData;
	}
}
