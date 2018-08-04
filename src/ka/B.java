package ka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException {

		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			String[] in = br.readLine().split(" ");
			
			int N = Integer.parseInt(in[0]);
			int K = Integer.parseInt(in[1]);
			
			in = br.readLine().split(" ");
			
			int[] arr = new int[N];
			
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(in[i]);
			}
			
			System.out.println(solution(arr, K));
		}
		
	}
	
	public static double solution(int[] arr, int K) {
		double min = Double.MAX_VALUE;
		
		for(int i = K; i <= arr.length; i++) {
			for(int j = 0; j <= arr.length - i; j++) {
				double bun = bun(arr, i - K, i - 1 + j);
				min = Double.isNaN(bun) ? min : Math.min(bun, min);
			}
		}
		return Math.sqrt(min);
	}
	
	public static double avg(int[] arr, int f, int r) {
		double sum = 0;
		
		for(int i = f; i <= r; i++) {
			sum += arr[i];
		}
		
		//System.out.println("f: " + f + " r: " + r + " " + (r - f + 1));
		
		return sum / (r - f + 1);
	}
	
	public static double bun(int[] arr, int f, int r) {
		
		double sum = 0;
		double avg = avg(arr, f, r);
		
		for(int i = f; i <= r; i++) {
			sum += Math.pow(arr[i] - avg, 2);
		}
		
		return sum / (r - f + 1);
	}
}
