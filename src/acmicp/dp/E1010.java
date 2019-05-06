package acmicp.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class E1010 {

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            FactorialCalculator factorialCalculator = new FactorialCalculator();

            int count = toInt(br.readLine());

            for (int i = 0; i < count; i++) {
                String[] inputs = br.readLine().split(" ");
                System.out.println(solution(toInt(inputs[0]), toInt(inputs[1]), factorialCalculator));
            }
        }
    }

    public static BigInteger solution(int n, int m, FactorialCalculator factorialCalculator) {
        return factorialCalculator.factorial(m)
                .divide(factorialCalculator.factorial(m - n)
                        .multiply(factorialCalculator.factorial(n)));
    }

    static class FactorialCalculator {
        static BigInteger[] dp = new BigInteger[35];

        static {
            dp[0] = BigInteger.ONE; // for solution
            dp[1] = BigInteger.ONE;
            for (int i = 2; i < dp.length; i++) {
                dp[i] = BigInteger.valueOf(i).multiply(dp[i - 1]);
            }
        }

        BigInteger factorial(int n) {
            return dp[n];
        }
    }
}
