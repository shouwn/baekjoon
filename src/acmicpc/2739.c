/*
	���� 2739��: ������

	Ǯ�� ����:
		�Է����� �־��� ���� �ݺ����� ���鼭
		1 ���� 9���� ���Ͽ� ����Ѵ�.
*/
#include<stdio.h>
#define MAX_DAN 9

int main() {
	int in; // �Էµ� ���� ������ ���� in

	scanf("%d", &in); // ����ڷκ��� �Է��� ����

	//MAX_DAN���� dan(��)�� 1�� ������Ű�鼭 ���
	for (int dan = 1; dan <= MAX_DAN; dan++) 
		//in: �Է¹��� ��, dan: 1.. 9, in * dan: �Է� ���� ���� ���� ���� ������ ���
		printf("%d * %d = %d\n", in, dan, in * dan);

	return 0;
}