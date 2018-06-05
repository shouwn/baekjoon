package eq;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyScanner implements AutoCloseable{

	private BufferedReader reader;
	private String regex;
	private Pattern pattern;
	private Matcher matcher;

	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}
	public void setRegex(String regex) throws IOException {
		this.regex = regex;
		pattern = Pattern.compile(this.regex);
		matcher = pattern.matcher(reader.readLine());
	}

	// 정규식에 해당하는 문자열이 있는지 확인하는 메소드
	public boolean find() throws IOException {
		if(matcher.find()) {
			return true;
		}
		else {
			String line;
			while(!matcher.find()) {
				line = reader.readLine();
				if(line == null)
					return false;
				matcher = pattern.matcher(line);
			}

			return true;
		}
	}

	// 찾은 문자열을 return 해주는 메소드
	public int read() throws IOException{

		return Integer.valueOf(matcher.group(0));
	}

	@Override
	public void close() throws IOException {
		reader.close();
	}
}

class MyScannerFactory{
	public static MyScanner makeMyScanner(String regex) 
			throws FileNotFoundException, IOException{

		BufferedReader reader = 
				new BufferedReader(new InputStreamReader(System.in));
		MyScanner scan = new MyScanner();
		scan.setReader(reader);
		scan.setRegex(regex);
		return scan;
	}
}