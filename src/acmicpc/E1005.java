package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Vertex{
	int time;
	int beforeTime;
	int parentCount;
	List<Vertex> children = new ArrayList<>();
	
	public Vertex(int time) { 
		this.time = time;
	}
	
	public void addChildVertex(Vertex child) {
		children.add(child);
		child.parentCount++;
	}
	
	public int getTotalTime() {
		return time + beforeTime;
	}
	
	public void setBeforeTime(Vertex before) {
	
		if(before.getTotalTime() > beforeTime)
			this.beforeTime = before.getTotalTime();
	}

	@Override
	public String toString() {
		return "" + getTotalTime();
	}
}

public class E1005 {
	
	public static void main(String[] args) throws IOException {
		solution();
		
	}
	
	public static void solution() throws IOException {
		Vertex[] V = null;
		
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
			int count = Integer.valueOf(reader.readLine());
			
			for(int i = 0; i < count; i++) {
				
				String[] input = reader.readLine().split(" ");
				
				int VCount = Integer.valueOf(input[0]);
				int ECount = Integer.valueOf(input[1]);
				
				input = reader.readLine().split(" ");
				V = new Vertex[VCount];
				for(int j = 0; j < VCount; j++)
					V[j] = new Vertex(Integer.valueOf(input[j]));
				
				for(int j = 0; j < ECount; j++) {
					input = reader.readLine().split(" ");
					
					int parent = Integer.valueOf(input[0]) - 1;
					int child = Integer.valueOf(input[1]) - 1;
					V[parent].addChildVertex(V[child]);
				}
				
				int w = Integer.valueOf(reader.readLine()) - 1;
				Vertex result = V[w];
				for(int j = 0; j < V.length; j++) {
					for(int k = 0; k < V.length; k++) {
						if(V[k] != null && V[k].parentCount == 0) {
							
							//System.out.println("V[" + k + "]: " + V[k] + " w: " + w);
							
							for(Vertex v : V[k].children) {
								v.setBeforeTime(V[k]);
								v.parentCount--;
							}
							V[k] = null;
						}
					}
				}
				System.out.println(result);
			}
		}
	}

}
