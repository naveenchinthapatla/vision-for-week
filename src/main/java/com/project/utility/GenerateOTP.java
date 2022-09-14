package com.project.utility;

import java.util.Random;

public class GenerateOTP {
	public static String getOtp() {
		StringBuilder otp = new StringBuilder();
		Random random = new Random();
		for(int x=0;x<4;x++) {
			otp.append(random.nextInt(10));
		}
		return String.valueOf(otp);
	}
}
