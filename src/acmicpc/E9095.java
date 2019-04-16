package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class E9095 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Map<Long, Long> memo = new HashMap<>();

            Stream.iterate(0, n -> n).limit(Integer.parseInt(br.readLine()))
                    .map(n -> {
                        try {
                            return br.readLine();
                        } catch (IOException e) {
                            throw new RuntimeException();
                        }
                    }).mapToLong(Long::parseLong)
                    .map(n -> solution(n, memo))
                    .forEach(System.out::println);
        }
    }

    public static long solution(long n, Map<Long, Long> memo) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        long sum = solution(n - 1, memo) + solution(n - 2, memo) + solution(n - 3, memo);
        memo.put(n, sum);

        return sum;
    }
}
