package com.happytail.member.util;

import java.util.UUID;

public class MailCodeUtil {
	
	public static String startCode() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public static String forgetPwdCode() {
		int n = 0;
		while(n<1000) {
			n = (int)Math.floor((Math.random()*10000));		
		}
		String m = String.valueOf(n);
		System.out.println(m);
		return m;
	}
	
}
