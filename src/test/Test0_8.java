package test;

import java.util.Random;

public class Test0_8 {
	
	static final int SIZE = 100000000;
	
	public static void main(String[] args) {
		
		long time;
		int[] arr = new int[SIZE];
		int[] dest = new int[SIZE];
		
		Random random = new Random();
		
		for(int i = 0; i < SIZE; i++) {
			arr[i] = random.nextInt(SIZE);
		}
		
		time = System.currentTimeMillis();
		for(int i = 0; i < SIZE - 1; i++) {
			arr[i] = arr[i + 1];
		}
		System.out.println("for loop: " + (System.currentTimeMillis() - time) + "ms");
		
		dest = new int[SIZE];
		
		time = System.currentTimeMillis();
		System.arraycopy(arr, 1, arr, 0, SIZE - 1);
		System.out.println("arraycopy: " + (System.currentTimeMillis() - time) + "ms");
		
		
	}
}
