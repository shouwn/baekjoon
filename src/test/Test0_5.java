package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test0_5 {
	
	public static void main(String[] args) {
		List<Integer> test1 = new ArrayList<>();
		List<Integer> test2 = new ArrayList<>();
		
		test1.add(9);
		test1.add(20);
		test1.add(28);
		test1.add(18);
		test1.add(11);
		
		test2.add(30);
		test2.add(1);
		test2.add(21);
		test2.add(17);
		test2.add(28);
		
		System.out.println(Arrays.toString(solution(test1, test2)));
	}
	
	public static String[] solution(List<Integer> list1, List<Integer> list2) {
		StringBuilder str = new StringBuilder("\"");
		
		String[] result = new String[list1.size()];
		
		for(int i = 0; i < list1.size(); i++) {
			int temp = list1.get(i) | list2.get(i);
			
			for(int j = 0; j < list1.size(); j++) {
				int bit = temp & 1;
				temp >>>= 1;
			
				str.append(bit == 1 ? "#" : " ");
			}
			
			result[i] = str.append("\"").reverse().toString();
			str = new StringBuilder("\"");
		}
		
		return result;
	}
}
