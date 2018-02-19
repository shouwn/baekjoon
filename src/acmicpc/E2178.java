package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class E2178 {
	
	static int rowSize, colSize;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Node> queue = new PriorityQueue<>();
		
		String[] input = reader.readLine().split(" ");
		rowSize = Integer.valueOf(input[0]);
		colSize = Integer.valueOf(input[1]);
		
		boolean[][] map = new boolean[rowSize][colSize];
		
		for(int i = 0; i < rowSize; i++) {
			String[] line = reader.readLine().split("");
			
			for(int j = 0; j < colSize; j++) 
				map[i][j] = line[j].equals("1");
		}
		
		queue.add(new Node(0, 0, 1));
		Node temp = null;
		
		while(!queue.isEmpty()) {
			temp = queue.poll();
			if(temp.goal())
				break;
			
			queue.addAll(temp.subNode(map));
		}
		
		System.out.print(temp.lenght());
		
	}
	
	static class Node implements Comparable<Node>{
		int row, col;
		int gCost, hCost;
		
		public Node(int row, int col, int gCost) {
			this.row = row;
			this.col = col;
			this.gCost = gCost;
			this.hCost = (rowSize - row) + (colSize - col);
		}
		
		public int getCost(){ return gCost + hCost; }
		public int lenght() { return gCost; }
		
		public Set<Node> subNode(boolean[][] map){
			Set<Node> set = new HashSet<>();
			
			if(row - 1 >= 0 && map[row - 1][col]) {
				set.add(new Node(row - 1, col, gCost + 1));
				map[row - 1][col] = false;
			}
			if(row + 1 < rowSize && map[row + 1][col]) {
				set.add(new Node(row + 1, col, gCost + 1));
				map[row + 1][col] = false;
			}
			if(col - 1 >= 0 && map[row ][col - 1]) {
				set.add(new Node(row, col - 1, gCost + 1));
				map[row][col - 1] = false;
			}
			if(col + 1 < colSize && map[row][col + 1]) {
				set.add(new Node(row, col + 1, gCost + 1));
				map[row][col + 1] = false;
			}
			
			return set;
		}
		
		public boolean goal() { return row + col == rowSize + colSize - 2; }

		@Override
		public int compareTo(Node o) {
			return getCost() - o.getCost();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + col;
			result = prime * result + row;
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
			if (col != other.col)
				return false;
			if (row != other.row)
				return false;
			return true;
		}
		
	}

}
