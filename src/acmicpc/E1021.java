package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E1021 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = reader.readLine().split(" ");

		int size = Integer.valueOf(inputs[0]);
		int wantSize = Integer.valueOf(inputs[1]);

		inputs = reader.readLine().split(" ");

		int[] want = new int[wantSize];
		
		int current = 0;

		int count = 0;
		
		for(int i = 0; i < wantSize; i++)
			want[i] = Integer.valueOf(inputs[i]) - 1;

		for(int i = 0; i < wantSize; i++) {
			int target = want[i];
			
			for(int j = i; j < wantSize; j++)
				if(want[i] < want[j])
					want[j] -= 1;
			
			int temp = current;

			int right = 0, left = 0;

			while(temp != target) {
				temp = (temp + 1) % size;
				right++;
			}

			temp = current;
			while(temp != target) {
				temp = (temp + size - 1) % size;
				left++;
			}

			size -= 1;
			count += Math.min(right, left);

			current = target % (size == 0 ? 1 : size);

		}
		System.out.println(count);
	}

}
