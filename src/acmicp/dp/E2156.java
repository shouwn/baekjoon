package acmicp.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;
import java.util.stream.Stream;

public class E2156 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] wines = Stream.iterate(0, n -> n).limit(Integer.parseInt(br.readLine()))
                    .map(CheckedFunction.wrap(n -> br.readLine()))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.out.println(solution(wines));
        }
    }

    public static int solution(int[] wines) {
        int[] dp = new int[wines.length];

        try {
            dp[0] = wines[0];
            dp[1] = wines[0] + wines[1];
            dp[2] = Math.max(wines[2] + dp[0], dp[1]);
            dp[2] = Math.max(wines[2] + wines[1], dp[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            return dp[wines.length - 1];
        }

        for (int i = 3; i < wines.length; i++) {
            dp[i] = Math.max(dp[i - 1], wines[i] + dp[i - 2]);
            dp[i] = Math.max(dp[i], wines[i] + wines[i - 1] + dp[i - 3]);
        }

        return dp[wines.length - 1];
    }

    interface CheckedFunction<T, R> {
        R apply(T t) throws Exception;

        static <T, R> Function<T, R> wrap(CheckedFunction<T, R> function) throws RuntimeException {
            return t -> {
                try {
                    return function.apply(t);
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            };
        }
    }
}
