package acmicp.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class E10974 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(solution(Integer.parseInt(br.readLine())));
        }
    }

    private static String solution(int N) {
        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        StringBuilder sb = new StringBuilder();
        search(sb, new ArrayList<>(N + 1), new boolean[N], arr);

        return sb.toString();
    }

    private static void search(StringBuilder result, List<String> list, boolean[] visit, Integer[] arr) {
        boolean allVisit = true;

        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                allVisit = false;

                visit[i] = true;
                list.add(String.valueOf(arr[i]));

                search(result, list, visit, arr);

                visit[i] = false;
                list.remove(list.size() - 1);
            }
        }

        if (allVisit) {
            result.append(String.join(" ", list)).append("\n");
        }
    }
}
