package test;

public class Test0_9 {
	static class A{
		int a;
		int b;
		static int c;

		public void test(){
			synchronized(A.class) {
				System.out.println("sleep " + Thread.currentThread().getName());
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("wake " + Thread.currentThread().getName());
			}
		}

	}
	public static void main(String[] args) {
		new Thread(() -> new A().test()).start();
		new Thread(() -> new A().test()).start();
		System.out.println(A.class);
	}
}
