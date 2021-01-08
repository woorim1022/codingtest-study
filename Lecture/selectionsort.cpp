#include <stdio.h>

//제일 기본 그니까 복습해 
int main(void) {
	//1, 10, 5, 8, 7, 6, 4, 3, 2, 9 
	//선택 정렬 : 가장 작은 것을 선택해서 제일 앞으로 보낸다 
	
	
	int i, j, min, index, temp;
	int array[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
 
	for(i = 0; i < 10;i++){
		min = 9999;
		//아직 정렬하지 않은 값들 중 최소값을 찾는 과정 
		for(j = i; j < 10; j++){
			if(min > array[j]){
				min = array[j];
				index = j;
			}
		}
		//최소값과 i 번째 값의 위치를  바꿔준다 
		temp = array[i];
		array[i] = array[index];
		array[index] = temp;
	}
	for(i = 0; i < 10; i++){
		printf("%d ", array[i]);
	}
	
	return 0;
}



//소요시간
// 10 + 9 + 8 + ... + 1
//10 * (10 + 1) / 2 = 55
//55번의 비교연산을 해야한다
//n + ( n + 1) / 2
//O(n * n) 
//선택정렬의 시간 복잡도는 O(N^2) (빅 오 표기법) 
//다른 정렬 알고리즘과 비교해 봤을 때 매우 비효율적인 알고리즘 
