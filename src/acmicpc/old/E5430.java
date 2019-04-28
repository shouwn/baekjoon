package acmicpc.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E5430 {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int count = Integer.valueOf(reader.readLine());

		for(int i = 0; i < count; i++) {
			boolean reverse = false;

			String commands = reader.readLine();
			int size = Integer.valueOf(reader.readLine());
			int[] set = new int[size];

			String[] input = reader.readLine().replaceAll("[\\[\\]]", "").split(",");

			for(int j = 0; j < size; j++) {
				set[j] = Integer.valueOf(input[j]);
			}

			int front = 0; 
			int rear = size;

			for(char c : commands.toCharArray()) {
				if(c == 'R')
					reverse = !reverse;
				else if(!reverse)
					front++;
				else
					rear--;
			}

			if(front <= rear) {
				StringBuilder s = new StringBuilder("[");

				for(int k = 0; k < rear - front; k++) {
                    if (k > 0) 
                    	s.append(",");
					s.append(set[!reverse ? front + k : rear - 1 - k]);
				}
				s.append("]");
				System.out.println(s.toString());
			}
			else {
				System.out.println("error");
			}
		}

	}

}
