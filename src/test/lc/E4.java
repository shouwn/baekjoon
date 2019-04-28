package test.lc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class E4 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] building = Stream.iterate(0, n -> 0).limit(Integer.parseInt(br.readLine()))
                    .mapToInt(n -> {
                        try {
                            return Integer.parseInt(br.readLine());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }).toArray();

            System.out.println(solution(building));
        }
    }

    public static int solution(int[] building) {
        int max = 0;

        for (int i = 0; i < building.length; i++) {
            int current = building[i];

            for (int j = i + 1; j < building.length; j++) {

                max = Math.max(max, j - i);

                if (building[j] >= current) {
                    break;
                }
            }
        }

        return max;
    }
}
