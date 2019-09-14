package acmicp.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class E2167 {
    private static int toInt(String s) {
        return Integer.parseInt(s);
    }

    public static int max(int... nums) {
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(num, max);
        }

        return max;
    }

    public static String[] readAndSplit(BufferedReader reader, String regex) {
        try {
            return reader.readLine().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new int[]{1, 2}.equals(new int[]{1, 2}));

//
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//            String[] line = br.readLine().split(" ");
//
//            int N = toInt(line[0]), M = toInt(line[1]);
//
//            int[][] map = new int[N][M];
//
//            for (int i = 0; i < N; i++) {
//                line = readAndSplit(br, " ");
//
//                for (int j = 0; j < M; j++) {
//                    map[i][j] = toInt(line[j]);
//                }
//            }
//
//        }
    }

    public static int solution(int[][] map, int[][] target) {
        return 1;
    }
}
