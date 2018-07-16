package codeforces.contest498;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E3 {
	public static void main(String[] args) throws IOException {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int sz = Integer.valueOf(br.readLine());
			
			long[] arr = new long[sz];
			String[] in = br.readLine().split(" ");
			
			for(int i = 0; i < sz; i++)
				arr[i] = Integer.valueOf(in[i]);
			
			System.out.println(solution(arr));
		}
	}
	
	public static long solution(long[] arr) {
		
		int f = -1, r = arr.length; //index
		long leftSum = 0, rightSum = 0;
		
		long max = 0;
		
		while(f < r) {
			
			if(leftSum == rightSum) {
				max = Math.max(max, leftSum);
				leftSum += arr[++f];
				rightSum += arr[--r];
			}
			else if(leftSum > rightSum)
				rightSum += arr[--r];
			else
				leftSum += arr[++f];
		}
		
		return max;
	}
}
