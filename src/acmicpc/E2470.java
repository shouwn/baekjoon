package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class E2470 {
	
	static class Solution {
		private int[] answer = new int[2];
		private int min = Integer.MAX_VALUE;
		
		public int[] getAnswer() {
			return this.answer;
		}
		
		public void solve(int[] arr) {
			Arrays.sort(arr);
			
			for(int e : arr)
				this.updateMin(arr, e);
		}
		
		public void updateMin(int[] arr, int element) {
			System.out.println(-element);
			int index = search(arr, -element); // 반대 되는 값 중 다음으로 큰 값을 찾음
			System.out.println("end");
			System.out.println(index);

			if(index != arr.length) // element 가 가장 큰 값일 경우를 위한 if문
				this.updateMin(arr[index], element);
			
			if(index != 0) // element 가 가장 작은 값일 경우를 위한 if문
				this.updateMin(arr[index - 1], element);
		}
		
		private void updateMin(int e1, int e2) {
			
			int diffAbs = Math.abs(e1 + e2);
			if(Integer.compare(this.min, diffAbs) > 0) {
				this.min = diffAbs;
				this.answer[0] = e1;
				this.answer[1] = e2;

				System.out.println(answer[0] + " " +  answer[1]);
			}
		}
		
		//return index
		private static int search(int[] arr, int element) {
			System.out.println("start");
			return search(arr, 0, arr.length - 1, element);
		}
		
		private static int search(int[] arr, int start, int end, int element) {
			System.out.println(start + " " + end);
			if(start > end)
				return start; // 해당 값이 없으면 바로 다음 큰 값의 위치를 리턴
			
			int middle = (start + end) / 2;
			int temp = arr[middle];
			
			System.out.println("temp: " + temp);
			
			if(temp == element)
				return middle;
			else if(temp > element)
				return search(arr, middle + 1, end, element);
			else
				return search(arr, start, middle - 1, element);
		}
	}
	
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int size = scan.nextInt();
			
			int[] arr = new int[size];
			for(int i = 0; i < size; i++)
				arr[i] = scan.nextInt();
			
			Solution solution = new Solution();
			solution.solve(arr);
			
			int[] answer = solution.getAnswer();
			
			System.out.println(answer[0] + " " +  answer[1]);
		}
	}

}
