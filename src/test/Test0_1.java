package test;

import java.util.Scanner;

public class Test0_1{
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws Exception{
		
		int sum = 0;
		int i;
		for(i = 1; sum + i < 10000; i++)
			sum += i;
		
		System.out.println(sum + " " + i);
		
	}
}
