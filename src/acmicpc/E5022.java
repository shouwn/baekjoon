package acmicpc;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class E5022 {

	public static void main(String[] args){
		Set<Dot> passedDot = new HashSet<>();

		int rowSize, colSize;
		int rowA, colA;
		int rowTargetA, colTargetA;
		int rowB, colB;
		int rowTargetB, colTargetB;

		Scanner scan = new Scanner(System.in);
		rowSize = scan.nextInt();
		colSize = scan.nextInt();
		rowA = scan.nextInt();
		colA = scan.nextInt();
		rowTargetA = scan.nextInt();
		colTargetA = scan.nextInt();
		rowB = scan.nextInt();
		colB = scan.nextInt();
		rowTargetB = scan.nextInt();
		colTargetB = scan.nextInt();
		scan.close();

		Dot.setSize(rowSize, colSize);

		Dot a = new Dot(rowA, colA);
		Dot targetA = new Dot(rowTargetA, colTargetA);
		Dot b = new Dot(rowB, colB);
		Dot targetB = new Dot(rowTargetB, colTargetB);
		
		int case01, case02;
		
		try {
			passedDot.add(b);
			passedDot.add(targetB);
			passedDot = route(a, targetA, passedDot);
			int lineA = passedDot.size() - 1;
			int lineB = route(b, targetB, passedDot).size() - 1;
			case01 = lineA + lineB;

		} catch (Exception e) {
			case01 = 100000;
		}
		
		passedDot.clear();
		
		try{
			passedDot.add(a);
			passedDot.add(targetA);
			passedDot = route(b, targetB, passedDot);
			int lineB = passedDot.size() - 1;
			int lineA = route(a, targetA, passedDot).size() - 1;
			case02 = lineA + lineB;
		} catch (Exception e){
			case02 = 100000;
		}
		int result;
		if((result = (case01 > case02 ? case02 : case01)) >= 100000)
			System.out.println("IMPOSSIBLE");
		else
			System.out.println(result);


	}

	public static Set<Dot> route(Dot start, Dot end, Set<Dot> passedDot) throws Exception{
		PriorityQueue<Node> queue = new PriorityQueue<>();

		Set<Dot> result = new HashSet<>();
		queue.add(new Node(start, end, 0, passedDot, null));
		Node temp = null;

		while(!queue.isEmpty()){
			temp = queue.poll();

			if(temp.getPredictCost() == 0)
				break;

			queue.addAll(temp.subNode());

			temp = null;
		}
		if(temp == null)
			throw new Exception();

		while(temp != null){
			result.add(temp.getDot());
			temp = temp.getParent();
		}
		return result;
	}

	private static class Node implements Comparable<Node>{
		private Dot dot;
		private Dot target;
		private int predictCost;
		private int count;
		private Set<Dot> passedSet;
		private Node parent;
		private int total;

		public Node(Dot dot, Dot target, int count, Set<Dot> passedSet, Node parent) {
			this.dot = dot;
			this.target = target;
			this.count = count;
			this.passedSet = passedSet;
			this.parent = parent;

			predictCost = dot.distance(target);
			total = count + predictCost;
			passedSet.add(dot);
		}

		public int getPredictCost(){
			return predictCost;
		}

		public Set<Node> subNode(){
			Set<Node> sub = new HashSet<>();
			Set<Dot> subDot = dot.subDot();

			for(Dot d : subDot)
				if(!passedSet.contains(d))
					sub.add(new Node(d, target, count + 1, passedSet, this));

			return sub;
		}

		public Node getParent() {
			return parent;
		}

		public Dot getDot() {
			return dot;
		}

		@Override
		public int compareTo(Node o) {
			return (this.total - o.total);
		}
	}

	private static class Dot{
		private int row, col;
		private static int rowSize, colSize;

		public Dot(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		public static void setSize(int row, int col){
			rowSize = row; colSize = col;
		}

		public int distance(Dot other){
			return Math.abs(row - other.row) + Math.abs(col - other.col);
		}

		public Set<Dot> subDot(){
			Set<Dot> sub = new HashSet<Dot>();

			if(row != 0){
				sub.add(new Dot(row - 1, col));
			}
			if(row != rowSize){
				sub.add(new Dot(row + 1, col));
			}
			if(col != 0){
				sub.add(new Dot(row, col - 1));
			}
			if(col != colSize){
				sub.add(new Dot(row, col + 1));
			}
			return sub;
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
			Dot other = (Dot) obj;
			if (col != other.col)
				return false;
			if (row != other.row)
				return false;
			return true;
		}
	}

}
