package acmicpc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E2293 {
	
	private static Map<Key, Integer> map = new HashMap<>();
	private static int[] coins;
	
	public static void main(String[] args){
		int type, goal;
		Scanner scan = new Scanner(System.in);
		
		type = scan.nextInt();
		goal = scan.nextInt();
		
		coins = new int[type];
		for(int i = 0; i < type; i++){
			coins[i] = scan.nextInt();
		}
		
		System.out.println(getCases(type - 1, goal));
		
	}
	
	public static int getCases(int capacity, int goal){
		Key key = new Key(capacity, goal);
		
		if(map.containsKey(key))
			return map.get(key);
		
		if(capacity < 0)
			return 0;
		
		if(goal == 0)
			return 1;
		if(goal < 0)
			return 0;
		
		int sum = getCases(capacity - 1, goal) + getCases(capacity, goal - coins[capacity]);
		
		map.put(key, sum);
		
		return sum;
	}
	
	static class Key{
		int capacity;
		int goal;
		
		public Key(int capacity, int goal) {
			super();
			this.capacity = capacity;
			this.goal = goal;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + capacity;
			result = prime * result + goal;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Key other = (Key) obj;
			if (capacity != other.capacity)
				return false;
			if (goal != other.goal)
				return false;
			return true;
		}
		
	}
	
}