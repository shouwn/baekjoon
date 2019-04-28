package test.uc;

import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.MINUTES;
import static java.time.temporal.ChronoUnit.SECONDS;

public class Test {

    public static void main(String[] args) {
        LocalTime l1 = LocalTime.parse("02:54:40");
        LocalTime l2 = LocalTime.parse("02:53:41");
        System.out.println(l1.until(l2, MINUTES));
        System.out.println(SECONDS.between(l1, l2));
    }
}
