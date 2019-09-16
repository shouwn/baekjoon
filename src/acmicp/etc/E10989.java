package acmicp.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E10989 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(br.readLine());

            int[] counting = new int[10001];

            for (int i = 0; i < count; i++) {
                int n = Integer.parseInt(br.readLine());
                counting[n]++;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 10001; i++) {
                if (counting[i] != 0) {
                    for (int j = 0; j < counting[i]; j++) {
                        sb.append(i).append("\n");
                    }
                }
            }

            System.out.println(sb.toString());
        }
    }
}
