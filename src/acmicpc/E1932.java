package acmicpc;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E1932 {

	private static int height;
	private static int[][] triangle;
	private static int[][] triangleMax;

	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		
		height = scan.nextInt();
		triangle = new int[height][];
		triangleMax = new int[height][];

		for(int i = 0; i < height; i++){
			triangle[i] = new int[i+1];
			triangleMax[i] = new int[i+1];
			for(int j = 0; j < triangle[i].length; j++){
				triangle[i][j] = scan.nextInt();
				triangleMax[i][j] = -1;
			}
		}
		
		triangleMax[0][0] = triangle[0][0];
		
		for(int i = 1; i < height; i++){
			for(int j = 0; j < triangle[i].length; j++)
				max(i, j);
		}
		
		for(int i = 0; i < triangle[height - 1].length; i++){
			queue.add(triangleMax[height-1][i]);
		}
		
		System.out.println(queue.poll());

	}
	
	public static int max(int height, int index){
		if(triangleMax[height][index] != -1)
			return triangleMax[height][index];
		int left = -1;
		int right = -1;
		int max;
		
		if(index - 1 >= 0)
			left = max(height - 1, index - 1);
		if(index < triangle[height - 1].length)
			right = max(height - 1, index);
		
		max = Math.max(left, right) + triangle[height][index];
		triangleMax[height][index] = max;
		
		return max;
	}

}