package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E2869 {
	public static void main(String[] args) throws IOException {
		try(BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))){
			String[] s = rd.readLine().split(" ");
			int A = Integer.valueOf(s[0]);
			int B = Integer.valueOf(s[1]);
			int V = Integer.valueOf(s[2]);
			System.out.println(solution(A, B, V));
		}
	}
	
	public static int solution(int A, int B, int V) {
		int n = V - B - 1;
		int up = A - B;
		
		return n / up + 1;
	}

}
