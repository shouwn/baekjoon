package acmicpc.old;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E11050 {
	
	private static Map<Combination, Integer> map = new HashMap<>();
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		System.out.println(combination(scan.nextInt(), scan.nextInt()));
		scan.close();
	}
	
	public static int combination(int n, int r){
		Combination key = new Combination(n, r);
		
		if(map.containsKey(key))
			return map.get(key);
		
		if(r == 0 || r == n){
			map.put(key, 1);
			return 1;
		}
		
		else{
			int value = combination(n - 1, r) + combination(n - 1, r - 1);
			map.put(key, value);
			return value;
		}
			
		
	}
	
	static class Combination{
		int n, r;

		public Combination(int n, int r) {
			super();
			this.n = n;
			this.r = r;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + n;
			result = prime * result + r;
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
			Combination other = (Combination) obj;
			if (n != other.n)
				return false;
			if (r != other.r)
				return false;
			return true;
		}
	}

}