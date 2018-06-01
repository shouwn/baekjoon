package test;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MyTimeChecker implements Runnable{

	private long[] time = new long[10];
	private Consumer<Integer> consumer;
	
	public MyTimeChecker(int time, Consumer<Integer> consumer) {
		this.time = new long[time];
		this.consumer = consumer;
	}
	
	public long getAverage() {
		return Arrays.stream(time)
				.reduce((pre, cur) -> pre + cur)
				.orElse(0) / time.length;
	}

	@Override
	public void run() {
		
		Consumer<Integer> con = 
		
		Stream.iterate(0, n -> n+1).limit(time.length)
			.forEach();
	}
	
}