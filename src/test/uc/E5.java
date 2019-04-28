package test.uc;

public class E5 {

    public int solution(int number) {
        int sum = 0;

        for (int i = 1; i <= number; i++) {
            sum += clapCount(i);
        }

        return sum;
    }

    private int clapCount(int number) {
        int count = 0;

        while (number > 0) {
            if (clap(number % 10)) {
                count++;
            }

            number /= 10;
        }

        return count;
    }

    private boolean clap(int number) {
        return number == 3 || number == 6 || number == 9;
    }
}
