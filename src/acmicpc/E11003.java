package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class E11003 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int len, windowSize;
		int[] arr;
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		len = Integer.parseInt(st.nextToken());
		windowSize = Integer.parseInt(st.nextToken());
		arr = new int[len];
		
		st = new StringTokenizer(reader.readLine());
		
		for(int i = 0; i < len; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		printMin(arr, windowSize);
		
	}
	
	public static void printMin(int[] arr, int windowSize){
		StringBuilder str = new StringBuilder();
		
		Deque<Integer> deque = new LinkedList<>();
		
		for(int i = 0; i < arr.length; i++){

			while(!deque.isEmpty() && deque.peekFirst() <= i - windowSize)
				deque.removeFirst();
			
			while(!deque.isEmpty() && arr[deque.peekLast()] >= arr[i])
				deque.removeLast();
			
			deque.addLast(i);
			
			str.append(arr[deque.peekFirst()]).append(" ");
		}
		
		System.out.println(str.toString());
	}

}