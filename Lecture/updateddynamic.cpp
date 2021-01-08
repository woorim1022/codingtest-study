//개선된 피보나치 알고리즘 
//한번 구한 값은 저장을 해서 다시 그 값을 요구할 때는 이미 구한 값을 반환만 하게끔 수정한다
//메모이제이션
//시간복잡도 O(n) 
#include <stdio.h>


int d[100]; //기본적으로 0으로 초기화됨 

int dp(int x){   //숫자가 커지면 연산 횟수가 두배씩 증가해서 2^n번 연산하게 된다 
				 //개선할 필요가 있음 
	if(x == 1) return 1;  //재귀함수가 종료되는임 조건 
	if(x == 2) return 1;  //재귀함수가 종료되는 조건
	if(d[x] != 0) return d[x];  //이미 구한 값은 연산을 거치지 않고 이미 저장된 값을 불러옴 
	return d[x] = dp(x - 1) + dp(x - 2); //구한적 없는 값은 연산을 하고 배열에 값을 저장 
}
int main(void){
	printf("%d ", dp(30));
} 