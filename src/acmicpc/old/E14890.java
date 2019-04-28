package acmicpc.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E14890 {

	static int n, l;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int count = 0;
		double[][] road;
		
		String[] inputs =  reader.readLine().split(" ");
		n = Integer.valueOf(inputs[0]);
		l = Integer.valueOf(inputs[1]);

		road = new double[n][n];

		for(int i = 0; i < n; i++) {
			inputs = reader.readLine().split(" ");
			for(int j = 0; j < n; j++) 
				road[i][j] = Integer.valueOf(inputs[j]);
		}

		inputs = null;
		reader.close();
		// input over
		
		
		if(n == l) {
			for(int i = 0; i < n; i++) {
				boolean result = true;
				int max = n - 1;
				for(int j = 0; j < max; j++) {
					if(road[i][j] != road[i][j + 1]) {
						result = false;
						break;
					}
				}
				if(result)
					count++;
			}
			for(int i = 0; i < n; i++) {
				boolean result = true;
				int max = n - 1;
				for(int j = 0; j < max; j++) {
					if(road[j][i] != road[j + 1][i]) {
						result = false;
						break;
					}
				}
				if(result)
					count++;
			}
		}
		else if(l == 1){
			for(int i = 0; i < n; i++) {
				boolean result = true;
				int max = n - 1;
				for(int j = 0; j < max; j++) {
					if(Math.abs(road[i][j] - road[i][j + 1]) <= 1) {
						result = false;
						break;
					}
				}
				if(result)
					count++;
			}
			for(int i = 0; i < n; i++) {
				boolean result = true;
				int max = n - 1;
				for(int j = 0; j < max; j++) {
					if(Math.abs(road[j][i] - road[j + 1][i]) <= 1) {
						result = false;
						break;
					}
				}
				if(result)
					count++;
			}
		}
		else {
			double[][] temp = new double[n][n];
			
			for(int i = 0; i < n; i++) 
				for(int j = 0; j < n; j++) 
					temp[j][i] = road[i][j];
			
			count = count(road) + count(temp);
		}
		
		System.out.println(count);

	}
	
	public static int count(double[][] arr) {
		int count = 0;
		
		for(int i = 0; i < n; i++) 
			if(checkLine(arr[i]))
				count++;
		
		
		return count;
	}
	
	// check the line is valid
	public static boolean checkLine(double[] line) {
		int i = 0;
		double hight = line[0];
		
		for(; i < n - l; i++) {
			
			if(Math.abs(line[i] - line[i + l]) == 1 && isFlat(line, i + 1, i + l - 1))
				for(int k = i + 1; k <= i + l - 1; k++) 
					line[k] += 0.5;
			
			if(Math.abs(hight - line[i]) <= 0.5)
				hight = line[i];
			else 
				return false;
		}
		
		for(; i < n; i++){
			if(Math.abs(hight - line[i]) <= 0.5)
				hight = line[i];
			else 
				return false;
		}
		
		System.out.println(Arrays.toString(line));
		
		return true;
	}
	
	// check flat from start to end, end is included
	public static boolean isFlat(double[] line, int start, int end) {
		boolean result = true;
		
		for(int i = start; i < end; i++) 
			if(line[i] != line[i+1]) {
				result = false;
				break;
			}
		
		return result;
	}

}
