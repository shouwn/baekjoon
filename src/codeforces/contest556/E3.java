package codeforces.contest556;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E3 {
    static PrimeChecker primeChecker = new PrimeChecker();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            br.readLine();

            int o = 0, t = 0;
            for (String s : br.readLine().split(" ")) {
                if ("1".equals(s)) {
                    o++;
                } else {
                    t++;
                }
            }

            System.out.println(solution(o, t, 0));
        }
    }

    /**
     *
     * @param o the number of one
     * @param t the number of two
     * @param sum before sum
     */
    public static int solution(int o, int t, int sum) {
        int isPrime = primeChecker.isPrime(sum) ? 1 : 0;

        int result = 0;

        if (o + t == 0) {
            return isPrime;
        }

        if (o > 0) { // use one
            result = solution(o - 1, t, sum + 1) + isPrime;
        }

        if (t > 0) { // use two
            result = Math.max(result, solution(o, t - 1, sum + 2) + isPrime);
        }

        return result;
    }

    static class PrimeChecker {
        private static boolean[] primes = new boolean[400010];

        public PrimeChecker() {
            Arrays.fill(primes, true);
            primes[0] = primes[1] = false;
            for (int i = 2; i < primes.length; i++) {
                if(primes[i]) {
                    for (int j = 2; i * j < primes.length; j++) {
                        primes[i * j] = false;
                    }
                }
            }
        }

        public boolean isPrime(int n) {
            return primes[n];
        }
    }
}
