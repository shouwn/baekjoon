package ka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	static int[] stage1 = new int[21];
	static int[] money1 = new int[] { 500, 300, 200, 50, 30, 10};
	static int[] stage2 = new int[32];
	static int[] money2 = new int[] {512, 256, 128, 64, 32};

	public static void main(String[] args) throws IOException {

		init();

		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int T = Integer.valueOf(br.readLine());

			for(int i = 0; i < T; i++) {
				String[] in = br.readLine().split(" ");

				int a = Integer.valueOf(in[0]);
				int b = Integer.valueOf(in[1]);

				System.out.println(solution(a, b) * 10000);
			}
		}

		//System.out.println(Arrays.toString(stage1));
		//System.out.println(Arrays.toString(stage2));
	}

	public static void init() {
		int sum = 0;

		for(int i = 1; i <= 6; i++) {
			for(int j = sum; j < sum + i; j++) 
				stage1[j] = money1[i - 1];

			sum += i;
		}

		sum = 0;
		for(int i = 1; i <= 16; i *= 2) {
			for(int j = sum; j < sum + i; j++) {
				stage2[j] = 512 / i;
			}

			sum += i;
		}
	}

	public static int solution(int a, int b) {
		if(a != 0 && a < 22) 
			a = stage1[a - 1];
		else
			a = 0;
		
		if(b != 0 && b < 32)
			b = stage2[b - 1];
		else
			b = 0;

		return a + b;
	}
}
