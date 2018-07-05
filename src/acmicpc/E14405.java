package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class E14405 {
	
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			System.out.println(solution(scan.nextLine()));
		}
	}
	
	public static String solution(String msg) {
		return msg.replaceAll("pi|ka|chu", "").length() == 0 ? "YES" : "NO";
	}

}
