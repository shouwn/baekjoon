package acmicpc.old;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E11726 {
	
	static Map<Integer, Integer> memo = new HashMap<>();
	
	public static void main(String[] args) {
	
		try(Scanner scan = new Scanner(System.in)){

			System.out.println(count(scan.nextInt()));
		}
		
		
	}
	
	public static int count(int n) {
		if(memo.containsKey(n))
			return memo.get(n);
		
		if(n < 2)
			return 1;
		
		int count = (count(n - 1) + count(n - 2)) % 10007;
		memo.put(n, count);
		return count;
	}
	
}
