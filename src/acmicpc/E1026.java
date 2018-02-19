package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E1026 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int lenght = Integer.valueOf(reader.readLine());
		
		int[] arr1 = new int[lenght];
		int[] arr2 = new int[lenght];
		
		String[] inputs = reader.readLine().split(" ");
		for(int i = 0; i < lenght; i++) 
			arr1[i] = Integer.valueOf(inputs[i]);
		
		inputs = reader.readLine().split(" ");
		for(int i = 0; i < lenght; i++) 
			arr2[i] = Integer.valueOf(inputs[i]);
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int result = 0;
		
		for(int i = 0; i < lenght; i++) {
			result += arr1[i] * arr2[lenght - 1 - i];
		}
		
		System.out.println(result);
	}

}
