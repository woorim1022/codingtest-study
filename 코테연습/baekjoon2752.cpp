#include <stdio.h>

//기초 정렬 문제 풀어보기 

int array[1001];

int main(void) {
	int i, j, min, index, temp;
	for(i = 0;i < 3; i++){
		scanf("%d", &array[i]);
	}
	for(i= 0; i < 3; i++){
		min = 1000001;
		for(j = i; j < 3; j++){
			if(min > array[j]){
				min = array[j];
				index = j;
			}
		}
		temp = array[i];
		array[i] = array[index];
		array[index] = temp;
	}
	for(i = 0; i < 3; i++){
		printf("%d ", array[i]);
	}
	return 0;
} 
