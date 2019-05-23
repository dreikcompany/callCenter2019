package com.almundo.callCenter2019.models;

import java.util.Random;

public class Call {
	private static final int minimumDuration = 5;
	private static final int maximumDuration = 10;
	
	private String responseNumber;
	private int callDuration;

	public Call() {
		this.responseNumber = generateResponseNumber();
		this.callDuration = generateCallDuration();
	}
	
	private String generateResponseNumber() {
		int num1, num2, num3; 
        int set2, set3;
        
        Random generator = new Random();
        StringBuilder number = new StringBuilder();
        
        num1 = 3;
        num2 = generator.nextInt(8);
        num3 = generator.nextInt(8);
        set2 = generator.nextInt(643) + 100;
        set3 = generator.nextInt(8999) + 1000;
        number.append("(")
        	.append(num1)
        	.append(num2)
        	.append(num3)
        	.append(") ")
        	.append(set2)
        	.append("-")
        	.append(set3);
        
		return number.toString();
	}
	
	private int generateCallDuration() {
		Random random = new Random();
		int range = maximumDuration - minimumDuration + 1;
		int callDuration =  random.nextInt(range) + minimumDuration;
		return callDuration;
	}

	public String getResponseNumber() {
		return responseNumber;
	}

	public int getCallDuration() {
		return callDuration;
	}

}
