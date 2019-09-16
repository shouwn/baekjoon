package acmicp.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class E1912 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            br.readLine();
            int[] arr = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.out.println(solution(arr));
        }
    }

    private static long solution(int[] arr) {
        long max = arr[0];

        long[] memo = new long[arr.length];
        memo[0] = arr[0];

        for (int n = 1; n < arr.length; n++) {
            memo[n] = arr[n];

            if (memo[n - 1] > 0) {
                memo[n] += memo[n - 1];
            }

            max = Math.max(max, memo[n]);
        }

        return max;
    }
}
