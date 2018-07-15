package test.MyScanner;

import java.io.IOException;
import java.io.InputStreamReader;

import util.MyScanner;

public class SystemInTest {
	
	static class Pair{
		int left;
		int right;
		
		public Pair(int left, int right) {
			super();
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "Pair [left=" + left + ", right=" + right + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		try(MyScanner<Pair> scan = new MyScanner<>()){
			scan.setReader(new InputStreamReader(System.in));
			scan.compile("[0-9]+ [0-9]+", s -> {
				String[] in = s.split(" ");
				return new Pair(Integer.valueOf(in[0]), Integer.valueOf(in[1]));
			});
			
			int N = scan.nextInt();
			
			for(int i = 0; i < N; i++)
				System.out.println(scan.next());
			
			System.out.println("TEST");
		}
		
	}
	
}
