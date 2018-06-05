package lq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q3 {
	List<String> log = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println("Hello Goorm! Your input is " + input);
	}
	
	static class Client{
		
		TimeLine[] list;
		
		static class TimeLine{
			int[] I;
			int[] O;
			
		}
		
		
		public void addTimeLine(String input[]) {
			
		}
	}
}