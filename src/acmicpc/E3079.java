package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E3079 {
	public static void main(String[] args) throws IOException {
		try(BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))){
			System.out.println(solution(rd));
		}
	}

	public static long solution(BufferedReader rd) throws NumberFormatException, IOException {
		String[] input = rd.readLine().split(" ");

		int N = Integer.valueOf(input[0]);
		int M = Integer.valueOf(input[1]);

		long[] arr = new long[N];

		long max = 0;

		for(int i = 0; i < N; i++) {
			arr[i] = Integer.valueOf(rd.readLine());
			max = Math.max(max, arr[i]);
		}
		
		return solution(0, max * M, arr, M);
	}

	public static long solution(long f, long r, long[] arr, long M) {
		if(f > r) 
			return Long.MAX_VALUE;

		long middle = (f + r) / 2;
		long count = 0;

		for(long i : arr) 
			count += middle / i;
		
		if(count < M)
			return solution(middle + 1, r, arr, M);
		else
			return Math.min(middle, solution(f, middle - 1, arr, M));
	}
}
