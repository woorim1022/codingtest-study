#include <iostream>
#include <algorithm>
using namespace std;
//�� �������� ���ļ� ����

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
