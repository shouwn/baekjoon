package acmicp.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E10815 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            br.readLine();
            Set<Integer> cards = Stream.of(br.readLine().split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toSet());

            br.readLine();

            String result = Stream.of(br.readLine().split(" "))
                    .map(Integer::valueOf)
                    .map(cards::contains)
                    .map(contain -> contain ? "1" : "0")
                    .collect(Collectors.joining(" "));

            System.out.println(result);
        }
    }
}
