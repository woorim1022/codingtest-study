#include <iostream>
#include <algorithm>
using namespace std;
//�� �������� ���ļ� ����

int number;
string array[20000];

bool compare(string a, string b){
	if(a.length() < b. length()){
		return 1;
	} else if(a.length() > b.length()){
		return 0;
	}
	//���̰� ���� �����
	else {
		return a < b; //���������� ���� 
	}  
}

int main(void) {
	
   cin >> number;
	for(int i = 0;i < number; i++){
		cin >> array[i];
	}

    sort(array, array + number, compare);

    for(int i =0; i < number; i++){
    	if(i > 0 && array[i] == array[i-1])
    		continue;
        cout << array[i] << endl;
    }

}
