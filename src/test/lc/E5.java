package test.lc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E5 {

    private static final int POSITION_MIN = 0, POSITION_MAX = 200000;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] position = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.out.println(solution(position));
        }
    }

    public static int solution(int[] position) {
        int cony = position[0];
        int brown = position[1];

        int movement = 0;

        // list 마지막 원소는 코니가 탈출한 위치
        // 즉 list.size() 가 코니가 탈출하게 되는 시간
        List<Integer> conyPosition = new ArrayList<>();

        while (checkInsideOfBounds(cony)) {
            cony += movement;
            movement += 1;

            conyPosition.add(cony);
        }

        return solution(conyPosition, brown);
    }

    public static int solution(List<Integer> conyPosition, int brownPosition) {

        Deque<Brown> queue = new LinkedList<>();

        queue.add(new Brown(brownPosition, 0));

        while (!queue.isEmpty()) {
            Brown brown = queue.poll();

            if (brown.second >= conyPosition.size()) {
                return -1;
            }

            if (conyPosition.get(brown.second) == brown.position) {
                return brown.second;
            }

            if (checkInsideOfBounds(brown.position - 1)) {
                queue.add(new Brown(brown.position - 1, brown.second + 1));
            }

            if (checkInsideOfBounds(brown.position + 1)) {
                queue.add(new Brown(brown.position + 1, brown.second + 1));
            }

            if (checkInsideOfBounds(brown.position * 2)) {
                queue.add(new Brown(brown.position * 2, brown.second + 1));
            }
        }

        return -1;
    }

    private static boolean checkInsideOfBounds(int position) {
        return position >= POSITION_MIN && position <= POSITION_MAX;
    }

    private static class Brown {
        int position;
        int second;

        public Brown(int position, int second) {
            this.position = position;
            this.second = second;
        }
    }
}
