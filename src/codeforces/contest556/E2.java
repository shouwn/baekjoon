package codeforces.contest556;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class E2 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Counter counter = new Counter();

            int[][] map = Stream.iterate(0, x -> x).limit(Integer.parseInt(br.readLine()))
                    .map(CheckedFunction.wrap(x -> br.readLine()))
                    .map(s -> s.split(""))
                    .map(s -> Arrays.stream(s)
                            .mapToInt(t -> "#".equals(t) ? 1 : counter.countUpAndReturnZero())
                            .toArray())
                    .toArray(int[][]::new);

            System.out.println(solution(map, counter.count) ? "YES" : "NO");
        }
    }

    static class Counter {
        int count;

        int countUpAndReturnZero() {
            count++;
            return 0;
        }
    }

    public static boolean solution(int[][] map, int count) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (isSettable(i, j, map)) {
                    setTile(i, j, map);
                    count -= 5;
                }
            }
        }

        return count == 0;
    }

    private static boolean isSettable(int x, int y, int[][] map) {
        return isBlank(x, y, map)
                && isBlank(x - 1, y, map)
                && isBlank(x + 1, y, map)
                && isBlank(x, y - 1, map)
                && isBlank(x, y + 1, map);
    }

    private static void setTile(int x, int y, int[][] map) {
        map[x][y] = 1;
        map[x - 1][y] = 1;
        map[x + 1][y] = 1;
        map[x][y - 1] = 1;
        map[x][y + 1] = 1;
    }

    private static boolean isBlank(int x, int y, int[][] map) {
        if (isInbounds(x, y, map)) {
            return map[x][y] == 0;
        }

        return false;
    }

    private static boolean isInbounds(int x, int y, int[][] map) {
        if (x < 0 || x >= map.length) {
            return false;
        }

        return y >= 0 && y < map[0].length;
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
