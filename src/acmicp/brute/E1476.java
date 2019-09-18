package acmicp.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E1476 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = br.readLine().split(" ");

            System.out.println(solution(toInt(inputs[0]), toInt(inputs[1]), toInt(inputs[2])));
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }

    private static int solution(int E, int S, int M) {
        int result = 1;

        while (!(toE(result) == E && toS(result) == S && toM(result) == M)) {
            result++;
        }

        return result;
    }

    private static int toE(int number) {
        int result = number % 15;
        return result == 0 ? 15 : result;
    }

    private static int toS(int number) {
        int result = number % 28;
        return result == 0 ? 28 : result;
    }

    private static int toM(int number) {
        int result = number % 19;
        return result == 0 ? 19 : result;
    }
}
