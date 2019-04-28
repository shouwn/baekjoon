package acmicpc.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class E1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputs;
		
		for(int count = Integer.valueOf(reader.readLine()); count > 0; count--) {

			PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
			
			inputs = reader.readLine().split(" ");
			
			int lenght = Integer.valueOf(inputs[0]);
			int target = Integer.valueOf(inputs[1]);
			
			int[] arr = new int[lenght];
			
			inputs = reader.readLine().split(" ");
			
			for(int i = 0; i < lenght; i++) {
				int num = Integer.valueOf(inputs[i]);
				arr[i] = num;
				queue.add(num);
			}
			
			int point = 0, print = 0, result = 0;
			
			while(result == 0) {
				int current = queue.peek();
				int remain = 0;
				
				while(!queue.isEmpty() && current == queue.peek()) {
					remain++;
					queue.poll();
				}
				
				while(result == 0 && remain-- > 0) {
					
					while(arr[point] != current)
						point = (point + 1) % lenght;
					
					arr[point] = Integer.MIN_VALUE;
					
					print++;
					
					if(point == target)
						result = print;
				}
				
			}
			
			System.out.println(result);
			
		}

	}

}
