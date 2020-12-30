#include <iostream>
#include <algorithm>
using namespace std;
//페어를 이중으로 겹쳐서 정렬

int number;
int array[10001];



int main(void) {
	
   cin >> number;
	for(int i = 0;i < number; i++){
		cin >> array[i];
	}

    sort(array, array + number);

    for(int i =0; i < number; i++){
        cout << array[i] << endl;
    }

}
