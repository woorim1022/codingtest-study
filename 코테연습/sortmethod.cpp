#include <iostream >
#include <algorithm>
//c++에서는 다양한 stl 라이브러리를 제공하기 떄문에 편리하다

using namespace std;

int main(void) {
    int a[10] = {9, 3, 5, 4, 1, 10, 8, 6, 7, 2};
    
    sort(a, a + 10);  //배열 이름, 가장 마지막 주소
    
    for(int i = 0; i < 10; i++){
        cout << a[i] << ' ';
    }

	return 0;
}
