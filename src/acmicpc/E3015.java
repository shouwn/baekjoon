package acmicpc;

import java.util.Scanner;
import java.util.Stack;

public class E3015 {

	private static final int NONE = -100;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] arr = new int[scan.nextInt()];
		for(int i = 0; i < arr.length; i++)
			arr[i] = scan.nextInt();

		scan.close();

		int count = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < arr.length; i++) {
			count 
		}
	}

	public static int findIndexOfAbove(int s, int[] a, int start, int end) {

		if(start <= end) {
			int middle = start + end;

			if(a[middle] == s)
				return middle;

			if(a[middle] > s) {
				int temp = findIndexOfAbove(s, a, middle + 1, end);
				return  temp < 0 ? findIndexOfAbove(s, a, middle) : temp;
			}
			else {
				int temp = findIndexOfAbove(s, a, start, middle - 1);
				return temp < 0 ? findIndexOfAbove(s, a, middle) : temp;
			}
		}
		else
			return NONE;
	}
	
	public static int findIndexOfAbove(int s, int[] a, int start) {
		while(a[start] > s)
			start--;
		return start;
	}
}
