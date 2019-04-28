package test.generic;

public class GenericTest implements Style{

    public static void main(String[] args) {
        GenericTest t1 = new GenericTest();

        System.out.println(t1 == t1.let());
    }
}
