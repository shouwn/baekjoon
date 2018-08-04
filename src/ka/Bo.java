package ka;

import java.util.HashMap;
import java.util.Map;

public class Bo {

	enum MOVE {
		RIGHT, DOWN;
	}
	
	Map<Key, Integer> memo = new HashMap<>();
	int MOD = 20170805;
	
	public static void main(String[] args) {
		int[][] a = new int[][] {
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0}
		};
		
		int [][] b = new int[][] {
			{0, 2, 0, 0, 0, 2},
			{0, 0, 2, 0, 1, 0},
			{1, 0, 0, 2, 2, 0}
		};
		
		System.out.println(new Bo().solution(3, 3, a));
		System.out.println(new Bo().solution(3, 6, b));
	}
	
	public int solution(int m, int n, int[][] cityMap) {
		return solution(0, 0, cityMap, MOVE.DOWN) % MOD;
	}
	
	public int solution(int m, int n, int[][] cityMap, MOVE before) {
		if(m >= cityMap.length || n >= cityMap[0].length) return 0;
		if(m + n + 2 == cityMap.length + cityMap[0].length) return 1;
		
		Integer val = memo.get(new Key(m, n, before));
		if(val != null) return val;
		
		int state = cityMap[m][n];
		if(state == 1) return 0;
		
		int ans = 0;
		
		if(state == 0) 
			ans = (solution(m + 1, n, cityMap, MOVE.DOWN) 
					+ solution(m, n + 1, cityMap, MOVE.RIGHT)) % MOD;
		else {
			
			if(before == MOVE.DOWN)
				ans = solution(m + 1, n, cityMap, before);
			else
				ans =  solution(m, n + 1, cityMap, before);			
		}
		memo.put(new Key(m, n, before), ans);
		
		//System.out.println(m + " " + n + " " + before.name() +  " ans: " + ans);
		return ans;
	}
	
	static class Key{
		int m, n;
		MOVE before;
		public Key(int m, int n, MOVE before) {
			super();
			this.m = m;
			this.n = n;
			this.before = before;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((before == null) ? 0 : before.hashCode());
			result = prime * result + m;
			result = prime * result + n;
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
			if (before != other.before)
				return false;
			if (m != other.m)
				return false;
			if (n != other.n)
				return false;
			return true;
		}
	}
}
