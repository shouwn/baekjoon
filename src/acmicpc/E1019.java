package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E1019 {
	static String input;
	public static void main(String[] args) throws IOException {
		try(BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in))){
			
			input = reader.readLine();
		}
		
		System.out.println("result: " + counting(input));
	}
	
	public static Count counting(String s) {
		int len = s.length();
		if(len == 1) {
			Count count = new Count();
			int n = Integer.valueOf(s);
			for(int i = 1; i <= n; i++) {
				count.arr[i]++;
				count.arr[Integer.valueOf(input.charAt(0))]++;
			}
			return count;
		}
		
		int num = Integer.valueOf(s);
		int coe = num / (int)Math.pow(10, len - 1);
		return first(len, coe).sum(counting(s.substring(1)));
	}
	
	public static Count first(int len, int coe) {
		Count count = new Count();
		for(int i = len - 1; i > 1; i--) {
			count.allAdd(((int)Math.pow(10, i)) - 1);
			count.allUpExceptZero();
		}
		count.allUpExceptZero();
		count.arr[0] += len - 1;
		count.multiply(coe);
		
		for(int i = 1; i <= coe; i++)
			count.arr[i]++;
		return count;
	}
}

class Count{
	long[] arr = new long[10];
	
	public Count() {
		
	}
	
	public Count(int n) {
		for(int i = 0; i < 10; i++)
			arr[i] = n;
	}
	
	public Count sum(Count other) {
		Count count = new Count();
		
		for(int i = 0; i < 10; i++) 
			count.arr[i] = this.arr[i] + other.arr[i];
		
		return count;
	}
	
	public void allAdd(long n) {
		for(int i = 0; i < 10; i++)
			arr[i] += n;
	}
	
	public void allUpExceptZero() {
		for(int i = 1; i < 10; i++)
			arr[i]++;
	}
	
	public void  multiply(long n) {
		for(int i = 0; i < 10; i++) 
			arr[i] *= n;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < 9; i++)
			str.append(arr[i]).append(" ");
		
		return str.append(arr[9]).toString();
	}
}
