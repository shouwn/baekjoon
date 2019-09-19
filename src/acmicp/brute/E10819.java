package acmicp.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class E10819 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            br.readLine();

            int[] arr = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.out.println(solution(arr));
        }
    }

    private static int solution(int[] arr) {
        boolean[] visited = new boolean[arr.length];

        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            visited[i] = true;
            max = Math.max(max, search(arr, visited, arr[i]));
            visited[i] = false;
        }

        return max;
    }

    private static int search(int[] arr, boolean[] visited, int current) {
        int max = 0;

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                int diff = Math.abs(current - arr[i]);

                visited[i] = true;
                max = Math.max(max, search(arr, visited, arr[i]) + diff);
                visited[i] = false;
            }
        }

        return max;
    }
}
