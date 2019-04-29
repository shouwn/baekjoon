package acmicp.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Stream;

public class E2178 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[][] map = Stream.iterate(0, n -> n)
                    .limit(Integer.parseInt(br.readLine().split(" ")[0]))
                    .map(CheckedFunction.wrap(n -> br.readLine()))
                    .map(line -> Arrays.stream(line.split(""))
                            .mapToInt(Integer::parseInt)
                            .toArray())
                    .toArray(int[][]::new);

            System.out.println(solution(map));
        }
    }

    public static int solution(int[][] map) {
        return solution(map, new boolean[map.length][map[0].length]);
    }

    public static int solution(int[][] map, boolean[][] passed) {
        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(0, 0, 1));
        passed[0][0] = true;

        while (!queue.isEmpty()) {
            Move current = queue.poll();

            if (current.x == map.length - 1 && current.y == map[0].length - 1) {
                return current.depth;
            }

            addMoveIfPassable(queue, new Move(current.x + 1, current.y, current.depth + 1), map, passed);
            addMoveIfPassable(queue, new Move(current.x - 1, current.y, current.depth + 1), map, passed);
            addMoveIfPassable(queue, new Move(current.x, current.y + 1, current.depth + 1), map, passed);
            addMoveIfPassable(queue, new Move(current.x, current.y - 1, current.depth + 1), map, passed);
        }

        return 0;
    }

    private static void addMoveIfPassable(Queue<Move> queue, Move move, int[][] map, boolean[][] passed) {
        if (isPassable(move.x, move.y, map, passed)) {
            passed[move.x][move.y] = true;
            queue.add(move);
        }
    }

    private static boolean isPassable(int x, int y, int[][] map, boolean[][] passed) {
        if (x < 0 || x >= passed.length) {
            return false;
        }

        if (y < 0 || y >= passed[0].length) {
            return false;
        }

        if (map[x][y] == 0) {
            return false;
        }

        return !passed[x][y];
    }

    static class Move {
        int x, y, depth;

        Move(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
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
