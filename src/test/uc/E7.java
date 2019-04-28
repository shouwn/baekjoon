package test.uc;

import java.util.ArrayList;
import java.util.List;

public class E7 {

    private static final String REGEX;

    static {
        List<String> doubleChar = new ArrayList<>();

        for (char i = 'a'; i <= 'z'; i++) {
            String s = String.valueOf(i);
            doubleChar.add(s + s);
        }

        REGEX = String.join("|", doubleChar);
    }

    public String solution(String cryptogram) {
        String pre = cryptogram;
        String post = cryptogram.replaceAll(REGEX, "");

        while (pre.length() != post.length()) {
            pre = post;
            post = post.replaceAll(REGEX, "");
        }

        return post;
    }
}
