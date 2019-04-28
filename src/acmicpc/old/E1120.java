package acmicpc.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class E1120 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = reader.readLine().split(" ");
		
		PriorityQueue<MyClass> queue = new PriorityQueue<>();
		
		String a = inputs[0], b = inputs[1];
		inputs = null;
		
		for(int i = 0, j = a.length(); j <= b.length(); i++, j++) {
			int count = 0;
			
			for(int k  = 0; k < a.length(); k++) {
				if(a.charAt(k) != b.charAt(k + i))
					count++;
			}
			
			queue.add(new MyClass(i, count));
		}

		System.out.println(queue.poll().diff);
		
	}
	
	static class MyClass implements Comparable<MyClass>{
		int index;
		int diff;
		
		public MyClass(int index, int diff) {
			this.index = index;
			this.diff = diff;
		}
		
		@Override
		public int compareTo(MyClass o) {
			
			return this.diff - o.diff;
		}

		@Override
		public String toString() {
			return "MyClass [index=" + index + ", diff=" + diff + "]";
		}
		
		
	}

}
