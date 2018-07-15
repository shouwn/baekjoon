package codeforces.contest497;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E2 {
	
	static class Pair{
		int small, big;

		public Pair(int a, int b) {
			this.small = Math.min(a, b);
			this.big = Math.max(a, b);
		}
	}
	
	public static void main(String[] args) throws IOException {		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			
			int n = Integer.valueOf(br.readLine());
			
			System.out.println(solution(n, br));
		}
	}
	
	public static String solution(int n, BufferedReader br) throws IOException {
		int pre = makePair(br).big;
		Pair temp;
		
		n -= 1;
		
		for(int i = 0; i < n; i++) {
			temp = makePair(br);
			
			if(pre >= temp.big)
				pre = temp.big;
			else if(pre >= temp.small)
				pre = temp.small;
			else
				return "NO";
		}
		
		return "YES";
	}
	
	public static Pair makePair(BufferedReader br) throws IOException {
		String[] in = br.readLine().split(" ");
		return new Pair(Integer.valueOf(in[0]), Integer.valueOf(in[1]));
	}
}