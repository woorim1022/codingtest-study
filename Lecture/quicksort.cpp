#include <stdio.h>

//매우 어려움 근데 개중요해 복습해 복습 
//퀵 정렬 
//대표적인 '분할 정복' 알고리즘 
//하나의 큰 문제를 두 개의 작은 문제로 분할하는 식으로 빠르게 정렬 
//특정한 피벗(pivot) 값을 기준으로 왼쪽 오른쪽을 나눔 
int number = 10;
int data[10] =	{1 ,10, 5, 8, 7, 6, 4, 3, 2, 9};

void quickSort(int *data, int start, int end){
	if(start >= end){  //원소가 한 개인 경우 
		return;
	}
	int key = start;  //키(피벗 값)는 첫 번째 원소 
	int i = start + 1; //왼쪽부터 오른쪽으로 한 칸씩 이동하면서 키 값보다 큰 값을 찾는다 
	int j = end; //오른쪽부터 왼쪽으로 한 칸씩 이동해 나가면서 키 값보다 작은 값을 찾는다 
	int temp; //두가지 값의 위치를 바꿀 수 있는 임시 변수
	
	while(i <= j){  //엇갈릴 때 까지 반복 (왼쪽부터 시작한 값이 오른쪽 부터 시작한 값보다 작을 떄 까지만 반복 
		while(data[i] >= data[key]){ //키 값보다 큰 값을 만날 때 까지 오른쪽으로 이동 
			i++;
		}
		while(data[j] <= data[key] && j > start){ //키 값보다 작은 값을 만날 때 까지 왼쪽으로 이동, 단 j는 start보다 커야한다  
			j--;
		}
		if(i > j){  //현재 엇갈린 상태면 키 값과 교체 
			temp = data[j];
			data[j] = data[key];
			data[key] = temp;
		} else{  //엇갈린 상태가 아니라면 큰 값과 작은 값을 교체 
			temp = data[j];
			data[j] = data[i];
			data[i] = temp;
		}

	} 
	//재귀적 함수 구현 
	quickSort(data, start, j-1);
	quickSort(data, j+1 , end);
}
 
int main(void) {
 
	quickSort(data, 0, number - 1);
	for(int i = 0; i < number; i++) {
		printf("%d ", data[i]);
	}
	
	return 0;
}

//1) 왼쪽에서 오른쪽으로 이동하면서 피벗보다 큰 값을 찾는다 (data[i])
//2) 오른쪽에서 왼쪽으로 이동하면서 피벗보다 작은 값을 찾는다 (data[j])
//1) 에서 찾은 값이 2)에서 찾은 값보다, 
//뒤에 있으면(엇갈린 상태) 피벗보다 작은 값의 위치를 피벗과 교체한다(피벗값이 자기 자리를 찾아가게 됨)
//앞에 있으면 두 값을 교체한다.
//새로 자리를 찾은 피벗을 기준으로 왼쪽과 오른쪽에서 위의 과정을 반복한다(재귀함수)

//평균적인 시간 복잡도 : O(n*logn)
//최악의 경우 O(n^2)이 나올 수 있음 ( 이미 정렬이 되어 있는 경우 '분할 정복'의 이점을 활용하지 못하게 된다) 

