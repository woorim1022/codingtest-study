#include <stdio.h>

//버블 정렬
//옆에 있는 값과 비교해서 더 작은 값을 앞으로 보내는 방법 
//가장 쉽지만 가장 비효율적 
int main(void) {
	
	int i, j, temp;
	int array[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
	
	for(i = 0; i < 10; i++){
		for(j = 0; j < 9 - i; j++){
			if(array[j] > array[j+1]){
				temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
			}
		}
	}
	for(i = 0; i < 10 ; i++){
		printf("%d ", array[i]);
	}
	 
	return 0;
}

//시간 복잡도 O(n^2)
//10 + 9 + 8 + .. + 1
//등차수열, n * (n + 1) / 2
//실제로는 선택 정렬보다 버블 정렬이 느리다.
//매번 두 값을 교체 해주기 때문에(명령어가 세 줄) 
