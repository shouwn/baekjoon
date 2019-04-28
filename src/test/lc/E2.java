package test.lc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E2 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(solution(br.readLine()));
        }
    }

    public static String solution(String s) {
        Pattern elementPattern = Pattern.compile("[A-Z][a-z]?");
        Pattern numberPattern = Pattern.compile("10|[1-9]");

        Matcher elementMatcher = elementPattern.matcher(s);
        Matcher numberMatcher = numberPattern.matcher(s);

        StringBuilder result = new StringBuilder();

        while (elementMatcher.find()) {
            if (numberMatcher.find()) {
                result.append(elementMatcher.group());

                String number = numberMatcher.group();
                if (!number.equals("1")) {
                    result.append(number);
                }
            } else {
                return "error";
            }
        }

        if (elementMatcher.find()) {
            return "error";
        }

        return result.toString();
    }
}
