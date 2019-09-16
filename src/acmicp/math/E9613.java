package acmicp.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class E9613 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < count; i++) {
                int[] arr = Stream.of(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                sb.append(solution(arr)).append("\n");
            }

            System.out.println(sb.toString());
        }
    }

    private static long solution(int[] arr) {
        long sum = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum += gcd(arr[i], arr[j]);
            }
        }

        return sum;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
