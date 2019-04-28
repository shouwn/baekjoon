package acmicpc.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class E11053 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            br.readLine();
            List<Integer> list = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());

            System.out.println(solution2(list));
        }
    }

    private static int solution1(List<Integer> input) {
        return solution1(input, 0, 0, 0);
    }

    private static int solution1(List<Integer> list, int index, int count, int pre) {
        if (index == list.size()) {
            return count;
        }

        if (pre < list.get(index)) {
            return solution1(list, index + 1, count + 1, list.get(index));
        } else {
            int resume = solution1(list, index + 1, count, pre);
            int stop = solution1(list, index + 1, 0, list.get(index));

            return Math.max(resume, stop);
        }
    }

    private static int solution2(List<Integer> list) {

        ArrayList<Integer> result = new ArrayList<>();
        result.add(list.get(0));

        for (Integer element : list) {
            Integer maxValue = result.get(result.size() - 1);

            if (maxValue < element) {
                result.add(element);
            } else {
                int index = Collections.binarySearch(result, element);

                if (index < 0) {
                    result.set(-index - 1, element);
                }
            }
        }

        return result.size();
    }
}
