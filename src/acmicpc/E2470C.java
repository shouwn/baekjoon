package acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E2470C {

	static class Solution {
		private List<Integer> list;
		private int[] answer = new int[2];
		private int min = Integer.MAX_VALUE;

		public Solution(int size, int element) {
			list = new ArrayList<>(size);
			list.add(element); // 맨 처음 초기 에러 막기용
		}

		public int[] getAnswer() {
			Arrays.sort(answer);
			return answer;
		}

		public void addElement(int element) {
			int index = search(-element); // 반대 되는 값 중 다음으로 큰 값을 찾음
			System.out.println(index);

			if(index != list.size()) // element 가 가장 큰 값일 경우를 위한 if문
				this.updateMin(list.get(index), element);

			if(index != 0) {// element 가 가장 작은 값일 경우를 위한 if문
				this.updateMin(list.get(index - 1), element);
			}

			list.add(search(element), element); // 특성 값이 모두 다르기에 같은 값이 들어있는지 확인 하지 않음
		}

		private void updateMin(int e1, int e2) {
			System.out.println("start");
			System.out.println(e1 + " " +  e2);
			int diffAbs = Math.abs(e1 + e2);
			if(Integer.compare(min, diffAbs) > 0) {
				min = diffAbs;
				answer[0] = e1;
				answer[1] = e2;
				System.out.println(answer[0] + " " +  answer[1]);
			}
			System.out.println("end");
		}

		//return index
		private int search(int element) {
			return search(0, list.size() - 1, element);
		}

		private int search(int start, int end, int element) {
			if(start > end)
				return start; // 해당 값이 없으면 바로 다음 큰 값의 위치를 리턴

			int middle = (start + end) / 2;
			int temp = list.get(middle);

			if(temp == element)
				return middle;

			else if(temp < element)
				return search(middle + 1, end, element);
			else
				return search(start, middle - 1, element);
		}
	}

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int size = scan.nextInt();

			Solution solution = new Solution(size, scan.nextInt());

			for(int i = 0; i < size - 1; i++)
				solution.addElement(scan.nextInt());

			int[] answer = solution.getAnswer();

			System.out.println(answer[0] + " " +  answer[1]);
		}
	}

}