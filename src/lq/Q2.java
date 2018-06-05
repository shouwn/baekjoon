package lq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2 {
	
	static int width;
	static int height;
	static int alpha;
	static int duration;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		Canvas canvas = new Canvas();
		canvas.width = Integer.valueOf(input[2]);
		canvas.height = Integer.valueOf(input[4]);
		
		input = br.readLine().split(" ");
		canvas.background = Long.parseLong(input[2].substring(2), 16);
		
		input = br.readLine().split(" ");
		canvas.setFrame(Integer.valueOf(input[3]));
		
		input = br.readLine().split(" ");
		for(int i = 1; i < 5; i++) {
			switch(input[i]) {
			case "width":
				width = i;
				break;
			case "height":
				height = i;
				break;
			case "alpha":
				alpha = i;
				break;
			case "duration":
				duration = i;
				break;
			}
		}
		
		for(int i = 0; i < canvas.frame; i++) {
			input = br.readLine().split(" ");
			canvas.arr[i][Canvas.WIDTH] = Integer.valueOf(input[width]);
			canvas.arr[i][Canvas.HEIGHT] = Integer.valueOf(input[height]);
			canvas.arr[i][Canvas.ALPHA] = input[alpha].equals("yes") ? 1 : 0;
			canvas.arr[i][Canvas.DURATION] = Integer.valueOf(input[duration]);
		}
		
		canvas.print();
		
		br.close();
	}
	
	static class Canvas {
		int width;
		int height;
		long background;
		int frame;
		int[][] arr;
		
		static final int WIDTH = 0;
		static final int HEIGHT = 1;
		static final int DURATION = 2;
		static final int ALPHA = 3;
		
		public void setFrame(int frame) {
			this.frame = frame;
			
			arr = new int[frame][4];
		}

		public void print() {
			System.out.println(width);
			System.out.println(height);
			System.out.println(background);
			System.out.println(frame);
			
			for(int i = 0; i < frame; i++) {
				System.out.println(arr[i][WIDTH] + "x" + arr[i][HEIGHT] + ", " + 
						arr[i][DURATION] + ", " + arr[i][ALPHA]);
			}
			
		}
	}
}