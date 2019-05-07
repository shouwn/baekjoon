package acmicp.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E2751 {

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
//        Stream.iterate(1, n -> n + 1).limit(1000000)
//                .forEach(System.out::println);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = toInt(br.readLine());

            Sorter sorter = new Sorter();

            for (int i = 0; i < N; i++) {
                sorter.add(toInt(br.readLine()));
            }

            System.out.println(sorter.sorted());
        }
    }

    static class Sorter {
        private boolean[] checker = new boolean[2000015];

        private static int BASE = 1000005;

        public void add(int n) {
            checker[n + BASE] = true;
        }

        public String sorted() {
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < checker.length; i++) {
                if (checker[i]) {
                    sb.append(i - BASE).append("\n");
                }
            }

            return sb.toString();
        }
    }
}
