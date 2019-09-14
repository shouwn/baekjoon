package acmicp.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E14501 {

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }

    public static int max(int... nums) {
        return Arrays.stream(nums).reduce(0, Math::max);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = toInt(br.readLine());

            // 0 day 1 score
            int[][] work = new int[2][N];

            for (int i = 0; i < N; i++) {
                String[] inputs = br.readLine().split(" ");

                work[0][i] = toInt(inputs[0]);
                work[0][i] = toInt(inputs[1]);
            }

            System.out.println(solution(work));
        }
    }

    public static int solution(int[][] work) {
        return 1;
    }
}
