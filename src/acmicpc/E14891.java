package acmicpc;

import java.util.HashMap;
import java.util.Scanner;

public class E14891 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		HashMap<Integer, SawWheel> sawMap = new HashMap<>(4);

		String input = scan.nextLine();
		int[] temp = new int[8];

		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '1')
				temp[i] = 1;
			else
				temp[i] = 0;
		}

		SawWheel wheel = new SawWheel(0, new MyCircularQueue(temp));
		sawMap.put(0, wheel);

		for(int k = 1; k < 4; k++) {
			input = scan.nextLine();
			temp = new int[8];

			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i) == '1')
					temp[i] = 1;
				else
					temp[i] = 0;
			}

			wheel = new SawWheel(k, new MyCircularQueue(temp));

			SawWheel pre = sawMap.get(k - 1);
			pre.right = wheel;
			wheel.left = pre;

			sawMap.put(k, wheel);
		}

		int count = scan.nextInt();

		for(int i = 0; i < count; i++) {
			sawMap.get(scan.nextInt() - 1).rotate(scan.nextInt());
		}

		System.out.println(sawMap);

		System.out.println(sawMap.get(0).getScore());

		scan.close();

	}



}

class SawWheel{

	public static final int CLOCKWISE = 1;
	public static final int C_CLOCKWISE = 0; // counterclockwise
	public static final int STOP = -1;

	//magnet
	public static final int N = 0;
	public static final int S = 1;

	public static final int RIGHT = 1;
	public static final int LEFT = -1;

	int id;
	SawWheel right;
	SawWheel left;
	MyCircularQueue cQueue;

	public SawWheel(int id, MyCircularQueue cQueue) {
		this.id = id;
		this.cQueue = cQueue;
	}

	public void rotate(int rotate) {
		rotate(this.right, LEFT, rotate);
		rotate(this.left, RIGHT, rotate);
		System.out.println("wheel " + id + " rotate " + rotate);
		this.cQueue.rotate(rotate);
	}

	private static void rotate(SawWheel wheel, int side, int rotate) {

		if(wheel == null || rotate == STOP)
			return;
		System.out.println("wheel " + wheel.id + " rotate " + rotate);

		if(side == RIGHT) {
			if(wheel.right.cQueue.findt9() != wheel.cQueue.find3()) {
				rotate(wheel.left, side, counter(rotate));
				wheel.cQueue.rotate(rotate);
			}
		}
		else {
			if(wheel.left.cQueue.findt9() != wheel.cQueue.find3()) {
				rotate(wheel.right, side, counter(rotate));
				wheel.cQueue.rotate(rotate);
			}
		}
	}

	private static int counter(int rotate) {
		if(rotate == CLOCKWISE)
			return C_CLOCKWISE;
		if(rotate == C_CLOCKWISE)
			return CLOCKWISE;

		return STOP;
	}

	public int getScore() {
		return getScore(this);
	}

	private static int getScore(SawWheel wheel) {

		if(wheel.right == null)
			return wheel.score();

		return wheel.score() + getScore(wheel.right);
	}

	public int score() {
		int result = 0;

		if(cQueue.find12() == 1)
			result = (int) Math.pow(2, id);

		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SawWheel other = (SawWheel) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SawWheel [" + score() + "]";
	}



}

class MyCircularQueue{

	public static final int CLOCKWISE = 1;
	public static final int C_CLOCKWISE = 0; // counterclockwise
	public static final int STOP = -1;

	int size;
	int[] arr;

	int up = 0, left = 6, right = 2;

	public MyCircularQueue(int[] arr) {
		this.arr = arr;
		size = arr.length;
	}

	public int find12() {
		return arr[up];
	}

	public int findt9() {
		return arr[left];
	}

	public int find3() {
		return arr[right];
	}

	public int rotate(int wise) {
		if(wise == STOP)
			return 0;

		if(wise == CLOCKWISE) 
			return cClockwise();
		else
			return clockwise();
	}

	public int clockwise() {
		up = (up + size - 1) % size;
		left = (left + size - 1) % size;
		right = (right + size - 1) % size;

		return CLOCKWISE;
	}

	public int cClockwise() {
		up %= size;
		left %= left;
		right %= right;

		return C_CLOCKWISE;
	}

}