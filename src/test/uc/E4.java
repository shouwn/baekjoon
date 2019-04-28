package test.uc;

public class E4 {

    public int solution(int[] pobi, int[] crong) {

        // 각각 1페이지씩 차이가 나야하기에 2가 아니면 예외상황
        if (pobi[1] - pobi[0] + crong[1] - crong[0] != 2) {
            return -1;
        }

        int pobiScore = score(pobi);
        int crongScore = score(crong);

        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        } else {
            return 0;
        }
    }

    public int score(int[] pages) {

        return Math.max(score(pages[0]), score(pages[1]));
    }

    private int score(int number) {
        int sum = 0;
        int multi = 1;

        while (number > 0) {
            sum += number % 10;
            multi *= number % 10;
            number /= 10;
        }

        return Math.max(sum, multi);
    }
}
