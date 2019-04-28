package acmicpc.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class E2468 {

	static Set<Integer> set = new HashSet<>();

	static boolean[][] boolMap;

	public static void main(String[] args) throws IOException {

		int[][] arr = input();

		int max;
		int count;

		max = search(arr, 0);

		for(int i : set) {
			count = search(arr, i);
			max = Math.max(max, count);
		}

		System.out.println(max);

	}

	public static void connect(int[][] arr, int row, int col, int height) {

		if(row < 0)
			return;
		if(row >= arr.length)
			return;
		if(col < 0)
			return;
		if(col >= arr.length)
			return;

		if(boolMap[row][col])
			return;

		boolMap[row][col] = true;

		if(arr[row][col] <= height)
			return;
		else {
			connect(arr, row - 1, col, height);
			connect(arr, row + 1, col, height);
			connect(arr, row, col - 1, height);
			connect(arr, row, col + 1, height);
		}
	}

	public static int search(int[][] arr, int height) {
		int count = 0;

		boolMap = new boolean[arr.length][arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[i][j] > height && !boolMap[i][j]) {
					count++;
					connect(arr, i, j, height);
				}
			}
		}

		return count;
	}

	/*
	public static boolean isConnected(int[][] arr, int row, int col, int height) {
		boolean result = false;

		if(row != 0) 
			result |= arr[row - 1][col] > height;

		if(col != 0)
			result |= arr[row][col - 1] > height;

		return result;
	}
	 */

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
