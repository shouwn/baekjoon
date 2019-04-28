package acmicpc.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class E11052 {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());

            List<Integer> list = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());

            System.out.println(solution(list, N));
        }
    }

    public static int solution(List<Integer> list, int N){
        int[] max = new int[N + 1];

        for(int i = 0; i < N + 1; i++){
            for(int j = 1; j < N + 1; j++){
                int temp = list.get(j - 1);
                if(i + j < N + 1)
                    max[i + j] = Math.max(max[i + j], max[i] + temp);
            }
        }

        return max[N];
    }
}
