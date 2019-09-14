package acmicp.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class E11656 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s = br.readLine();

            List<String> suffixes = new ArrayList<>(s.length() - 2);

            for (int i = 0; i < s.length(); i++) {
                suffixes.add(s.substring(i));
            }

            Collections.sort(suffixes);

            String result = String.join("\n", suffixes);

            System.out.println(result);
        }
    }
}
