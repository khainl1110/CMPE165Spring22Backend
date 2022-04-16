package com.example.backend;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Scanner;

public class PassWordHashing {

	public static String hash(String originalString){
		try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] btEncodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < btEncodedhash.length; i++) {
                sb.append(Integer.toString((btEncodedhash[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        }
        catch(Exception ex){
            System.out.println("Something went wrong, couldn't generate a hash value --> " + ex.getMessage());
            return null;
        }
	}
}
