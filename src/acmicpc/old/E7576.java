package acmicpc.old;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class E7576 {
	
	private static final int RIPE = 1;
	private static final int UNRIPE = 0;
	private static final int EMPTY = -1;
	
	private static final int RIPE_INDEX = 0;
	private static final int UNRIPE_INDEX = 1;
	private static final int EMPTY_INDEX = 2;
	private static final int CURRENT = 0;
	private static final int NEXT = 1;
	
	public static void main(String[] args){
		int height = 0;
		
		int rowSize, colSize;
		int[] field;
		Scanner scan = new Scanner(System.in);
		int[] count = new int[3]; // 0 ripe 1 unripe 2 empty
		Queue<Integer>[] queues;
		
		queues = (Queue<Integer>[]) new LinkedList<?>[2];
		queues[CURRENT] = new LinkedList<Integer>();
		queues[NEXT] = new LinkedList<Integer>();
		
		colSize = scan.nextInt();
		rowSize = scan.nextInt();
		
		field = new int[rowSize * colSize];
		count[2] = rowSize * colSize;
		
		for(int i = 0; i < rowSize * colSize; i++){
				field[i] = scan.nextInt();
				if(field[i] == RIPE){
					queues[CURRENT].add(i);
					count[RIPE_INDEX]++;
				}
				else if(field[i] == UNRIPE)
					count[UNRIPE_INDEX]++;
				else
					count[EMPTY_INDEX]++;
		}
		
		Integer temp;
		
		while((temp = queues[CURRENT].poll()) != null){
			
			if(temp / colSize != 0 && field[temp - colSize] == UNRIPE){
				queues[NEXT].add(temp - colSize);
				field[temp - colSize] = RIPE;
				count[UNRIPE_INDEX]--;
				count[RIPE_INDEX]++;
			}
				
			if(temp % colSize != 0 && field[temp - 1] == UNRIPE){
				queues[NEXT].add(temp - 1);
				field[temp - 1] = RIPE;
				count[UNRIPE_INDEX]--;
				count[RIPE_INDEX]++;
			}
			if(temp % colSize != colSize - 1 && field[temp + 1] == UNRIPE){
				queues[NEXT].add(temp + 1);
				field[temp + 1] = RIPE;
				count[UNRIPE_INDEX]--;
				count[RIPE_INDEX]++;
			}
			if(temp / colSize != rowSize - 1 && field[temp + colSize] == UNRIPE){
				queues[NEXT].add(temp + colSize);
				field[temp + colSize] = RIPE;
				count[UNRIPE_INDEX]--;
				count[RIPE_INDEX]++;
			}
			
			if(queues[CURRENT].isEmpty()){
				Queue<Integer> tempQueue = queues[CURRENT];
				queues[CURRENT] = queues[NEXT];
				queues[NEXT] = tempQueue;
				height++;
			}
				
		}
		
		if(count[UNRIPE_INDEX] == 0)
			System.out.println(--height);
		else
			System.out.println(-1);
	}
}