package test;

public class Test0_7 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable());
		Thread t2 = new Thread(new MyRunnable());
		Thread t3 = new Thread(new MyRunnable());
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("main end");
	}
	
	static class MyRunnable implements Runnable{

		@Override
		public void run() {
			for(int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
