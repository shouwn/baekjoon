package eq;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	static class Node {
		
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

		public void add(int value) {
			if (value < this.value) {
				if (left == null) left = new Node(value);
				else left.add(value);
			} else if (value > this.value) {
				if (right == null) right = new Node(value);
				else right.add(value);
			}
		}

		public void print(List<Integer> list) {
			list.add(value);
			if (left != null) left.print(list);
			if (right != null) right.print(list);
		}

	}

	static class BinaryTree {
		static Node dummy;
		
		List<Integer> result = new ArrayList<>();
		
		public BinaryTree() {
			dummy = new Node(Integer.MAX_VALUE);
		}

		public void add(int value) {
			dummy.add(value);
		}

		public void print() {
			if (dummy.left != null) dummy.left.print(result);
		}
		
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		try(MyScanner scan = MyScannerFactory.makeMyScanner("[0-9]+")){
			scan.find();
			int count = scan.read();
			
			for(int i = 0; i < count; i++) {
				scan.find();
				int lenght = scan.read(); 
				List<Integer> list = new ArrayList<>();
				for(int j = 0; j < lenght; j++) {
					scan.find();
					list.add(scan.read());
				}
				System.out.println(solution(list));
			}
		}
		
	}
	
	public static String solution(List<Integer> list) {
		BinaryTree binaryTree = new BinaryTree();
		for(Integer item : list)
			binaryTree.add(item);
		binaryTree.print();
		
		int count = list.size();
		
		for(int i = 0; i < count; i++) {
			if(list.get(i) != binaryTree.result.get(i))
				return "NO";
		}
		
		return "YES";
		
	}
	
	static class MyScanner implements AutoCloseable{

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

	static class MyScannerFactory{
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
}




