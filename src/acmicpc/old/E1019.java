package acmicpc.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class E1019 {
	static final Map<Integer, Count> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		String input;
		Count count;
		try(BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in))){

			input = reader.readLine();
		}
		long time = System.currentTimeMillis();
		
		int len = input.length();
		count = new Count();
		for(int i = 1; i < len; i++)
			count.addOnlyZero(-(len - i) * (long)Math.pow(10, i - 1) * 9);
		System.out.println(count.sum(stepThree(input)));
		System.out.println(System.currentTimeMillis() - time + "MS");
	}

	// return e.g.) counted 001 ~ 999, 000
	public static Count stepOne(int len) {
		if(map.containsKey(len))
			return new Count(map.get(len));

		// 0 ~ 9 * 0 ~ 9 * 0 ~ 9
		Count count = new Count(len * (int)Math.pow(10, len - 1));
		map.put(len, new Count(count));

		return count;
	}

	// return e.g.) counted 0001 ~ n000
	public static Count stepTwo(int n, int len) {

		int tens = (int)Math.pow(10, len - 1);
		Count count = stepOne(len - 1) // 001 ~ 999, 000
				.multiply(n)//.onPrint() // 001 ~ 999, 000 + _001 ~ _999, _000 + ...
				.addOnlyZero(tens - 1); // "0" 001, "0" 002 ... "0" 999
		
		for(int i = 1; i < n; i++)
			count.arr[i] += tens;
		count.arr[n]++;
		
		return count;
	}
	
	public static Count stepThree(String s) {
		
		if(s.length() == 1) {
			Count count = new Count();
			int n = Integer.valueOf(s);
			for(int i = 1; i <= n; i++)
				count.arr[i]++;
			
			return count;
		}
		
		String sub = s.substring(1);
		int n = Integer.valueOf(s.substring(0, 1));
		Count count;
		
		if(n != 0)
			count = stepTwo(n, s.length());
		else
			count = new Count();
		count.arr[n] += Integer.valueOf(sub);
		return stepThree(sub).sum(count);
	}
}
	
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

	public Count subOnlyZero(long n) {
		this.arr[0] -= n;
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

	public Count addOnlyZero(long n) {
		this.arr[0] += n;
		return this;
	}

	public Count onPrint() {
		System.out.println("onPrint: " + this);
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
