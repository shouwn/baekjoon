package codeforces.contest497;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E1 {
	public static void main(String[] args) throws IOException {
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
			System.out.println(solution(reader.readLine()));
		}
	}
	
	public static String solution(String input) {
		String regex = "([^aouien])([^aouie])";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		
		if(matcher.find()) {
			return "NO";
		}
		
		String last = input.substring(input.length() - 1);
		
		regex = "[^aouien]";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(last);
		
		if(matcher.find()) {
			return "NO";
		}
		
		return "YES";
	}
}
