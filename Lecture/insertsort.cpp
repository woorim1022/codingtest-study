#include <stdio.h>

//어려움 
//삽입 정렬
//각 숫자를 적절한 위치에 삽입하는 방법
//다른 정렬은 무조건 위치를 바꾸는 방식이었다면 
//삽입 정렬은 '필요할 때만' 위치를 바꾸므로
//버블, 선택 정렬보다 효율적이다. 
//앞의 숫자들이 이미 정렬이 되어 있다고 가정 
int main(void) {
	 
	 int array[10] = {10, 1, 5, 8, 7, 6, 4, 3, 2, 9};
	 int i, j, temp;
	 
	 for(i = 0; i < 9; i++){
	 	j = i;  //현재 정렬할 원소를 선택
		while(j >= 0 && array[j] > array[j+1]) {
			temp = array[j];
			array[j] = array[j+1];
			array[j+1] = temp;
			j--;
			
		}
	 }
	 for(i = 0; i < 10 ; i++){
		printf("%d ", array[i]);
	}
	 
	return 0;
	
}

//거의 정렬된 상태라면 삽입 정렬이 매우 효율적
//경우에 따라 매우 비효율적일수 있고 효율적일 수 있음 
//O(n^)
	
