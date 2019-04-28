package acmicpc.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class E2579 {
	
	static Map<Integer, Integer[]> memo = new HashMap<>();
	static final int BEFORE_ONE_STEP = 0; // 계단 하나만 올라갔을 때
	static final int BEFORE_TWO_STEP = 1; // 계단 두 개 올라갔을 때
	static final int NONE = -1000000;
	
	public static void main(String[] args) throws IOException {
		int[] arr = input();
		
		for(int i = 0; i < arr.length; i++)
			memo.put(i, new Integer[] {NONE, NONE});
		
		System.out.println(searchMax(arr, arr.length - 1));
	}
	
	public static int searchMax(int[] arr, int step) {
		
		return searchMax(arr, step, BEFORE_TWO_STEP);
	}
	
	public static int searchMax(int[] arr, int step, int type) {
		
		if(step < 0)
			return 0;
		
		if(memo.get(step)[type] != NONE)
			return memo.get(step)[type];
		
		if(type == BEFORE_ONE_STEP) {// 한 계단 아래에서 찾음
			int max = arr[step] + searchMax(arr, step - 2, BEFORE_TWO_STEP);
			
			memo.get(step)[BEFORE_ONE_STEP] = max;
			return max;
		}
		else { // 두 계단 아래에서 찾음
			int max = searchMax(arr, step - 1, BEFORE_ONE_STEP);
			int semi = searchMax(arr, step - 2, BEFORE_TWO_STEP);
			
			if(max < semi)
				max = semi;
			
			max += arr[step];
			memo.get(step)[BEFORE_TWO_STEP] = max;
			
			return max;
		}
	}
	
	public static int[] input() throws NumberFormatException, IOException {
		int[] arr;
		
		try(MyScanner scan = new MyScanner()){
			arr = new int[scan.nextInt()];
			
			for(int i = 0; i < arr.length; i++)
				arr[i] = scan.nextInt();
		}
		
		return arr;
	}


}

class MyScanner extends BufferedReader{

	public MyScanner() {
		super(new InputStreamReader(System.in));
	}
	
	public int nextInt() throws NumberFormatException, IOException {
		return Integer.valueOf(readLine());
	}
}