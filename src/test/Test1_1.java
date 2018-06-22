package test;

import java.util.Queue;

public class Test1_1 {
	
	static class Time { }
	
	public static void main(String[] args) {
		// 6개월 분 시간에서 작업한 시간 만큼 빼가면서 
		// getMinDeliverTime 과 getMaxDeliver를 호출하며 계산
	}
	
	// 현재 도착 예정 시간을 통해 나갔다 돌아오는 데 걸리는 최소의 시간을 구함
	public static Time getMinDeliverTime(Queue<Time> q) {
		Time time = new Time();// 구한 시간을 큐에 넣고 return
		q.add(time);
		return time;
	}
	
	// DP를 이용하여 제한된 시간 내에서 가장 많은 양의 물품을 배송할 수 있는 양
	public static int getMaxDeliver(Time time) {
		return 0;
	}

}
