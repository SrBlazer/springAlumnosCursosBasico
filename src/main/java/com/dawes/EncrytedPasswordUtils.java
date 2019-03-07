package com.dawes;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {
	
	public static String encrytePassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
	
	public static void main(String[] args) {
		String password = "temporal";
		String encrytedPassword = encrytePassword(password);
		
		System.out.println("Encryted password: " + encrytedPassword);
	}

}
