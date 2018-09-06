package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class E11650 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		read().stream()
			.sorted(Comparator.comparing(Pair::getLeft)
					.thenComparing(Pair::getRight))
			.forEach(pair -> sb.append(pair).append("\n"));

		System.out.println(sb.toString());
	}

	public static List<Pair> read(){
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int N = Integer.parseInt(br.readLine());
			String[] inputs = new String[N];

			for(int i = 0; i < N; i++)
				inputs[i] = br.readLine();

			return Arrays.stream(inputs)
					.map(str -> {
						String[] s = str.split(" ");
						return new Pair(Integer.valueOf(s[0]), Integer.valueOf(s[1]));})
					.collect(Collectors.toList());

		} catch (IOException e) {throw new RuntimeException(e);}
	}

	static class Pair{
		int left, right;

		public int getLeft() {
			return left;
		}

		public int getRight() {
			return right;
		}

		public Pair(int left, int right) {
			super();
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return left + " " + right;
		}


	}

}
