package acmicpc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class E11866{
	
	public static void main(String[] args){
		int n, m;
		
		Queue<Integer> queue = new LinkedList<>();
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		m = scan.nextInt();
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 1; i <= n; i++){
			list.add(i);
		}
		
		int start = 0;
		int next = 0;
		
		while(!list.isEmpty()){
			
			for(int i = 0; i < m - 1; i++){
				next = (next + 1) % list.size();
			}
			queue.add(list.remove(next));
		}
		
		StringBuilder str = new StringBuilder("<");
		while(queue.size() != 1){
			str.append(String.valueOf(queue.poll())).append(", ");
		}
		
		if(queue.size() != 0)
			str.append(queue.poll());
		
		System.out.println(str.append(">").toString());
	}

}