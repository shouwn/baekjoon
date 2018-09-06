/*
	백준 5585번: 거스름돈

	풀이 개요:
		잔돈으로 주는 동전의 갯수가 가장 작기 위해서는
		가치가 큰 동전을 최대한 많이 주면 된다.
*/
#include<stdio.h>

// 카운터에 지불하는 1000엔을 MONEY로 정의
#define MONEY 1000 

// const: 앞으로 이 변수는 수정할 수 없다고 선언(상수)
// 500 ... 1엔을 나타내는 배열을 전역 변수로 정의
// coins의 배열의 갯수를 계산하여 SIZE에 배정
// sizeof(coins) = 32bit * 배열의 길이

const int coins[] = {500, 100, 50, 10, 5, 1};
const int SIZE = sizeof(coins) / sizeof(int);

// count변수: 잔돈의 갯수
// remain 변수: 잔돈
int solution1(int price) {
	int count = 0;
	int remain = MONEY - price;

	// 가장 가치가 큰 동전부터 잔돈으로 줄 수 있는 동전의 수를 계산
	for (int i = 0; i < SIZE; i++) {
		// 나눈 몫이 동전의 갯수이므로 count에 동전의 갯수를 추가
		count += remain / coins[i]; 
		// 동전으로 바꾸고 남은 나머지 잔돈 계산
		remain %= coins[i]; 
	}

	return count;
}

// 변수 solution1과 동일
int solution2(int price) {
	int count = 0;
	int remain = MONEY - price;

	// 잔돈이 0이면 더 이상 계산할 필요가 없기 때문에
	// for문의 조건을 잔돈이 0이 아닐 때로 명시
	// 한 번 반복문이 돌 때마다 잔돈을 계산하고 i를 1씩 증가시켜
	// 다음 동전으로 계산되게 반복문 구성
	for (int i = 0; remain != 0; remain %= coins[i++])
		count += remain / coins[i];

	return count;
}

// remain은 solution1, 2와 동일
// index 매개변수: 현재 몇 번째 동전인지 가르키는 변수
// coins 매개변수: 전역 변수로 선언된 coins를 매개변수로 받아서 처리
int solution3(int remain, int index, int* coins) {

	// 만약 잔돈이 0이면 더 이상 계산할 것이 없기 때문에 종료
	if (remain == 0) return 0;

	// 현재 index가 가르키는 동전으로 계산한 동전 갯수와
	// 다음 동전이 가르키는 동전으로 계산한 동전 갯수를 더함을 
	// remain이 0이 될 때까지 반복하게 됨
	return remain / coins[index] + solution3(remain % coins[index], index + 1, coins);
}

int main() {
	int price;
	scanf("%d", &price);

	printf("solution1: %d\n", solution1(price));
	printf("solution2: %d\n", solution2(price));
	printf("solution3: %d\n", solution3(MONEY - price, 0, coins));
}