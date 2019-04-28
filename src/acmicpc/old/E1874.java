package acmicpc.old;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class E1874 {
	static Queue<String> result = new LinkedList<>();
	static Stack<Integer> stack = new Stack<>();
	static List<Integer> list = new LinkedList<>();
	
	public static void main(String[] args){
		int n;
		boolean flag = true;
		int[] arr;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = scan.nextInt();
		}
		scan.close();
		
		for(int i = 1; i <= n + 1; i++){
			list.add(i);
		}
		
		for(int j = 0; !list.isEmpty() && j < n; ){
			
			if(arr[j] >= list.get(0)){
				stack.push(list.get(0));
				result.add("+");
				list.remove(0);
			}
			
			else{
				flag = false;
				list.clear();
			}			
			
			while(!stack.isEmpty() && stack.peek() == arr[j]){
				stack.pop();
				result.add("-");
				j++;
				if(j == arr.length)
					break;
			}
		}
		
		if(flag){
			for(int i = 0; i < result.size(); i++){
				System.out.println(result.poll());
				i--;
			}
		}
		else
			System.out.println("NO");
	}

}