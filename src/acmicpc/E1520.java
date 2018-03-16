package acmicpc;

import java.util.Scanner;

public class E1520{

	private static int row, col;
	private static int[] memo;

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		row = scan.nextInt();
		col = scan.nextInt();

		int[] arr = new int[row*col];
		memo = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = scan.nextInt();
			memo[i] = -1;
		}

		System.out.println(getRouteCount(arr, 0));

	}

	public static int getRouteCount(int[] arr, int index){
		int countRouteToEnd = 0;
		
		if(memo[index] != -1)
			return memo[index];
		
		else if(index == arr.length - 1){
			return 1;
		}
		else{
			if(index / col != 0 && arr[index] > arr[index - col])
				countRouteToEnd += getRouteCount(arr, index - col);
			if(index % col != 0 && arr[index] > arr[index - 1])
				countRouteToEnd += getRouteCount(arr, index - 1);
			if(index % col != col-1 && arr[index] > arr[index + 1])
				countRouteToEnd += getRouteCount(arr, index + 1);
			if(index / col != row - 1 && arr[index] > arr[index + col])
				countRouteToEnd += getRouteCount(arr, index + col);
		}
		
		memo[index] = countRouteToEnd;
		
		return countRouteToEnd;
	}

}
