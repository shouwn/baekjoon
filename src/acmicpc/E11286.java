package acmicpc;

import java.util.PriorityQueue;
import java.util.Scanner;

public class E11286 {

	public static void main(String[] args) {
		int inputCount;
		Scanner scan = new Scanner(System.in);
		PriorityQueue<MyClass> queue = new PriorityQueue<>();
		StringBuilder s = new StringBuilder();

		inputCount = scan.nextInt();

		for(int i = 0; i < inputCount; i++) {
			int input = scan.nextInt();

			if(input == 0)
				s.append(queue.peek() != null ? queue.poll() : 0).append("\n");
			else
				queue.add(new MyClass(input));
		}

		System.out.println(s.toString());

	}

	static class MyClass implements Comparable<MyClass>{
		int item;

		public MyClass(int item) {
			this.item = item;
		}

		@Override
		public int compareTo(MyClass o) {
			int t1 = this.item >= 0 ? this.item : -this.item;
			int t2 = o.item >= 0 ? o.item : -o.item;
			int result = t1 - t2;

			return result != 0 ? result : this.item - o.item;
		}

		@Override
		public String toString() {
			return String.valueOf(item);
		}
	}

}
