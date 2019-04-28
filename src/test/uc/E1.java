package test.uc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E1 {

    static final int[] COIN = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int money = Integer.parseInt(br.readLine());


        }
    }

    public int[] solution(int money) {
        int[] coins = new int[COIN.length];

        for (int i = 0; i < coins.length; i++) {
            int n = money / COIN[i];

            if (n > 0) {
                coins[i] = n;
                money -= n * COIN[i];
            }
        }
        return coins;
    }
}
