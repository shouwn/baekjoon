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
			
			Pair[] arr = new Pair[n];
			for(int i = 0; i < n; i++)
				arr[i] = makePair(br);
			
			System.out.println(solution(arr));
		}
	}
	
	public static String solution(Pair[] arr) throws IOException {
		Pair pre = arr[0];
		Pair temp;
		
		int n = arr.length;
		
		for(int i = 1; i < n; i++) {
			temp = arr[i];
			
			if(pre.big > temp.small)
				return "YES";
			
			pre = temp;
		}
		
		return "NO";
	}

	
	public static String solution(int n, BufferedReader br) throws IOException {
		Pair pre = makePair(br);
		Pair temp;
		
		boolean flag = true;
		
		n -= 1;
		
		for(int i = 0; i < n; i++) {
			temp = makePair(br);
			
			if(pre.big > temp.small)
				return "YES";
			
			if(pre.big != temp.small)
				flag = false;
			
			pre = temp;
		}
		
		return (flag ? "YES" : "NO");
	}
	
	public static Pair makePair(BufferedReader br) throws IOException {
		String[] in = br.readLine().split(" ");
		return new Pair(Integer.valueOf(in[0]), Integer.valueOf(in[1]));
	}
}