package acmicpc.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class E2294 {
	
	static Map<Integer, Integer> memo = new HashMap<>();
	static int k;
	
	public static void main(String[] args) throws IOException {
		int[] coins = scanCoins();
		
		int min = minCount(coins, k);
		
		System.out.println(min != Integer.MAX_VALUE ? min : -1);
	}
	
	public static int minCount(int[] coins, int n) {
		
		if(memo.containsKey(n))
			return memo.get(n);
		
		if(n == 0)
			return 0;
		
		int min = Integer.MAX_VALUE - 1;
		
		for(int i = 0; i < coins.length; i++) {
			int temp;
			
			if(n - coins[i] >= 0) {
				temp = minCount(coins, n - coins[i]);
				if(temp != Integer.MAX_VALUE && min > temp)
					min = temp;
			}
		}
		
		memo.put(n, ++min);
		return min;
	}
	
	public static int[] scanCoins() throws IOException {
		int[] coins;
		
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
			String[] input = reader.readLine().split(" ");
			int count = Integer.valueOf(input[0]);
			k = Integer.valueOf(input[1]);
			
			coins = new int[count];
			
			for(int i = 0; i < count; i++)
				coins[i] = Integer.valueOf(reader.readLine());
		}
		
		return coins;
	}
}
