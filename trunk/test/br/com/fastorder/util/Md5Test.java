package br.com.fastorder.util;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * br.gov.al.ser.noticias.util.Md5 test case.
 * 
 * @author Diogo Cabral de Almeida
 *
 */
public class Md5Test {
	
	/**
	 * A simple message.
	 */
	private String message = "123456";
	
	/**
	 * Md5 hash of 123456.
	 */
	private String messageHash = "e10adc3949ba59abbe56e057f20f883e";
	
	/**
	 * Md5 hash of File.createTempFile("md5", "ok").
	 */
	private String fileHash = "d41d8cd98f00b204e9800998ecf8427e";

	/**
	 * Test method for {@link br.gov.al.ser.noticias.util.Md5#crypt(java.lang.String)}.
	 */
	@Test
	public void cryptStringOk() {
		assertEquals(messageHash, Md5.crypt(message));
	}
	
	/**
	 * Test method for {@link br.gov.al.ser.noticias.util.Md5#crypt(java.lang.String)}.
	 */
	@Test
	public void cryptStringFail() {
		assertNotSame(messageHash, Md5.crypt(message + message));
	}	
	
	/**
	 * Test method for {@link br.gov.al.ser.noticias.util.Md5#crypt(java.io.File)}.
	 * @throws IOException 
	 */
	@Test
	public void cryptFileOk() throws IOException {
		assertEquals(fileHash, Md5.crypt(File.createTempFile("md5", "ok")));
	}
	
	/**
	 * Test method for {@link br.gov.al.ser.noticias.util.Md5#crypt(java.io.File)}.
	 * @throws IOException 
	 */
	@Test
	public void cryptFileFail() throws IOException {
		assertNotSame(fileHash, Md5.crypt(File.createTempFile("md5", "fail")));
	}	
	
	/**
	 * Test method for {@link br.gov.al.ser.noticias.util.Md5#crypt(byte[])}.
	 */
	@Test
	public void cryptByteArrayOk() {
		assertEquals(messageHash, Md5.crypt(message.getBytes()));
	}
	
	/**
	 * Test method for {@link br.gov.al.ser.noticias.util.Md5#crypt(byte[])}.
	 */
	@Test
	public void cryptByteArrayFail() {
		assertNotSame(messageHash, Md5.crypt((message + message).getBytes()));
	}	

}
