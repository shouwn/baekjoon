package acmicpc.old;

import java.util.Scanner;

public class E15667 {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)){
			System.out.println(solution(scan.nextInt()));
		}
	}
	
	public static int solution(int N) {
		int n = N - 1;
		
		for(int i = 1; i <= 100; i++) { //max 10101 - 1 = 100 * 101
			if(i * (i + 1) == n)
				return i;
		}
		
		return 0;
	}
}
