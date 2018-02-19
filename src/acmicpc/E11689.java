package acmicpc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class E11689 {

	static Map<Long, Long> memo = new HashMap<>();

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		long input = scan.nextLong();
		
		Set<Long> set = primeFactors(input);
		
		double result = input;
		
		for(long factor : set) {
			result *= (factor - 1) / (double) factor;
		}
		
		System.out.printf("%.0f", result);
	}
	
	public static Set<Long> primeFactors(long n){
		Set<Long> set = new HashSet<>();
		
		while(n % 2 == 0) {
			set.add((long) 2);
			n /= 2;
		}
		
		long sqrt = (long) Math.sqrt(n);
		
		for(Long i = (long) 3; i <= sqrt; i += 2) {
			while(n % i == 0) {
				set.add(i);
				n /= i;
			}
		}
		
		if(n > 2)
			set.add(n);
		
		return set;
	}

	public static long eulerPhi(long n) {
		long result = 1;

		if(memo.containsKey(n))
			return memo.get(n);

		if(checkPrime(n)) {
			memo.put(n, n - 1);
			return n - 1;
		}
		
		for(int i = 2; i < n; i++) {
			if(gcd(n, i) == 1) {
				result++;

				if(n % i == 0) {
					result = eulerPhi(n / i) * eulerPhi(i);
					memo.put(n, result);
					
					return result;
				}
			}
		}
		
		memo.put(n, result);
		return result;
	}

	public static boolean checkPrime(long n) {
		boolean result = true;

		for(int i = 2; i < n; i++) {
			if(n % i == 0)
				result = false;
		}

		return result;
	}

	public static long gcd(long p, long q) {

		int shift;

		if(p == 0 || q == 0)
			return p | q;

		for(shift = 0; ((p | q) & 1) == 0; ++shift) {
			p >>= 1;
		q >>= 1;
		}

		while((p & 1) == 0)
			p >>= 1;

			do {
				while((q & 1) == 0)
					q >>= 1;

					if(p < q)
						q -= p;
					else {
						long diff = p - q;
						p = q;
						q = diff;
					}
					q >>= 1;
			} while(q != 0);

			return p << shift;
	}

}
