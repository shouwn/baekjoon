package test.eq;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test5 {

	static class Point{
		int x, y;

		public Point(String s) {
			String[] str = s.split(" ");
			x = Integer.valueOf(str[0]);
			y = Integer.valueOf(str[1]);
		}
	}

	// Complete the maxPoints function below.
	static int maxPoints(String[] points) {
		List<Point> p = new ArrayList<>();
		for(String s : points) 
			p.add(new Point(s));
		int size = p.size();

		int max = 0;

		for(int i = 0; i < size; i++) {
			List<Integer> h = new ArrayList<>();
			h.add(p.get(0).y - p.get(i).y);

			for(int j = 1; j < size; j++) 
				h.add(p.get(j).y - p.get(i).y);

			int count = 0;

			for(Integer semiH : h) {
				if(semiH > 0) {
					for(int j = 0; j < size; j++) {
						if(p.get(j).y - p.get(i).y == semiH)
							count++;
					}
				}
				
				max = Math.max(max, count);
			}
		}

		return max;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int pointsCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] points = new String[pointsCount];

		for (int i = 0; i < pointsCount; i++) {
			String pointsItem = scanner.nextLine();
			points[i] = pointsItem;
		}

		int res = maxPoints(points);

		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
