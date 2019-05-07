package acmicp.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E9465 {

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
    public static int max(int... nums) {
        return Arrays.stream(nums).reduce(0, Math::max);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = toInt(br.readLine());

            for (int i = 0; i < T; i++) {
                br.readLine();
                int[][] sticker = makeSticker(br.readLine(), br.readLine());

                System.out.println(solution(sticker));
            }
        }
    }

    private static int[][] makeSticker(String line1, String line2) {
        int[][] sticker = new int[2][];

        sticker[0] = stringToIntArray(line1);
        sticker[1] = stringToIntArray(line2);

        return sticker;
    }

    private static int[] stringToIntArray(String line) {
        return Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int solution(int[][] sticker) {
        int n = sticker[0].length;

        int[][] dp = new int[2][n];

        dp[0][0] = sticker[0][0];
        dp[1][0] = sticker[1][0];

        dp[0][1] = sticker[0][1] + sticker[1][0];
        dp[1][1] = sticker[1][1] + sticker[0][0];

        for (int i = 2; i < n; i++) {
            dp[0][i] = sticker[0][i] + max(dp[1][i - 1], dp[1][i - 2]);
            dp[1][i] = sticker[1][i] + max(dp[0][i - 1], dp[0][i - 2]);
        }

        return max(dp[0][n - 1], dp[1][n - 1], dp[0][n - 2], dp[1][n - 2]);
    }
}
