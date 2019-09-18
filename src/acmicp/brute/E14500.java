package acmicp.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E14500 {

    private static final int[][] PATH = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static final int[][][] EXCEPTION_ONE = {
            {{-1, 0}, {0, -1}, {1, 0}},
            {{0, -1}, {1, 0}, {0, 1}},
            {{-1, 0}, {0, 1}, {1, 0}},
            {{0, -1}, {-1, 0}, {0, 1}}
    };

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs;
            inputs = br.readLine().split(" ");

            int N = Integer.parseInt(inputs[0]), M = Integer.parseInt(inputs[1]);
            int[][] map = new int[N][M];

            for (int x = 0; x < N; x++) {
                inputs = br.readLine().split(" ");

                for (int y = 0; y < M; y++) {
                    map[x][y] = Integer.parseInt(inputs[y]);
                }
            }

            System.out.println(getMax(map));
        }
    }

    private static int getMax(int[][] map) {
        int max = Integer.MIN_VALUE;

        boolean[][] visited = new boolean[map.length][map[0].length];

        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                max = Math.max(max, search(map, visited, x, y, 1));
                max = Math.max(max, exceptionOne(map, x, y));
            }
        }

        return max;
    }

    private static int exceptionOne(int[][] map, int x, int y) {
        if (isOutRange(map, x, y)) {
            return Integer.MIN_VALUE;
        }

        int max = Integer.MIN_VALUE;

        for (int[][] kinds : EXCEPTION_ONE) {
            int sum = map[x][y];
            boolean possible = true;

            for (int[] position : kinds) {
                int sx = x + position[0];
                int sy = y + position[1];

                if (isOutRange(map, sx, sy)) {
                    possible = false;
                    break;
                }

                sum += map[sx][sy];
            }

            if (possible) {
                max = Math.max(max, sum);
            }
        }

        return max;
    }

    private static int search(int[][] map, boolean[][] visited, int x, int y, int depth) {
        if (isOutRange(map, x, y) || visited[x][y]) {
            return Integer.MIN_VALUE;
        }

        if (depth == 4) {
            return map[x][y];
        } else {
            visited[x][y] = true;
            int max = Integer.MIN_VALUE;

            for (int[] position : PATH) {
                int sx = x + position[0];
                int sy = y + position[1];

                max = Math.max(max, search(map, visited, sx, sy, depth + 1));
            }

            visited[x][y] = false;
            return max + map[x][y];
        }
    }

    private static boolean isOutRange(int[][] map, int x, int y) {
        if (x < 0 || x >= map.length) {
            return true;
        }

        if (y < 0 || y >= map[0].length) {
            return true;
        }

        return false;
    }
}

