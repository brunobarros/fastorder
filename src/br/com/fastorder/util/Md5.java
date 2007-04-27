package br.com.fastorder.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

/**
 * Classe que gera hashes utilizando o método MD5.
 * 
 * @author Diogo Cabral de Almeida
 *
 */
public class Md5 {
	
	private static final Logger logger = Logger.getLogger(Md5.class);
	
	private static final String METHOD = "MD5";
	
	private static final String HEX_DIGITS = "0123456789abcdef";
	
	/**
	 * Transforma o hash gerado pelo digester em um hash no formato de
	 * string composta por digitos exadecimais. 
	 * 
	 * @param bytes hash em formato de array de bytes.
	 * @return hash em formato de string.
	 */
	private static String byteArrayToHexDigits(byte[] bytes) {
  	    StringBuffer hash = new StringBuffer(32);
 	    for (int i = 0; i < 16; i++) {
 	    	int j = ((int) bytes[i]) & 0xFF;
 			hash.append(HEX_DIGITS.charAt(j / 16));
 			hash.append(HEX_DIGITS.charAt(j % 16));
 	    }
 	    
 	    return hash.toString();
	}
	
	/**
	 * Gera o hash de uma string utilizando o método MD5.
	 * 
	 * @param message string na qual o hash vai ser baseado.
	 * @return hash da string.
	 */
	public static String crypt(String message) {
    	return crypt(message.getBytes());
	}
	
	/**
	 * Gera o hash de um arquivo utilizando o método MD5.
	 * 
	 * @param file arquivo no qual o hash vai ser baseado.
	 * @return hash do arquivo.
	 * @throws IOException se o arquivo não existir.
	 */
	public static String crypt(File file) throws IOException {		
    	try {    		
    		InputStream in = new FileInputStream(file);
    		BufferedInputStream buffer = new BufferedInputStream(in);
    		
      		MessageDigest md = MessageDigest.getInstance(METHOD);
      		
     	    md.reset();
     	      	    
     	    int nBytes;
	   		byte[] buf = new byte[20240];			
	   		while ((nBytes = buffer.read(buf)) > 0) {
	   			md.update(buf, 0, nBytes);
	   		}
	   		
     	    return byteArrayToHexDigits(md.digest());
     	    
    	} catch (NoSuchAlgorithmException e) {
    		logger.fatal(e);
    	}
    	
    	return null;
	}
	
	/**
	 * Gera o hash de um array de bytes utilizando o método MD5.
	 * 
	 * @param bytes array de bytes no qual o hash vai ser baseado.
	 * @return hash do array.
	 */
	public static String crypt(byte[] bytes) {
    	try {
      		MessageDigest md = MessageDigest.getInstance(METHOD);
      		
     	    md.reset();
     	    
     	    return byteArrayToHexDigits(md.digest(bytes));
     	    
    	} catch (NoSuchAlgorithmException e) {
    		logger.fatal(e);
    	}
    	
        return null;
	}

}
