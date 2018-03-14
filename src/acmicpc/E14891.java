package acmicpc;

import java.util.HashMap;
import java.util.Scanner;

public class E14891 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		HashMap<Integer, Node> nodeMap = new HashMap<>(4);
		int[] temp = new int[8];

		for(int i = 0; i < 8; i++) 
			temp[i] = input.charAt(i) == '1' ? 1 : 0;

		nodeMap.put(0, new Node(null, null, 0, temp));
		
		for(int i = 1; i < 4; i++) {
			input = scan.nextLine();
			temp = new int[8];
			
			for(int k = 0; k < 8; k++) {
				temp[k] = input.charAt(k) == '1' ? 1 : 0;
			}
			Node tempNode = nodeMap.get(i - 1);
			Node current = new Node(tempNode, null, i, temp); 
			tempNode.right = current;
			nodeMap.put(i, current);
			
		}
		
		int count = scan.nextInt();
		
		for(int i = 0; i < count; i++) {
			nodeMap.get(scan.nextInt() - 1).rotate(scan.nextInt());
		}
		
		System.out.println(nodeMap.get(0).score());

		scan.close();

	}

}

class Node{
	
	int id;

	static final int CLOCK = 1;
	static final int C_CLOCK = -1;
	static final int STOP = 0;

	static final int RIGHT = 1;
	static final int LEFT = -1;

	Node left;
	Node right;
	Wheel wheel;

	public Node(Node left, Node right, int id, int[] arr) {
		this.left = left;
		this.right = right;
		wheel = new Wheel(arr);
		this.id = id;
	}

	public void rotate(int dir) {

		rotate(left, RIGHT, dir);
		rotate(right, LEFT, dir);
		wheel.rotate(dir);
	}

	private static void rotate(Node current, int from, int dir) {
		if(dir == STOP || current == null)
			return;

		int currentDir = STOP;
		Node next = null;
		
		if(from == RIGHT) {
			next = current.left;
			if(current.right.wheel.get(Wheel.WEST) != current.wheel.get(Wheel.EAST)) 
				currentDir = counter(dir);
			
		}
		else {
			next = current.right;
			if(current.left.wheel.get(Wheel.EAST) != current.wheel.get(Wheel.WEST))
				currentDir = counter(dir);
		}
		
		rotate(next, from, currentDir);

		current.wheel.rotate(currentDir);

	}

	public int score() {
		return score(this);
	}

	private static int score(Node node) {
		if(node == null)
			return 0;
		
		int result = (node.wheel.get(Wheel.NORTH) == 1 ? ((int) Math.pow(2, node.id)) : 0);
		
		return result + score(node.right);
	}


	public static int counter(int dir) {
		if(dir == CLOCK)
			return C_CLOCK;
		else
			return CLOCK;
	}
	
	class Wheel{

		int top = 0;

		static final int NORTH = 0;
		static final int EAST = 90;
		static final int WEST = 270;

		int[] arr;

		public Wheel(int[] arr) {
			this.arr = arr;
		}

		public void rotate(int dir) {
			if(dir == STOP)
				return;
			
			if(dir == C_CLOCK) 
				top = (top + 45) % 360;
			else
				top = (top + 360 - 45) % 360;
			
		}

		public int get(int degree) {
			return arr[((degree + top) % 360) / 45];
		}
		
	}
}