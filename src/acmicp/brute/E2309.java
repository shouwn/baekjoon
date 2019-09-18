package acmicp.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E2309 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] heights = br.lines().limit(9)
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();

            solution(heights);
        }
    }

    private static void solution(int[] heights) {
        for (int i = heights.length - 1; i >= 0 && !solution(heights, i, 7, 100); i--) {
        }
    }

    private static boolean solution(int[] heights, int index, int count, int remain) {
        if (index < 0 || index >= heights.length) {
            return false;
        }

        int r = remain - heights[index];

        if (r == 0) {
            if (count == 1) {
                System.out.println(heights[index]);
                return true;
            } else {
                return false;
            }
        } else if (r < 0) {
            return false;
        }

        for (int i = index - 1; i >= 0; i--) {
            if (solution(heights, i, count - 1, r)) {
                System.out.println(heights[index]);
                return true;
            }
        }

        return false;
    }
}
