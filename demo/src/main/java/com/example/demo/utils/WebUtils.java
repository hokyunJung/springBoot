package com.example.demo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class WebUtils {
	public static String sha256(String msg) throws NoSuchAlgorithmException {
	    MessageDigest md = MessageDigest.getInstance("SHA-256");
	    md.update(msg.getBytes());
	    
	    return bytesToHex2(md.digest());
	}
	
	public static String bytesToHex2(byte[] bytes) {
		final char[] hexArray = "0123456789abcdef".toCharArray();
		
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}


}
