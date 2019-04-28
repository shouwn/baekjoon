package acmicpc.old;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.function.Consumer;

public class E2741 {
	public static void main(String[] args) throws IOException {
		try(Scanner scan = new Scanner(System.in)){
			//solution1(scan.nextInt(), E2741::bw);
			solution(scan.nextInt(), System.out::print);
		}
	}
	
	public static void solution(int N, Consumer<String> writer) throws IOException {
			StringBuilder ans = new StringBuilder();
			
			for(int i = 1; i <= N; i++)
				ans.append(i).append("\n");
			
			/*
			Stream.iterate(1, i -> i + 1).limit(N)
				.forEach(i -> ans.append(i).append("\n"));
			*/
			
			writer.accept(ans.toString());
	}
	
	public static void bw(String output) {
		try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){			
			bw.write(output);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
