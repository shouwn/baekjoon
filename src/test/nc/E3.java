package test.nc;

public class E3 {
    public static void main(String[] args) {
        System.out.println(new E3().solution(new int[] {-5, -5, -5, -42, 6, 12}));
    }

    public int solution(int[] T) {
        int winter = 1; // 겨울 날짜
        int summer = 0; // 여름 날짜

        int winterMax = T[0];
        int summerMax = Integer.MIN_VALUE;

        for (int i = 1, size = T.length; i < size; i++) {
            int temp = T[i];

            if (temp > winterMax) {
                summer++;
                summerMax = Math.max(summerMax, temp);
            } else {
                winter++;

                if (summer > 0) {
                    winterMax = summerMax;
                    winter += summer;
                    summer = 0;
                }
            }
        }

        return winter;
    }
}
