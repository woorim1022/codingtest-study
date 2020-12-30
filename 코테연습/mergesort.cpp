#include <stdio.h>

//아주 어렵다 복습 빡씨게 하자 
//병합 정렬
//분할 정복법
//O(N * logN)
//편향되게 분할 될 가능성이 없어서 퀵 정렬과 다르게 n * logn 을 보장할 수 있다. 

int number = 8;
int sorted[8]; //정렬 배열은 반드시 전역 변수로 선언(불필요한 메모리 사용 방지)

void merge(int a[], int m, int middle, int n) {
    int i = m; //0
    int j = middle + 1; //4
    int k = m; //0, n = 7 
    //작은 순서대로 배열에 삽입
    while(i <= middle && j <= n){   //i 가 중간값보다 작고 j 가 끝값보다 작은 동안 반복 
        if(a[i] <= a[j]){    //양쪽 배열의 값을 비교해서 왼쪽값이 작으면 
            sorted[k] = a[i];  //왼쪽값을 새로운 배열에 저장 
            i++;               //왼쪽 배열의 인덱스 증가 
        } else {             //오른쪽값이 작으면 
            sorted[k] = a[j];  //오른쪽값을 새로운 배열에 저장 
            j++;			   //오른쪽 배열 인덱스 증가 
        }
        k++;                 //인덱스 k 에 값 저장되었으므로 증가 
    }
    //한쪽이 정렬이 끝나고 남은 반대쪽 데이터 마저 삽입
    if(i > middle){        //i가 중간값보다 크면(왼쪽 배열의 값들이 모두 새로운 배열에 저장되었으면) 
        for(int t = j; t <= n; t++){  //오른쪽 배열의 값들이 남아있을 것이므로 오른쪽배열 인덱스 증가시키며 저장 
            sorted[k] = a[t];
            k++;
        }
    } else {			   //오른쪽 배열의 값들이 모두 새로운 배열에 저장된 경우 
        for(int t = i; t <= middle; t++){  //왼쪽 배열의 값들이 남아있을 것이므로 왼쪽 배열의 인덱스 증가시키며 남은 값 저장 
            sorted[k] = a[t];
            k++;
        }
    }
    //정렬된 배열을 삽입
    for(int t = m; t <= n; t++){
        a[t] = sorted[t];
    }
}

void mergeSort(int a[], int m, int n){
    //크기가 1보다 큰 경우
    if(m < n){   //0 < 7
        int middle = ( m + n ) / 2;   //3
        mergeSort(a, m, middle);  //a, 0, 3
        mergeSort(a, middle + 1, n);  //a, 4, 7
        merge(a, m, middle, n);  //a, 0, 3, 7
    }
}

int main(void) {

    int array[number] = {7, 6, 5, 8, 3, 5, 9, 1};
    mergeSort(array, 0, number - 1); //array, 0, 7
    for(int i = 0; i < number; i++){
        printf("%d ", array[i]);
    }
	
	
	return 0;
}

//병합 정렬에 사용되는 전역 변수로 만드는 것이 중요
//기존의 데이터를 정렬해서 담을 추가적인 배열이 필요하므로 메모리 활용 측면에서는  비효율적임 
