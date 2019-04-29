package codeforces.contest556;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E1 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int r = Integer.parseInt(br.readLine().split(" ")[2]);

            int[] s = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[] b = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.out.println(solution(s, b, r));
        }
    }

    public static int solution(int[] s, int[] b, int r) {
        int buyMin = Arrays.stream(s)
                .reduce(Integer.MAX_VALUE, Math::min);

        int sellMax = Arrays.stream(b)
                .reduce(Integer.MIN_VALUE, Math::max);

        if (buyMin >= sellMax) {
            return r;
        }

        return r + (sellMax - buyMin) * (r / buyMin);
    }
}
