package acmicpc.old;

public class E4673 {
	
	static boolean[] arr = new boolean[10001];
	
	public static void main(String[] args) {
		
		StringBuilder s = new StringBuilder();
		for(int i = 1; i <= 10000; i++) {
			
			if(!arr[i]) {
				s.append(i).append("\n");
				
				d(i);
			}
		}
		
		System.out.println(s.toString());
	}
	
	public static void d(int n) {
		
		if(n > 10000)
			return;
		
		arr[n] = true;
		
		int next = n;
		
		while(n != 0) {
			next += n % 10;
			n = n / 10;
		}
		
		d(next);
	}

}
