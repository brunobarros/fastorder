package br.com.fastorder.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

/**
 * 
 * @author Diogo Cabral de Almeida
 *
 */
public class Md5 {
	
	private static final Logger logger = Logger.getLogger(Md5.class);
	
	private static final String METHOD = "MD5";
	
	private static final String HEX_DIGITS = "0123456789abcdef";	
	
	/**
	 * Criptografa uma string utilizando o método MD5 de criptografia.
	 * 
	 * @param message mensagem.
	 * @return mensagem criptografada.
	 */
	public static String crypt(String message) {
    	try {
      		MessageDigest md = MessageDigest.getInstance(METHOD);
      		
     	    md.reset();
     	    byte b[];
     	    StringBuffer sbuffer = new StringBuffer();
     	    
      	    b = md.digest(message.getBytes());

     	    for (int i = 0; i < 16; i++) {
     	    	int j = ((int) b[i]) & 0xFF;
     			sbuffer.append(HEX_DIGITS.charAt(j / 16));
     			sbuffer.append(HEX_DIGITS.charAt(j % 16));
     	    }

     	    return sbuffer.toString();
     	    
    	} catch (NoSuchAlgorithmException e) {
    		logger.fatal(e);
    	}
    	
        return null;
	}

}
