package acmicpc.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class E2293 {
	
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			// index 0 is coin count, index 1 is value
			int[] metaData = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();

			int[] coins = Stream.iterate(0, n -> n + 1).limit(metaData[0])
					.map(n -> {
						try {
							return br.readLine();
						} catch (IOException e) {
							throw new RuntimeException(e);
						}
					})
					.mapToInt(Integer::parseInt)
					.toArray();

			System.out.println(solution2(coins, metaData[1]));
		}
	}

	public static int solution1(int[] coins, int value) {
		return solution1(coins, value, 0);
	}

	public static int solution1(int[] coins, int value, int index) {
		if (value == 0) {
			return 1;
		} else if (index >= coins.length || value < 0) {
			return 0;
		}

		int sum = 0;

		for (int i = 0, maxCoinCount = value / coins[index]; i <= maxCoinCount; i++) {
			sum += solution1(coins, value - i * coins[index], index + 1);
		}

		return sum;
	}

	public static int solution2(int[] coins, int value) {

		int[] memo = new int[value + 1];
		memo[0] = 1;

		for (int i = 0, coinsCount = coins.length; i < coinsCount; i++) {

			int coin = coins[i];

			for (int k = 1; k <= value; k++) {
				if (k - coin >= 0) {
					memo[k] += memo[k - coin];
				}
			}
		}

		return memo[value];
	}
}