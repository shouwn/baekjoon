package acmicpc.old;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 이 문제는 풀지 마세요.
 */
public class E11003 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int len, windowSize;
		int[] arr;

		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		len = Integer.parseInt(st.nextToken());
		windowSize = Integer.parseInt(st.nextToken());
		arr = new int[len];
		
		st = new StringTokenizer(reader.readLine());
		
		for(int i = 0; i < len; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] result = new int[len];

		Deque<Integer> deque = new ArrayDeque<>();

		for(int i = 0; i < len; i++){

			while(!deque.isEmpty() && deque.peekFirst() <= i - windowSize)
				deque.removeFirst();

			while(!deque.isEmpty() && arr[deque.peekLast()] >= arr[i])
				deque.removeLast();

			deque.offer(i);

			result[i] = arr[deque.peekFirst()];
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < len; i++) {
			bw.write(result[i] + " ");
		}
		bw.flush();
		bw.close();
	}
}