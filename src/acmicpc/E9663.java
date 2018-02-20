package acmicpc;

import java.util.Scanner;

public class E9663 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		scan.close();
		
		System.out.println(search(input));
		
	}
	
	public static int search(int n) {
		int[] arr = new int[n];
		
		return search(arr, 0);
	}
	
	public static int search(int[] arr, int row) {
		if(row == arr.length)
			return 1;
		
		int count = 0;
		
		for(int col = 0; col < arr.length; col++) {
			if(promising(arr, row, col)) { 
				arr[row] = col;
				count += search(arr, row + 1);
			}
		}
		
		return count;
	}
	
	public static boolean promising(int[] arr, int row, int col) {
		
		for(int i = 0; i < row; i++) {
			if(arr[i] == col)
				return false; // column check
			
			if(Math.abs(arr[i] - col) == row - i)
				return false; // diagonal check
		}
		
		return true;
	}

}
