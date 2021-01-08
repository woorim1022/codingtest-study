#include <iostream>
#include <algorithm>
using namespace std;
//페어를 이중으로 겹쳐서 정렬

int number;
string array[20000];

bool compare(string a, string b){
	if(a.length() < b. length()){
		return 1;
	} else if(a.length() > b.length()){
		return 0;
	}
	//길이가 같은 경우라면
	else {
		return a < b; //사전순으로 정렬 
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
