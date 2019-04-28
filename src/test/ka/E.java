package test.ka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class E {

	static Map<Integer, Long> vocals = new HashMap<>();
	static Map<Integer, Integer> vocalCount = new HashMap<>();
	static Map<Integer, Integer> times = new HashMap<>();
	static Map<Node, Set<Node>> subTrees = new HashMap<>();

	static long goal;

	public static void main(String[] args) throws IOException {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			String[] in = br.readLine().split(" ");

			int N = Integer.parseInt(in[0]);
			int K = Integer.parseInt(in[1]);
			goal = Long.parseLong(in[2]);

			new Node().setParent(0);

			for(int i = 1; i < N; i++)
				new Node();
			
			in = br.readLine().split(" ");
			
			for(int i = 2; i <= N; i++) // 부모 세팅
				Node.list.get(i).setParent(Integer.parseInt(in[i - 2]));

			in = br.readLine().split(" ");

			for(int i = 1; i <= N; i++) {
				int vocal = Integer.valueOf(in[i - 1]);

				vocalCount.put(vocal, 
						Optional.ofNullable(vocalCount.get(vocal)).orElse(0) + 1);

				Node.setVocal(i, vocal);
			}
			
			for(int i = 0; i < K; i++) {
				in = br.readLine().split(" ");

				Node.addScore(
						Integer.valueOf(in[0]), 
						Integer.valueOf(in[1]), 
						Integer.valueOf(in[2])
						);
			}

			List<Node> list = Node.list;

			for(int i = 1; i < list.size(); i++) {
				System.out.println(
						Optional.ofNullable(times.get(list.get(i).vocal)).orElse(-1));
			}
		}
	}

	static class Node{
		static List<Node> list = new ArrayList<>();

		static {
			new Node(); // add super parent
		}

		static int ai = 0;
		
		int id;
		Integer vocal;
		List<Node> children = new ArrayList<>();

		private Node() {
			id = ai++;
			list.add(this);
		}

		public void setParent(int parent) {
			list.get(parent).add(this);
		}

		public void add(Node child) {
			children.add(child);
		}

		public static void setVocal(int node, Integer vocal) {
			list.get(node).vocal = vocal;
		}

		public static void addScore(int time, int nodeIndex, long score) {
			Node start = list.get(nodeIndex);

			Set<Node> subTree = Node.subTree(start);

			score /= subTree.size();

			for(Node node : subTree) {
				long vocalScore = 
						Optional.ofNullable(vocals.get(node.vocal)).orElse((long) 0) 
						+ score;

				//System.out.println("time: " + time + " vocalScore: " + vocalScore);

				if(vocalScore / vocalCount.get(node.vocal) >= goal 
						&& !times.containsKey(node.vocal))
					times.put(node.vocal, time);

				vocals.put(node.vocal, vocalScore);
			}
		}

		private static Set<Node> subTree(Node node){
			if(subTrees.containsKey(node))
				return subTrees.get(node);
			
			Set<Node> subTree = new HashSet<>();
			subTree.add(node);
			
			for(Node child : node.children)
				subTree.addAll(Node.subTree(child));
			
			subTrees.put(node, subTree);
			
			return subTree;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
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
			if (id != other.id)
				return false;
			return true;
		}
	}
}
