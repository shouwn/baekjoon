package lineSummerIntern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		String input = br.readLine();
		String[] inputs;

		int game = Integer.valueOf(input);

		for(int i = 0; i < game; i++) {

			Team brown = new Team("Brown");
			Team cony = new Team("Cony");
			
			input = br.readLine();
			int round = Integer.valueOf(input);

			for(int j = 0; j < round; j++) {

				inputs = br.readLine().split(" ");
				int x = Integer.valueOf(inputs[0]);
				int y = Integer.valueOf(inputs[1]);

				if(inputs[2].equals(brown.name)) 
					brown.addBall(x, y);
				else 
					cony.addBall(x, y);
			}

			Collections.sort(brown.balls);
			Collections.sort(cony.balls);

			if(brown.balls.get(0) > cony.balls.get(0)) {
				int count = 1;
				double ball = cony.balls.get(1);
				for(int j = 2; j < cony.balls.size() && ball < brown.balls.get(0); j++) {
					ball = cony.balls.get(j);
					count++;
				}
				
				System.out.println(cony.name + " " + count);
			}
			else {
				int count = 1;
				double ball = brown.balls.get(1);
				for(int j = 2; j < brown.balls.size() && ball < cony.balls.get(0); j++) {
					ball = brown.balls.get(j);
					count++;
				}
				System.out.println(brown.name + " " + count);
			}

		}

		br.close();
	}

	static class Team{
		String name;
		List<Double> balls = new ArrayList<>();
		public Team(String name) {
			this.name = name;
		}

		public void addBall(int x, int y) {
			balls.add(Math.sqrt(Math.pow(x - 0, 2) + Math.pow(y - 0, 2)));
		}
	}
}
