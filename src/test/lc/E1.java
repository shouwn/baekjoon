package test.lc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class E1 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(solution2(Integer.parseInt(br.readLine())));
        }
    }

    public static int solution1(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }

        int middle = list.size() / 2;

        if (list.size() % 2 == 0) {
            return list.get(middle) - list.get(middle - 1);
        } else {
            return 0;
        }
    }

    private static int solution2(int n) {
        double sqrtN = Math.sqrt(n);
        int f = (int) Math.floor(sqrtN), r = (int) Math.ceil(sqrtN);

        while (n % f != 0) {
            f--;
        }

        while (n % r != 0) {
            r++;
        }

        return r - f;
    }
}
