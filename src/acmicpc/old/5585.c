/*
	���� 5585��: �Ž�����

	Ǯ�� ����:
		�ܵ����� �ִ� ������ ������ ���� �۱� ���ؼ���
		��ġ�� ū ������ �ִ��� ���� �ָ� �ȴ�.
*/
#include<stdio.h>

// ī���Ϳ� �����ϴ� 1000���� MONEY�� ����
#define MONEY 1000 

// const: ������ �� ������ ������ �� ���ٰ� ����(���)
// 500 ... 1���� ��Ÿ���� �迭�� ���� ������ ����
// coins�� �迭�� ������ ����Ͽ� SIZE�� ����
// sizeof(coins) = 32bit * �迭�� ����

const int coins[] = {500, 100, 50, 10, 5, 1};
const int SIZE = sizeof(coins) / sizeof(int);

// count����: �ܵ��� ����
// remain ����: �ܵ�
int solution1(int price) {
	int count = 0;
	int remain = MONEY - price;

	// ���� ��ġ�� ū �������� �ܵ����� �� �� �ִ� ������ ���� ���
	for (int i = 0; i < SIZE; i++) {
		// ���� ���� ������ �����̹Ƿ� count�� ������ ������ �߰�
		count += remain / coins[i]; 
		// �������� �ٲٰ� ���� ������ �ܵ� ���
		remain %= coins[i]; 
	}

	return count;
}

// ���� solution1�� ����
int solution2(int price) {
	int count = 0;
	int remain = MONEY - price;

	// �ܵ��� 0�̸� �� �̻� ����� �ʿ䰡 ���� ������
	// for���� ������ �ܵ��� 0�� �ƴ� ���� ���
	// �� �� �ݺ����� �� ������ �ܵ��� ����ϰ� i�� 1�� ��������
	// ���� �������� ���ǰ� �ݺ��� ����
	for (int i = 0; remain != 0; remain %= coins[i++])
		count += remain / coins[i];

	return count;
}

// remain�� solution1, 2�� ����
// index �Ű�����: ���� �� ��° �������� ����Ű�� ����
// coins �Ű�����: ���� ������ ����� coins�� �Ű������� �޾Ƽ� ó��
int solution3(int remain, int index, int* coins) {

	// ���� �ܵ��� 0�̸� �� �̻� ����� ���� ���� ������ ����
	if (remain == 0) return 0;

	// ���� index�� ����Ű�� �������� ����� ���� ������
	// ���� ������ ����Ű�� �������� ����� ���� ������ ������ 
	// remain�� 0�� �� ������ �ݺ��ϰ� ��
	return remain / coins[index] + solution3(remain % coins[index], index + 1, coins);
}

int main() {
	int price;
	scanf("%d", &price);

	printf("solution1: %d\n", solution1(price));
	printf("solution2: %d\n", solution2(price));
	printf("solution3: %d\n", solution3(MONEY - price, 0, coins));
}