/*
	백준 2739번: 구구단

	풀이 개요:
		입력으로 주어진 값을 반복문을 돌면서
		1 부터 9까지 곱하여 출력한다.
*/
#include<stdio.h>
#define MAX_DAN 9

int main() {
	int in; // 입력된 값을 저장한 변수 in

	scanf("%d", &in); // 사용자로부터 입력을 받음

	//MAX_DAN까지 dan(단)을 1씩 증가시키면서 출력
	for (int dan = 1; dan <= MAX_DAN; dan++) 
		//in: 입력받은 수, dan: 1.. 9, in * dan: 입력 받은 수와 현재 단을 곱셈한 결과
		printf("%d * %d = %d\n", in, dan, in * dan);

	return 0;
}