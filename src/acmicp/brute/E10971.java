package acmicp.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class E10971 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][];

            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().replaceAll(" {2,}", " ").split(" ");
                map[i] = Stream.of(line)
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            System.out.println(solution(map));
        }
    }

    private static long solution(int[][] map) {
        boolean[] visited = new boolean[map.length];
        long min = Integer.MAX_VALUE;

        for (int startNode = 0; startNode < map.length; startNode++) {
            visited[startNode] = true;
            for (int i = 0; i < map.length; i++) {
                if (startNode != i && map[startNode][i] != 0) {
                    visited[i] = true;
                    min = Math.min(min, search(map, visited, startNode, i) + map[startNode][i]);
                    visited[i] = false;
                }
            }
            visited[startNode] = false;
        }

        return min;
    }

    private static long search(int[][] map, boolean[] visited, int start, int current) {
        long min = Integer.MAX_VALUE;
        boolean isAllVisited = true;

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                isAllVisited = false;

                if (map[current][i] != 0) {
                    visited[i] = true;
                    min = Math.min(min, search(map, visited, start, i) + map[current][i]);
                    visited[i] = false;
                }
            }
        }

        if (isAllVisited && map[current][start] != 0) {
            min = map[current][start];
        }

        return min;
    }
}
