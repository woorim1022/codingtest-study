#include <iostream>
#include <algorithm>
using namespace std;
//페어를 이중으로 겹쳐서 정렬

int n;
string array[1000];

int getSum(string a){
	int length = a.length(), sum = 0;
	for(int i = 0; i < length; i++){
		if(a[i] - '0' <= 9 && a[i] - '0' >= 0){
			sum += a[i] - '0';
		}
	}
	return sum;
}

bool compare(string a, string b){
	int al, bl;
	if(a.length() < b. length()){
		return 1;
	} else if(a.length() > b.length()){
		return 0;
	} else {
		int al = getSum(a);
		int bl = getSum(b);
		
		if(al != bl){
			return al < bl;
		} else {
			return  a < b;
		}
	}
}

int main(void) {
	
   cin >> n;
	for(int i = 0;i < n; i++){
		cin >> array[i];
	}

    sort(array, array + n, compare);

    for(int i =0; i < n; i++){
        cout << array[i] << endl;
    }

}
