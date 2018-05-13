package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class E2468 {
	
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws IOException {

		int[][] arr = input();
		
		int max;
		int count;
		
		max = search(arr, 0);
		
		for(int i : set) {
			count = search(arr, i);
			
			System.out.println(i + ": " +  count);
			max = Math.max(max, count);
		}
		
		System.out.println(max);

	}
	
	public static int search(int[][] arr, int height) {
		int count = 0;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[i][j] > height && !isConnected(arr, i, j, height)) {
					count++;
					if(height == 4) 
						System.out.println("arr" + "[" + i + "][" + j + "] = " + arr[i][j]
								+ " height: " + height);
				}
			}
		}
		
		return count;
	}
	
	public static boolean isConnected(int[][] arr, int row, int col, int height) {
		boolean result = false;
		
		if(row != 0) 
			result |= arr[row - 1][col] > height;
			
		if(col != 0)
			result |= arr[row][col - 1] > height;
			
		return result;
	}

	public static int[][] input() throws NumberFormatException, IOException{
		int size;
		int[][] arr;

		try(BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in))){
			size = Integer.valueOf(reader.readLine());
			arr = new int[size][size];
			String input;
			int temp;
			for(int i = 0, j = 0; i < size; i++) {
				input = reader.readLine();
				j = 0;
				for(String s : input.split(" ")) {
					temp = Integer.valueOf(s);
					arr[i][j++] = temp;
					set.add(temp);
				}
			}
		}
		
		return arr;
	}
}
