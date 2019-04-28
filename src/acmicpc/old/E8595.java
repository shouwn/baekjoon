package acmicpc.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E8595 {

	static final boolean NUM = true;
	static final boolean CHAR = false;

	public static void main(String[] args) throws IOException {
		String input;
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
			input = reader.readLine();
			input = reader.readLine();
		}

		StringBuilder str = new StringBuilder();
		boolean state = false; // true is current state is number

		long sum = 0;

		for(int i = 0; i < input.length(); i++) {
			if(Character.isAlphabetic(input.charAt(i))) {
				if(state == NUM) {
					sum += Integer.valueOf(str.toString());
					str = new StringBuilder();
					state = CHAR;
				}
			}
			else {
				state = NUM;
				str.append(String.valueOf(input.charAt(i)));
			}
		}
		
		if(state == NUM) {
			sum += Integer.valueOf(str.toString());
		}
		
		System.out.println(sum);

	}

}
