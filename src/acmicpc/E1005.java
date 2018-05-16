package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E1005 {
	
	public static void main(String[] args) throws IOException {
	
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
			Map<Integer, MyNode> map;
			int count = Integer.valueOf(reader.readLine());
			
			for(int i = 0; i < count; i++) {
				map = new HashMap<>();
				
				String[] input = reader.readLine().split(" ");
				
				int nodeCount = Integer.valueOf(input[0]);
				int linkCount = Integer.valueOf(input[1]);
				
				input = reader.readLine().split(" ");
				for(int j = 0; j < nodeCount; j++)
					map.put(j + 1, new MyNode(Integer.valueOf(input[j])));
				
				for(int j = 0; j < linkCount; j++) {
					input = reader.readLine().split(" ");
					int left = Integer.valueOf(input[0]);
					int right = Integer.valueOf(input[1]);
					
					map.get(left).next = map.get(right);
					map.get(left).update();
				}
				
				System.out.println("result " + map.get(Integer.valueOf(reader.readLine())));
				System.out.println("3: " + map.get(3));
				System.out.println("4: " + map.get(4));
				System.out.println("5: " + map.get(5));
				System.out.println("6: " + map.get(6));
			}
		}
	}

}

class MyNode {
	int my;
	int from;
	List<MyNode> nexts;
	
	public MyNode(int my) {
		this.my = my;
		nexts = new ArrayList<>();
	}
	
	public int getTime() {
		return my + from;
	}
	
	public static void update(MyNode current, MyNode next) {
		
		for(MyNode node : current.nexts)
			if(current.getTime() > node.from)
				next.from = current.getTime();
		
		next.update();
	}
	
	@Override
	public String toString() {
		return "" + getTime();
	}
}