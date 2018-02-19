package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class E2188 {
	
	static int cow, shed;
	
	static int[] cowSide, shedSide, dist;
	static boolean[] used;
	static List<int[]> list;
	static final int INF = 100000;

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		cow = Integer.valueOf(st.nextToken());
		shed = Integer.valueOf(st.nextToken());
		
		list = new ArrayList<>(cow);
		
		for(int i = 0; i < cow; i++) {
			st = new StringTokenizer(reader.readLine());
			
			int[] line = new int[Integer.valueOf(st.nextToken())];
			
			for(int j = 0; j < line.length; j++) 
				line[j] = Integer.valueOf(st.nextToken()) - 1;
			
			list.add(line);
		}
		
		int match = 0;
		
		cowSide = new int[cow];
		shedSide = new int[shed];
		used = new boolean[cow];
		dist = new int[cow];
		
		Arrays.fill(cowSide, -1);
		Arrays.fill(shedSide, -1);
		
		while(true) {
			bfs();
			
			int flow = 0;
			for(int i = 0; i < cow; i++)
				if(!used[i] && dfs(i))
					flow++;
			
			if(flow == 0)
				break;
			
			match += flow;
		}
		
		System.out.println(match);

	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 0; i < cow; i++) {
			if(!used[i]) {
				dist[i] = 0;
				queue.add(i);
			}
			else
				dist[i] = INF;
		}
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for(int temp : list.get(current)) {
				if(shedSide[temp] != -1 && dist[shedSide[temp]] == INF) {
					dist[shedSide[temp]] = dist[current] + 1;
					queue.add(shedSide[temp]);
				}
			}
			
		}
	}
	
	public static boolean dfs(int a) {
		for(int b : list.get(a)) {
			if(shedSide[b] == -1 || dist[shedSide[b]] == dist[a] + 1 && dfs(shedSide[b])) {
				used[a] = true;
				cowSide[a] = b;
				shedSide[b] = a;
				return true;
			}
		}
		
		return false;
	}

}
