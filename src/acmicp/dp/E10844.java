package acmicp.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E10844 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(solution(N));
        }
    }

    private static int solution(int N) {
        int[][] memo = new int[N + 1][10];

        // init
        for (int num = 1; num < 10; num++) {
            memo[1][num] = 1;
        }

        for (int len = 2; len <= N; len++) {
            memo[len][0] += memo[len - 1][1];
            memo[len][9] += memo[len - 1][8];

            for (int num = 1; num < 9; num++) {
                memo[len][num] += memo[len - 1][num - 1] + memo[len - 1][num + 1];
                memo[len][num] %= 1_000_000_000;
            }
        }

        int result = 0;

        for (int i = 0; i < 10; i++) {
            result += memo[N][i];
            result %= 1_000_000_000;
        }

        return result;
    }
}
