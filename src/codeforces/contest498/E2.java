package codeforces.contest498;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E2 {
	public static void main(String[] args) throws IOException {
		try(MyScanner<Integer> scan = new MyScanner<>()){
			scan.setReader(new InputStreamReader(System.in));
			scan.compile("[0-9]+", s -> Integer.valueOf(s));

			int n = scan.next();
			int k = scan.next();
			int[] arr = new int[n];

			for(int i = 0; i < n; i++) 
				arr[i] = scan.next();

			solution(n, k, arr);
		}
	}

	public static void solution(int n, int k, int[] arr) {
		int[] indices = new int[k];
		int minIndex = Integer.MAX_VALUE;

		int sz = arr.length;
		
		for(int i = 0; i < k; i++) {
			indices[i] = i;
			
			if(arr[i] < arr[minIndex])
				minIndex = i;
		}
		
		for(int i = k; i < sz; i++) {
			
		}
		
		


	}

	static class MyScanner<T> implements AutoCloseable{

		//Scanner 와 같이 사용 시 문제점이 있음. Scanner가 buffer를 해서 앞에 내용을 가져감

		private BufferedReader reader;

		private Pattern integerPattern = Pattern.compile("([-+]?[0-9]+)");
		private Pattern pattern;
		private Matcher matcher;

		private Pattern currentPattern;

		private Function<String, T> nexter;

		public void setReader(Reader reader) {
			this.reader = new BufferedReader(reader);
		}

		public void compile(String regex, Function<String, T> nexter) {
			this.pattern = Pattern.compile(regex);
			this.nexter = nexter;
		}

		// 정규식에 해당하는 문자열이 있는지 확인하는 메소드
		private boolean find(Pattern pattern){

			if(matcher != null && pattern != this.currentPattern) {
				matcher.usePattern(pattern);
				this.currentPattern = pattern;
			}

			try {
				while(this.matcher == null || !this.matcher.find()) {
					String line = reader.readLine();
					if(line == null)
						return false;
					this.matcher = pattern.matcher(line);
				}

				return true;
			}
			catch(IOException e) {
				throw new RuntimeException(e);
			}
		}

		// 찾은 문자열을 return 해주는 메소드
		public T next() {
			if(this.find(this.pattern))
				return this.nexter.apply(this.matcher.group(0));

			return null;
		}

		// 찾은 문자열을 return 해주는 메소드
		public Integer nextInt() {
			if(this.find(this.integerPattern))
				return Integer.valueOf(this.matcher.group(0));

			return null;
		}

		@Override
		public void close() throws IOException {
			this.reader.close();
		}
	}
}
