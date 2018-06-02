package test;

import java.util.Arrays;
import java.util.stream.Stream;

public class MyTimeChecker{

	private int count;
	private long[] times;
	private TestCase test;
	
	public MyTimeChecker() {
		this.count = 10;
		this.times = new long[10];
	}
	
	public MyTimeChecker(int count) {
		this.count = count;
		this.times = new long[count];
	}
	
	public void setTest(TestCase test) {
		this.test = test;
	}

	public long getAverage() {
		return - Arrays.stream(times)
				.reduce((pre, cur) -> pre + cur)
				.orElse(0) / count;
	}

	public void check() {
		Stream<Integer> stream = Stream.iterate(0, n -> n + 1).limit(count);
		
		stream.forEach(
				(i) -> {
					times[i] = System.currentTimeMillis();
					test.test();
					times[i] -= System.currentTimeMillis();
				});
	}
}