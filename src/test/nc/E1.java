package test.nc;

import java.util.*;

public class E1 {
    private static int[] PIPS = new int[] {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) {
        System.out.println(new E1().solution(new int[] {1, 2, 3}));
    }

    public int solution(int[] A) {

        Queue<Dice> queue = new LinkedList<>();

        queue.add(new Dice(A, 0));

        while (!queue.isEmpty()) {
            Dice dice = queue.poll();

            if (dice.isSame()) {
                return dice.count;
            }

            queue.addAll(dice.rotate());
        }

        return 0;
    }

    private int sum(int[] a) {
        return Arrays.stream(a).reduce(0, Integer::sum);
    }

    static class Dice {
        int[] dice;
        int count;

        public Dice(int[] dice, int count) {
            this.dice = dice;
            this.count = count;
        }

        // 모두 같은 면인지 확인하는 메소드
        public boolean isSame() {
            int num = dice[0];

            for (int i : dice) {
                if (i != num) {
                    return false;
                }
            }

            return true;
        }

        public List<Dice> rotate() {
            List<Dice> result = new ArrayList<>();

            for (int i = 0, size = dice.length; i < size; i++) {
                for (int pip : this.sides(dice[i])) {
                    int[] arr = new int[this.dice.length];

                    arr[i] = pip;

                    System.arraycopy(this.dice, 0, arr, 0, dice.length);

                    result.add(new Dice(arr, this.count + 1));
                }
            }

            return result;
        }

        // 해당 눈의 주위 숫자를 반환하는 메소드
        private int[] sides(int pip) {
            return Arrays.stream(PIPS)
                    .filter(n -> pip + n != 7)
                    .toArray();
        }
    }
}
