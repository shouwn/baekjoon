package test.uc;

import java.util.HashMap;
import java.util.Map;

public class E3 {

    static final Map<String, String> REVERSE_MAP = new HashMap<>();

    static {
        for (char i = 'a'; i <= 'z'; i++) {
            REVERSE_MAP.put(String.valueOf(i), String.valueOf((char) ('z' - i + 'a')));
        }

        for (char i = 'A'; i <= 'Z'; i++) {
            REVERSE_MAP.put(String.valueOf(i), String.valueOf((char) ('Z' - i + 'A')));
        }
    }

    public String solution(String word) {

        StringBuilder sb = new StringBuilder();

        for (String s : word.split("")) {
            sb.append(REVERSE_MAP.getOrDefault(s, s));
        }
        return sb.toString();
    }
}
