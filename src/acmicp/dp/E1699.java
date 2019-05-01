package acmicp.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E1699 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(solution(n));
        }
    }

    public static int solution(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j * j <= n; j++) {
                int square = j * j;

                if (i >= square) {
                    min = Math.min(min, 1 + dp[i - square]);
                }
            }

            dp[i] = min;
        }

        return dp[n];
    }
}
