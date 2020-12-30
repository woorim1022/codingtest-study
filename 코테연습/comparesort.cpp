#include <iostream >
#include <algorithm>
//정렬할 기준을 직접 설정해줌 
using namespace std;

bool compare(int a, int b){   
	return a < b; //오름차순 정렬
	//a > b   내림차순 정렬 
}
int main(void) {
    int a[10] = {9, 3, 5, 4, 1, 10, 8, 6, 7, 2};
    
    sort(a, a + 10, compare);  //배열 이름, 가장 마지막 주소, true/false
    
    for(int i = 0; i < 10; i++){
        cout << a[i] << ' ';
    }

	return 0;
}
