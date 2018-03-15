package test;

import java.math.BigInteger;
import java.util.Scanner;


public class Test0_3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        BigInteger result = new BigInteger("1");
        BigInteger cut = new BigInteger("1000000000");
        
        for(long i = 1; i <= count; i++) {
        	result = result.multiply(new BigInteger(String.valueOf(i)));
        	while(result.mod(BigInteger.TEN).equals(BigInteger.ZERO))
        		result = result.divide(BigInteger.TEN);
        	
        	result = result.mod(cut);
        }
        
        System.out.println(result);
        
    }
    
}