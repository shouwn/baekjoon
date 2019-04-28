package acmicpc.old;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class E9576 {
	
	private static final int NONE = -1;
	private static int[] level;
	private static int[][] want;
	private static boolean[] used;
	
	private static int[] bookToStudent;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int caseSize = scan.nextInt();
		
		
		for(int i = 0; i < caseSize; i++) {
			int n = scan.nextInt(), m = scan.nextInt();
			level = new int[m];
			bookToStudent = new int[n];
			want = new int[m][];
			used = new boolean[m];
			
			Arrays.fill(bookToStudent, -1);
			
			for(int j = 0; j < m; j++) {
				int a = scan.nextInt(), b = scan.nextInt();
				want[j] = new int[b - a + 1];
				for(int k = 0; k < want[j].length; k++) {
					want[j][k] = a + k - 1;
				}
			}
			
			int match = 0;
			int flow = 0;
			do {
				leveling();
				
				flow = 0;
				for(int p = 0; p < m; p++)
					if(!used[p] && search(p))
						flow++;
				
				match += flow;
				
			}while(flow != 0);
			
			System.out.println(match);
		}
		
		scan.close();
	}
	
	public static void leveling() {
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 0; i < level.length; i++) {
			if(!used[i]) {
				level[i] = 0;
				queue.add(i);
			}
			else
				level[i] = NONE;
		}
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			for(int book : want[temp]) {
				int student = bookToStudent[book];
				
				if(student != NONE && level[student] == NONE) {
					level[student] = level[temp] + 1;
					queue.add(student);
 				}
			}
		}
		
	}
	
	public static boolean search(int a) {
		for(int book : want[a]) {
			int student = bookToStudent[book];
			if(student == NONE || level[student] == level[a] + 1 && search(student)) {
				used[a] = true;
				bookToStudent[book] = a;
				return true;
			}
		}
		
		return false;
	}

}
