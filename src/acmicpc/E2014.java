package acmicpc;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class E2014 {

	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		int[] arr;

		PriorityQueue<Integer> queueMin = new PriorityQueue<>();
		PriorityQueue<Integer> queueMax = new PriorityQueue<>(Collections.reverseOrder());
		Set<Integer> set = new HashSet<>();
		int count, lenght, temp;

		lenght = scan.nextInt();
		count = scan.nextInt();
		arr = new int[lenght];

		for(int i = 0; i < arr.length; i++){
			arr[i] = scan.nextInt();
		}

		scan.close();

		for(int i = 0; i < lenght; i++){
			set.add(arr[i]);
			queueMin.add(arr[i]);
			if(i < count)
				queueMax.add(arr[i]);
		}

		int min = queueMin.peek();

		for(int i = 0; i < count; i++){
			min = queueMin.poll();

			for(int j = 0; j < arr.length; j++){
				if(min <= Integer.MAX_VALUE / arr[j]){
					temp = min * arr[j];

					if(queueMax.size() == count){

						if(queueMax.peek() > temp && set.add(temp)){
							queueMax.poll();
							queueMax.add(temp);
							queueMin.add(temp);
						}
					}
					else if(set.add(temp)){
						queueMin.add(temp);
						queueMax.add(temp);
					}
				}
			}
		}

		System.out.println(min);
	}
}