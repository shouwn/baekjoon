package acmicpc.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class E14699 {
	
	static class Vertex {
		int visitedCount;
		int height;
		
		boolean isRemoved = false;
		
		int parentCount;
		List<Vertex> children = new ArrayList<>();
		

		public Vertex(int height) {
			this.height = height;
		}
		
		public void addChild(Vertex v) {
			children.add(v);
			v.parentCount++;
		}
		
		public static void addChild(Vertex v1, Vertex v2) {
			if(v1.height > v2.height)
				v1.addChild(v2);
			else
				v2.addChild(v1);
		}
		
		public void setVisitedCount(Vertex v) {
			if(this.visitedCount <= v.visitedCount)
				this.visitedCount = v.visitedCount + 1;
		}
		
		@Override
		public String toString() {
			return "" + this.visitedCount;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		Vertex[] V = scanVertex();
		count(V);
		System.out.println(output(V));
	}
	
	public static String output(Vertex[] V) {
		StringBuilder str = new StringBuilder();
		
		for(Vertex v : V) {
			str.append(v.visitedCount + 1).append("\n");
		}
		
		return str.toString();
	}
	
	public static void count(Vertex[] V) {
		for(int i = 0; i < V.length; i++) {
			for(int j = 0; j < V.length; j++) {
				if(!V[j].isRemoved && V[j].parentCount == 0) {
					
					
					for(Vertex v : V[j].children) {
						v.parentCount--;
						v.setVisitedCount(V[j]);
					}
					
					V[j].isRemoved = true;
				}
			}
		}
	}
	
	public static Vertex[] scanVertex() throws IOException {
		Vertex[] V = null;
		
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
			String[] temp = reader.readLine().split(" ");
			
			int vCount = parseInt(temp[0]), eCount = parseInt(temp[1]);
			V = new Vertex[vCount];
			temp = reader.readLine().split(" ");
			
			for(int i = 0; i < vCount; i++) 
				V[i] = new Vertex(parseInt(temp[i]));
			
			for(int i = 0; i < eCount; i++) {
				temp = reader.readLine().split(" ");
				
				int left = parseInt(temp[0]);
				int right = parseInt(temp[1]);
				
				Vertex.addChild(V[left - 1], V[right - 1]);
			}
			
		}
		
		return V;
	}
	
	public static int parseInt(String s) {
		return Integer.valueOf(s);
	}
	
	
}

