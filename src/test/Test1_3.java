package test;

import java.util.Scanner;

public class Test1_3 {
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)){
			int input = scan.nextInt() - 1;

			StringBuilder sb = new StringBuilder(num2String(input % 3));

			int r = 3;

			while(input >= r) {

				input -= r;
				int rest = (input / r) % 3;
				r *= 3;

				sb.append(num2String(rest));
			}

			System.out.println(sb.reverse().toString());
		}
	}

	public static String num2String(int num) {
		switch(num) {
		case 0: return "1";
		case 1: return "2";
		case 2: return "4";
		default: throw new IllegalStateException("0 ~ 2 숫자 아님");
		}
	}
}