package acmicpc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class E3015 {

	public static void main(String[] args) throws IOException {
		long time = System.currentTimeMillis();
		try(BufferedReader reader = new BufferedReader(
				new FileReader("F:\\Desktop\\test_data\\patrik\\patrik.in.8"))){

			int max = Integer.valueOf(reader.readLine());

			long count = 0;
			MyStack stack = new MyStack();
			stack.push(Integer.valueOf(reader.readLine()));
			int index, input;
			for(int i = 1; i < max; i++) {
				input = Integer.valueOf(reader.readLine());
				if(stack.peek() <= input) {

					index = findIndexOfAbove(input, stack.arr, 0, stack.size() - 1);
					count += stack.size() - index;

					while(!stack.isEmpty() && stack.peek() < input)
						stack.pop();
				}
				else 
					count++;

				stack.push(input);
			}
			System.out.println(count);
		}
		System.out.println(System.currentTimeMillis() - time);
	}

	public static int findIndexOfAbove(int s, int[] a, int start, int end) {

		if(start < end) {
			int middle = start + end;

			if(a[middle] > s) 
				return findIndexOfAbove(s, a, middle + 1, end);
			else 
				return findIndexOfAbove(s, a, start, middle - 1);
		}
		else
			return findIndexOfAbove(s, a, start);
	}

	public static int findIndexOfAbove(int s, int[] a, int index) {
		for(; index > 0; index--) {
			if(a[index] > s)
				return index;
		}

		return index;
	}
}

class MyStack{
	int[] arr = new int[500001];
	int rear;

	public int pop() {
		return arr[--rear];
	}

	public boolean isEmpty() {
		return 0 == rear;
	}

	public void push(int item) {
		arr[rear++] = item;
	}

	public int peek() {
		return arr[rear-1];
	}

	public int size() {
		return rear;
	}

}