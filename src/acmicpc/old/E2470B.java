package acmicpc.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E2470B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		try(BufferedReader scan = new BufferedReader(new InputStreamReader(System.in))) {
			int[] ans = solution(getArr(scan, Integer.valueOf(scan.readLine())));
			
			System.out.println(ans[0] + " " +  ans[1]);
		}
	}
	
	public static int[] solution(int[] arr) {
		int start = 0, end = arr.length - 1;
		int min = Integer.MAX_VALUE;
		int[] ans = new int[2];
		
		while(start < end) {
			int curAbs = Math.abs(arr[start] + arr[end]);
			
			if(min > curAbs) {
				ans[0] = arr[start];
				ans[1] = arr[end];
				min = curAbs;
			}
			
			int left = Math.abs(arr[start]), right = Math.abs(arr[end]);
			
			if(left >= right)
				start++;
			if(left <= right)
				end--;
		}
		
		return ans;
	}
	
	public static int[] getArr(BufferedReader scan, int sz) throws IOException {
		int[] arr = new int[sz];
		String[] input = scan.readLine().split(" ");
		
		for(int i = 0; i < sz; i++)
			arr[i] = Integer.valueOf(input[i]);
			
		Arrays.sort(arr);
		return arr;
	}

}