package com.onion.util;


import java.security.MessageDigest;
import java.util.Random;

public class AuthUtil {

	private static final int[] NUMBER = {0,1,2,3,4,5,6,7,8,9};

	private static final Random RANDOM = new Random();

	private static String SALT = "zhangqi";

	public static String createCode(int count){

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < count; i++) {
			sb.append(NUMBER[RANDOM.nextInt(10)]);
		}

		return sb.toString();
	}

	public static String md5Salt(String value){
		return encodeToMd5(value + SALT);
	}

	private static String encodeToMd5(String source) {
		if(source==null)
			return null;

		try{
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");

			char hexDigits[] = {
					'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
					'e', 'f'};

			byte[] strTemp=source.getBytes("utf-8");
			mdTemp.update(strTemp);

			byte[] md = mdTemp.digest();
			int k = 0;
			int j = md.length;char str[] = new char[j * 2];

			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>>4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		System.out.println(createCode(6));
	}
}
