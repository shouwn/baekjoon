package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Stream;

public class Test0_7 {

	static final int ADD = 0;
	static final int FIND = 1;
	static final int DELETE = 2;

	static final int ARRAY = 0;
	static final int LINKED = 1;

	static final int SIZE = 10000;

	public static void main(String[] args) throws InterruptedException {
		ArrayList<Integer> arrayList = new ArrayList<>();
		LinkedList<Integer> linkedList = new LinkedList<>();

		long eachTestTime;
		
		Thread arr, link;

		long[][][] testTime = new long[2][3][10];

		Random random = new Random();

		arr = new Thread( () -> Stream.iterate(0, n -> n+1).limit(10).forEach(
				(time) -> {
					testTime[ARRAY][ADD][time] = System.currentTimeMillis();
					Stream.iterate(0, n -> n+1).limit(SIZE).
						forEach((j) -> arrayList.add(j));
					testTime[ARRAY][ADD][time] -= System.currentTimeMillis();
				}));

		link = new Thread( () -> Stream.iterate(0, n -> n+1).limit(10).forEach(
				(time) -> {
					testTime[LINKED][ADD][time] = System.currentTimeMillis();
					Stream.iterate(0, n -> n+1).limit(SIZE)
						.forEach((j) -> linkedList.add(j));
					testTime[LINKED][ADD][time] -= System.currentTimeMillis();
				}));
		
		arr.start(); link.start();
		eachTestTime = System.currentTimeMillis();
		arr.join(); link.join();
		eachTestTime -= System.currentTimeMillis();
		System.out.println(String.format("%6s TEST OVER %7dms", "ADD", -eachTestTime));

		arr = new Thread( () -> Stream.iterate(0, n -> n+1).limit(10).forEach(
				(time) -> {
					testTime[ARRAY][FIND][time] = System.currentTimeMillis();
					Stream.generate(() -> random.nextInt(SIZE)).limit(SIZE)
						.forEach((j) -> arrayList.get(j));
					testTime[ARRAY][FIND][time] -= System.currentTimeMillis();
				}));

		link = new Thread( () -> Stream.iterate(0, n -> n+1).limit(10).forEach(
				(time) -> {
					testTime[LINKED][FIND][time] = System.currentTimeMillis();
					Stream.generate(() -> random.nextInt(SIZE)).limit(SIZE)
						.forEach((j) -> linkedList.get(j));
					testTime[LINKED][FIND][time] -= System.currentTimeMillis();
				}));
		
		arr.start(); link.start();
		eachTestTime = System.currentTimeMillis();
		arr.join(); link.join();
		eachTestTime -= System.currentTimeMillis();
		System.out.println(String.format("%6s TEST OVER %7dms", "FIND", -eachTestTime));
		
		arr = new Thread( () -> Stream.iterate(0, n -> n+1).limit(10).forEach(
				(time) -> {
					testTime[ARRAY][DELETE][time] = System.currentTimeMillis();
					Stream.generate(() -> random.nextInt(arrayList.size())).limit(SIZE)
						.forEach((j) -> arrayList.remove(j));
					testTime[ARRAY][DELETE][time] -= System.currentTimeMillis();
				}));

		link = new Thread( () -> Stream.iterate(0, n -> n+1).limit(10).forEach(
				(time) -> {
					testTime[LINKED][DELETE][time] = System.currentTimeMillis();
					Stream.generate(() -> random.nextInt(linkedList.size())).limit(SIZE)
						.forEach((j) -> linkedList.remove(j));
					testTime[LINKED][DELETE][time] -= System.currentTimeMillis();
				}));

		arr.start(); link.start();
		eachTestTime = System.currentTimeMillis();
		arr.join(); link.join();
		eachTestTime -= System.currentTimeMillis();
		System.out.println(String.format("%6s TEST OVER %7dms", "DELETE", -eachTestTime));
		
		
		System.out.println("\n\nTest SIZE: " + SIZE);
		
		int i = 0, j = 0;
		for(String method : new String[] {"ADD", "FIND", "DELETE"}) {
			j = 0;
			for(String type : new String[] {"ARRAY", "LINKED"})
				System.out.printf("%6s %6s: %dms\n", type, method, -getAverage(testTime[j++][i]));
			i++;
		}
	}

	public static long getAverage(long[] arr) {
		return Arrays.stream(arr)
				.reduce((pre, cur) -> pre + cur)
				.orElse(0) / arr.length;
	}
}
