package acmicpc.old;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E1699 {
	
	static Map<Integer, Integer> map = new HashMap<>();
	
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int input = scan.nextInt();
			System.out.println(count(input));
		}
	}
	
	public static int count(int n) {
		if(map.containsKey(n))
			return map.get(n);
		
		if(n == 1)
			return 1;
		if(n == 0)
			return 0;
		
		int middle = (int)Math.sqrt(n);
		
		int min = Integer.MAX_VALUE - 1; // 오버 플로우 방지
		
		for(int i = middle; i >= 1; i--) {
			int temp = 1 + count(n - (int)Math.pow(i, 2));
			if(temp < min)
				min = temp;
		}
		
		map.put(n, min);
		return min;
	}
}
