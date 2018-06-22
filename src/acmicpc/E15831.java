package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E15831 {

	static final char B = 0;
	static final char W = 1;

	public static void main(String[] args) throws IOException {

		StringBuilder line;
		int maxB;
		int minW;

		try(BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))){
			String[] input = rd.readLine().split(" ");
			maxB = Integer.valueOf(input[1]);
			minW = Integer.valueOf(input[2]);
			line = new StringBuilder(rd.readLine()).append(" ");
		}

		System.out.println(solution(line.toString(), maxB, minW));
	}

	public static int solution(String line, int maxB, int minW) {

		int lineLen = line.length() - 1;

		int f = 0, r = 0, max = 0;
		int[] count = new int[2];
		
		checkR(line, count, r);

		while(r < lineLen) {
			if(f > r) {
				checkR(line, count, ++r);
			}
			else {
				if(count[B] <= maxB) {
					if(count[W] >= minW)
						max = Math.max(max, r - f + 1);
					
					checkR(line, count, ++r);
				}
				else {
					checkF(line, count, f++);
				}
			}
		}
		return max;
	}
	
	public static void checkR(String line, int[] count, int r) {
		if(line.charAt(r) == 'B')
			count[B]++;
		else
			count[W]++;
	}
	
	public static void checkF(String line, int[] count, int f) {
		if(line.charAt(f) == 'B')
			count[B]--;
		else
			count[W]--;
	}

}
