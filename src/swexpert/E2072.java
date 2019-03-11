package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E2072 {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0, count = Integer.parseInt(br.readLine()); i < count; i++) {
                int result = Arrays.stream(br.readLine().split(" "))
                        .map(Integer::parseInt)
                        .filter(num -> num % 2 != 0)
                        .reduce((num1, num2) -> num1 + num2).orElse(0);

                System.out.println("#" + (i + 1) + " " + result);
            }
        }
    }
}
