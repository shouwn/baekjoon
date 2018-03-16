package acmicpc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E2108 {
	
	public static void main(String[] args){
		Map<Integer, Integer> map = new HashMap<>();
		
		Scanner scan = new Scanner(System.in);
		
		Count tempCount;
		
		String averString;
		
		PriorityQueue<Count> queue = new PriorityQueue<>();
		
		int aver = 0;
		int middle = 0;
		int range;
		int mode;
		
		int item;
		
		int[] arr = new int[scan.nextInt()];
		
		for(int i = 0; i < arr.length; i++){
			item = scan.nextInt();
			aver += item;
			
			if(map.containsKey(item)){
				map.put(item, map.get(item) + 1);
			}
			else
				map.put(item, 1);
			arr[i] = item;
		}
		
		Arrays.sort(arr);
		
		for(int key : map.keySet())
			queue.add(new Count(key, map.get(key)));

		tempCount = queue.poll();
		mode = tempCount.key;
		
		if(!queue.isEmpty() && tempCount.value == queue.peek().value)
			mode = queue.peek().key;
		
		middle = arr[(arr.length - 1) / 2];
		averString = String.format("%.0f", (double) aver / arr.length);
		range = arr[arr.length - 1] - arr[0];
		
		System.out.printf("%.0f\n%d\n%d\n%d", ((double) aver) / arr.length, middle, mode, range);
		
		
		scan.close();
	}
	
	static class Count implements Comparable<Count>{
		int key;
		int value;
		
		public Count(int key, int value) {
			super();
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(Count o) {
			int result = o.value - this.value;
			
			if(result == 0)
				result = this.key - o.key;
			
			return result;
		}

	}
}
