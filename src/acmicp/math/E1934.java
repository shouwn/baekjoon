package acmicp.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E1934 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < count; i++) {
                String[] inputs = br.readLine().split(" ");

                sb.append(solution(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]))).append("\n");
            }

            System.out.println(sb.toString());
        }
    }

    private static String solution(int a, int b) {
        int gcd;

        if (a > b) {
            gcd = gcd(a, b);
        } else {
            gcd = gcd(b, a);
        }

        return String.valueOf(a * b / gcd);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
