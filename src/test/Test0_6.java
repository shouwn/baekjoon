package test;

import java.util.Arrays;

public class Test0_6 {
	
	public static void main(String[] args) {
		String[] test = {"1S2D*3T", "1D2S#10S", "1D2S0T", 
				"1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*"};
		
		for(String s : test) {
			System.out.println(dartResult(s));
		}
	}
	
	public static int dartResult(String dart) {
		int[] score = new int[4];
		
		int point = 0;
		dart = new StringBuilder(dart).append(" ").toString();
		
		for(int i = 0; i < dart.length() - 1; i++) {
			String s = dart.substring(i, i + 2);
			
			if(Character.isDigit(s.charAt(0))) {
				if(Character.isDigit(s.charAt(1))) {
					score[++point] = Integer.valueOf(s);
					i++;
				}
				else
					score[++point] = Integer.valueOf(s.substring(0, 1));
			}
			else {
				switch(s.substring(0, 1)) {
				
				case "D" :
					score[point] = (int)Math.pow(score[point], 2);
					break;
				case "T" :
					score[point] = (int)Math.pow(score[point], 3);
					break;
				case "*" :
					score[point] *= 2;
					score[point - 1] *= 2;
					break;
				case "#" :
					score[point] *= -1;
					break;
				}
			}
			
			//System.out.println(s + " " + " score[" + point + "]: " + score[point]);
		}
		
		return Arrays.stream(score).reduce((pre, cur) -> pre + cur).orElse(0);
	}
}


