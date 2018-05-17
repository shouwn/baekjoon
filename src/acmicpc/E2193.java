package acmicpc;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E2193 {
	
	static Map<Integer, BigInteger[]> memo = new HashMap<>();
	
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)){
			
			int input = scan.nextInt();
			
			for(int i = 0; i < input; i++)
				memo.put(i, new BigInteger[2]);
			
			System.out.println(count(input - 1, 0));
			// 맨 앞자리는 무조건 1 이고 그 다음은 0이기 때문에
		}
	}
	
	public static BigInteger count(int n, int bit) {
		if(memo.get(n)[bit] != null)
			return memo.get(n)[bit];
		
		if(n <= 1)
			return BigInteger.ONE;
		
		BigInteger count;
		
		if(bit == 0)
			count = count(n - 1, 0).add(count(n - 1, 1));
		
		else
			count = count(n - 1, 0);
		
		memo.get(n)[bit] = count;
		
		return count;
	}
}
