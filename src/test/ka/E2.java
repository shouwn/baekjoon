package test.ka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class E2 {

	
	public static void main(String[] args) throws IOException {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

			String[] in = br.readLine().split(" ");

			int N = Integer.parseInt(in[0]);
			int K = Integer.parseInt(in[1]);
			int goal = Integer.parseInt(in[2]);

			init(br, N);

			Node root = Node.nodeList.get(1);
			Map<Integer, Integer> vocalCount = root.subVocalCount;
			Map<Integer, Long> vocalScore = new HashMap<>();
			
			Map<Integer, Integer> vocalTime = new HashMap<>();
			
			for(int i = 1; i <= K; i++) {
				in = br.readLine().split(" ");
				
				final int time = i;
				
				Node node = Node.nodeList.get(Integer.parseInt(in[1]));
				int score = Integer.parseInt(in[2]);
				
				Node.addScore(node, score, vocalScore);
				
				vocalScore.entrySet().stream()
						.filter(entry -> 
							(entry.getValue() / vocalCount.get(entry.getKey()) >= goal))
						.filter(entry -> !vocalTime.containsKey(entry.getKey()))
						.forEach(entry -> 
							vocalTime.put(entry.getKey(), time));
			}
			
			for(int i = 1; i <= N; i++)
				System.out.println(
						Optional.ofNullable(vocalTime.get(Node.nodeList.get(i).vocal))
						.orElse(-1));
		}
	}
	
	public static void init(BufferedReader br, int N) throws IOException {
		String[] in;
		
		for(int i = 1; i <= N; i++)
			new Node(i);

		in = br.readLine().split(" ");

		for(int i = 0; i < N - 1; i++) // 부모 세팅
			Node.nodeList.get(i + 2).setParent(Integer.parseInt(in[i]));

		Node.nodeList.get(1).setParent(0); // 1번 위에는 TOP만 있음 (부모가 없음)

		in = br.readLine().split(" ");

		for(int i = 0; i < N; i++) 
			Node.nodeList.get(i + 1).setVocal(Integer.valueOf(in[i]));
		
	}

	static class Node{

		static List<Node> nodeList = new ArrayList<>();
		static final Node TOP;

		static {
			TOP = new Node(0);
		}

		int number; // 자기 번호
		Node parent; // 부모 노드 번호
		int vocal;

		int totalVocalCount; // 현재 노드를 포함 서브 노드의 전체 vocal들 카운트 (점수 부여용)
		Map<Integer, Integer> subVocalCount = new HashMap<>();

		public Node(int number) {
			this.number = number;
			nodeList.add(this);
		}

		public void setParent(int nodeNumber) {
			parent = nodeList.get(nodeNumber);
		}

		public void setVocal(int vocal) {
			this.vocal = vocal;

			addVocal(this, vocal);
		}

		private static void addVocal(Node node, int vocal) {
			if(node == TOP) return;

			node.subVocalCount.put(vocal, 
					Optional.ofNullable(node.subVocalCount.get(vocal)).orElse(0) + 1);

			node.totalVocalCount++;

			addVocal(node.parent, vocal);
		}
		
		public static void addScore(Node node, int score, Map<Integer, Long> vocalScore) {

			//System.out.println(node.number +" " + node.subVocalCount);
			
			int eachScore = score / node.totalVocalCount;
			
			for(Integer vocal : node.subVocalCount.keySet()) 
				vocalScore.put(vocal, 
						Optional.ofNullable(vocalScore.get(vocal)).orElse((long)0) 
						+ (eachScore * node.subVocalCount.get(vocal)));
		}
	}
}
