package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class E1019 {
	static final Map<Integer, Count> map = new HashMap<>();
	
	static {
		map.put(1, new Count().AllAddExceptZero(1));
	}
	
	public static void main(String[] args) throws IOException {
		String input;
		try(BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in))){
			
			input = reader.readLine();
		}
		
		long time = System.currentTimeMillis();
		System.out.println("result: " + stepThree(input));
		System.out.println(System.currentTimeMillis() - time +"MS");
		time = System.currentTimeMillis();
		Count count = new Count();
		int num = Integer.valueOf(input);
		
		for(int i = 1; i <= num; i++) {
			int n = i;
			while(n != 0) {
				int digit = n % 10;
				n /= 10;
				count.arr[digit]++;
			}
		}
		System.out.println("result: " + count);
		System.out.println(System.currentTimeMillis() - time +"MS");
	}
	
	public static Count stepThree(String number) {
		
		int n = Integer.valueOf(number.substring(0, 1));
		
		if(number.length() == 1) {
			Count count = new Count();
			Stream.iterate(1, x -> x+1).
				limit(Integer.valueOf(number)).
				forEach((index) -> count.arr[index]++);
			return count;
		}
		
		if(n == 0)
			return stepThree(number.substring(1));
		
		Count count = stepThree(number.substring(1)).
				sum(stepTwo(n, number.length()));
		
		count.arr[n] += n * Integer.valueOf(number.substring(1));
		
		return count;
	}
	
	
	// return 1 ~ 9 or 99 or 999 ...
	public static Count stepOne(int len) {
		if(map.containsKey(len))
			return new Count(map.get(len));
		
		int zeros = (len-2) * (len-1) / 2 * 9;
		
		Count count = stepOne(len - 1).AllAddOnlyZero(zeros).
				multiply(9).
				sum(map.get(len - 1))
				.AllAddExceptZero((long)Math.pow(10, len - 1));
		count.arr[0] += 9 * (len - 1); // 10 20 30 ... or 100 200 300 ...
		
		map.put(len, new Count(count));
		
		return count;
	}
	
	public static Count stepTwo(int n, int len) {
		Count count = stepOne(len - 1).multiply(n);
		
		int tens = (int)Math.pow(10, len - 1);
		for(int i = 1; i < n; i++)
			count.arr[i] += tens;
		
		count.arr[n]++;
		count.arr[0] += n * (len - 1);
		
		return count;
	}
}

// immutable
class Count{
	long[] arr = new long[10];
	
	public Count() {
		
	}
	
	public Count(Count other) {
		for(int i = 0; i < 10; i++) 
			this.arr[i] = other.arr[i];
	}
	
	public Count(int n) {
		for(int i = 0; i < 10; i++)
			arr[i] = n;
	}
	
	public Count sum(Count other) {
		for(int i = 0; i < 10; i++) 
			this.arr[i] += other.arr[i];
		
		return this;
	}
	
	public Count allAdd(long n) {
		for(int i = 0; i < 10; i++)
			this.arr[i] += n;

		return this;
	}
	
	public Count AllAddExceptZero(long n) {
		for(int i = 1; i < 10; i++)
			this.arr[i] += n;

		return this;
	}
	
	public Count multiply(long n) {
		for(int i = 0; i < 10; i++) 
			this.arr[i] *= n;

		return this;
	}

	public Count AllAddOnlyZero(long n) {
		this.arr[0] += n;
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < 9; i++)
			str.append(arr[i]).append(" ");
		
		return str.append(arr[9]).toString();
	}
}
