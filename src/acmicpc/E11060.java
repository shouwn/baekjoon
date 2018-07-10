package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class E11060 {
	
	private static final int MAX = Integer.MAX_VALUE / 2;
	
	public static void main(String[] args) throws IOException {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int length = Integer.valueOf(br.readLine());
			String[] in = br.readLine().split(" ");
			int[] arr = new int[length];
			
			if(length == 1) {
				System.out.println(0);
				System.exit(0);
			}
			
			for(int i = 0; i < length; i++) 
				arr[i] = Integer.valueOf(in[i]);
			
			int ans = solution(new HashMap<Integer, Integer>(), arr, 0);
			
			System.out.println(ans >= MAX ? -1 : ans);
		}
	}
	
	public static int solution(Map<Integer, Integer> memo, int[] arr, int cur) {
		if(memo.containsKey(cur))
			return memo.get(cur);
		
		if(cur >= arr.length) {
			memo.put(cur, MAX);
			return MAX;
		}
		
		if(cur == arr.length - 1) {
			memo.put(cur, 0);
			return 0;
		}
		
		int curValue = arr[cur];
		int min = MAX;
		
		for(int i = 1; i <= curValue; i++) {
			int temp = solution(memo, arr, cur + i);
			if(min > temp)
				min = temp;
		}
		
		memo.put(cur, min + 1);
		return min + 1;
	}
}
