package acmicp.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E6588 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            for (String input = br.readLine(); !input.equals("0"); input = br.readLine()) {
                sb.append(solution(Integer.parseInt(input))).append("\n");
            }

            System.out.println(sb.toString());
        }
    }

    private static String solution(int number) {
        int limit = number / 2;

        for (int i = 2; i <= limit; i++) {
            if (isPrime(i) && isPrime(number - i)
                    && isOdd(i) && isOdd(number - i)) {
                return String.format("%d = %d + %d", number, i, number - i);
            }
        }

        return "Goldbach's conjecture is wrong.";
    }

    private static boolean isPrime(int number) {
        if (number == 2) {
            return true;
        }

        int limit = (int) Math.ceil(Math.sqrt(number));

        for (int i = 2; i <= limit; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
