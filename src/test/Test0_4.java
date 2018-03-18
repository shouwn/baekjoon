package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test0_4 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.valueOf(reader.readLine());
		String[] inputs = reader.readLine().split(" ");
		reader.close();

		if(count <= 2) {
			System.out.println(count);
			return;
		}
		
		int[] window = new int[3];
		int result = count;

		window[0] = Integer.valueOf(inputs[0]);
		window[1] = Integer.valueOf(inputs[1]);
		window[2] = Integer.valueOf(inputs[2]);

		for(int i = 3; i < count; i++) {
			int input = Integer.valueOf(inputs[i]);

			if((window[0] - window[1]) * (window[1] - window [2]) >= 0) {
				window[1] = window[2];
				window[2] = input;
				result--;
			}
			else {
				window[0] = window[1];
				window[1] = window[2];
				window[2] = input;
			}

		}
		
		if((window[0] - window[1]) * (window[1] - window [2]) >= 0)
			result--;

		System.out.println(result);
	}

}
