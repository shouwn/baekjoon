package acmicp.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E2023 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(solution(Integer.parseInt(br.readLine())));
        }
    }

    private static String solution(int N) {
        List<String> result = new ArrayList<>();
        Queue<Number> queue = new LinkedList<>();

        for (int i = 2; i < 10; i++) {
            if (isPrime(i)) {
                queue.add(Number.NONE.add(i));
            }
        }

        while (!queue.isEmpty()) {
            Number number = queue.poll();
            if (number.digits < N) {
                for (int i = 0; i < 10; i++) {
                    Number newNumber = number.add(i);
                    if (isPrime(newNumber.value)) {
                        queue.add(newNumber);
                    }
                }
            } else {
                result.add(String.valueOf(number.value));
            }
        }

        Collections.sort(result);
        return String.join("\n", result);
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

    static class PrimeManager {

        private static boolean[] isNotPrime;

        PrimeManager(int max) {
            isNotPrime = new boolean[max + 1];
            isNotPrime[0] = true;
            isNotPrime[1] = true;

            int limit = (int) Math.ceil(Math.sqrt(max));

            for (int i = 2; i <= limit; i++) {
                for (int number = i * 2; number <= max; number += i) {
                    isNotPrime[number] = true;
                }
            }
        }

        boolean isPrime(int number) {
            return !isNotPrime[number];
        }
    }

    static class Number {
        static final Number NONE = new Number();

        int value;
        int digits;

        Number add(int value) {
            Number newNumber = new Number();
            newNumber.digits = this.digits + 1;
            newNumber.value = this.value * 10 + value;
            return newNumber;
        }
    }
}
