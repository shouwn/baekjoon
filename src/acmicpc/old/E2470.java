package acmicpc.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E2470 {
	
	static class Solution {
		private int[] answer = new int[2];
		private int min = Integer.MAX_VALUE;
		
		public int[] getAnswer() {
			Arrays.sort(answer);
			return this.answer;
		}
		
		public void solve(int[] arr) {
			Arrays.sort(arr);
			int lenght = arr.length;
			for(int i = 0; i < lenght; i++)
				this.updateMin(arr, i);
		}
		
		public void updateMin(int[] arr, int index) {
			int idx = search(arr, index, - arr[index]); // 반대 되는 값 중 다음으로 큰 값을 찾음

			if(idx != arr.length && idx != index) // element 가 가장 큰 값일 경우를 위한 if문
				this.updateMin(arr[idx], arr[index]);
			
			if(idx != 0 && idx - 1 != index) // element 가 가장 작은 값일 경우를 위한 if문 2개만 있을 경우 왼쪽
				this.updateMin(arr[idx - 1], arr[index]);
		}
		
		private void updateMin(int e1, int e2) {
			
			int diffAbs = Math.abs(e1 + e2);
			if(Integer.compare(this.min, diffAbs) > 0) {
				this.min = diffAbs;
				this.answer[0] = e1;
				this.answer[1] = e2;
			}
		}
		
		//return index
		private static int search(int[] arr, int index, int element) {
			return search(arr, index, arr.length - 1, element);
		}
		
		private static int search(int[] arr, int start, int end, int element) {
			if(start > end)
				return start; // 해당 값이 없으면 바로 다음 큰 값의 위치를 리턴
			
			int middle = (start + end) / 2;
			int temp = arr[middle];
			
			if(temp == element)
				return middle;
			else if(temp < element)
				return search(arr, middle + 1, end, element);
			else
				return search(arr, start, middle - 1, element);
		}
	}
	
	public static void main(String[] args) throws IOException {
		try(BufferedReader scan = new BufferedReader(new InputStreamReader(System.in))) {

			int size = Integer.valueOf(scan.readLine());
			
			int[] arr = new int[size];
			String[] input = scan.readLine().split(" ");
			
			for(int i = 0; i < size; i++)
				arr[i] = Integer.valueOf(input[i]);
			
			Solution solution = new Solution();
			solution.solve(arr);
			
			int[] answer = solution.getAnswer();
			
			System.out.println(answer[0] + " " +  answer[1]);
		}
	}
}
