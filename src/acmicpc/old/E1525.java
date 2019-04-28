package acmicpc.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class E1525 {
	private static int[] collectState = {1, 2, 3, 4, 5, 6, 7, 8, 0};
	
	private static Set<Node> passedNode = new HashSet<>();
	private static PriorityQueue<Node> pQueue = new PriorityQueue<>();
	
	public static void main(String args[]){
		String input;
		int[] state = new int[9];
		Node temp;
		
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < 3; i++){
			input = scan.nextLine();
			int j = 0;
			for(String s : input.split(" ")){
				state[i * 3 + j++] = Integer.valueOf(s);
			}
		}
		
		pQueue.add(new Node(0, state));
		passedNode.add(pQueue.peek());
		
		while((temp = pQueue.poll()) != null){
			if(temp.getHCost() == 0)
				break;
			
			pQueue.addAll(temp.subNode());
		}
		
		if(temp == null)
			System.out.println(-1);
		else 
			System.out.println(temp.getGCost());
				
	}
	
	static class Node implements Comparable<Node>{
		private int hCost;
		private int gCost;
		private int cost;
		
		private int[] state;
		
		public Node(int gCost, int[] state){
			this.gCost = gCost;
			this.state = state;
			calHCost();
			cost = gCost + hCost;
		}
		
		public Set<Node> subNode(){
			Set<Node> set = new HashSet<>();
			Node temp;
			
			for(int[] state : subState()){
				temp = new Node(gCost + 1, state);
				if(passedNode.add(temp))
					set.add(temp);
			}
			
			return set;
		}
		
		public List<int[]> subState(){
			List<int[]> sub = new ArrayList<>();
			
			int index = 0;
			for(; index < state.length; index++){
				if(state[index] == 0)
					break;
			}
			
			if(index/3 != 0)
				sub.add(swap(index, index - 3));
			if(index % 3 != 0)
				sub.add(swap(index, index - 1));
			if(index % 3 != 2)
				sub.add(swap(index, index + 1));
			if(index / 3 != 2)
				sub.add(swap(index, index + 3));
			return sub;
		}
		
		private int[] swap(int index1, int index2){
			int[] newState = Arrays.copyOf(state, state.length);
			
			int temp = newState[index1];
			newState[index1] = newState[index2];
			newState[index2] = temp;
			
			return newState;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(state);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!Arrays.equals(state, other.state))
				return false;
			return true;
		}

		public int getHCost(){
			return hCost;
		}
		
		public int getGCost(){
			return gCost;
		}
		
		private void calHCost(){
			for(int i = 0; i < 9; i++){
				if(this.state[i] != collectState[i])
					hCost++;
			}
		}
		
		@Override
		public int compareTo(Node other) {
			return this.cost - other.cost;
		}
		
	}
}
