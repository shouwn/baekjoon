package acmicpc.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E1149 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            List<House> houses = Stream.iterate(0, n -> n).limit(Integer.parseInt(br.readLine()))
                    .map(n -> {
                        try {
                            return br.readLine();
                        } catch (IOException e) {
                            throw new RuntimeException();
                        }
                    }).map(s -> s.split(" "))
                    .map(arr -> new House(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2])))
                    .collect(Collectors.toList());

            System.out.println(solution(houses));
        }
    }

    public static int solution(List<House> houses) {
        Map<Key, Integer> memo = new HashMap<>();

        return min(solution(houses, 0, "red", memo),
                solution(houses, 0, "green", memo),
                solution(houses, 0, "blue", memo));
    }

    private static int solution(List<House> houses, int index, String beforeColor, Map<Key, Integer> memo) {
        Key key = new Key(beforeColor, index);

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (index == houses.size()) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        House house = houses.get(index);

        if (!"red".equals(beforeColor)) {
            int value = house.red;
            min = min(min, value + solution(houses, index + 1, "red", memo));
        }

        if (!"blue".equals(beforeColor)) {
            int value = house.blue;
            min = min(min, value + solution(houses, index + 1, "blue", memo));
        }

        if (!"green".equals(beforeColor)) {
            int value = house.green;
            min = min(min, value + solution(houses, index + 1, "green", memo));
        }

        memo.put(key, min);

        return min;
    }

    private static int min(int... integers) {
        return Arrays.stream(integers)
                .reduce(integers[0], Math::min);
    }

    private static class House {
        int red, green, blue;

        House(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }
    }

    private static class Key {
        String beforeColor;
        int index;

        public Key(String beforeColor, int index) {
            this.beforeColor = beforeColor;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Objects.equals(beforeColor, key.beforeColor) &&
                    Objects.equals(index, key.index);
        }

        @Override
        public int hashCode() {
            return Objects.hash(beforeColor, index);
        }
    }
}
