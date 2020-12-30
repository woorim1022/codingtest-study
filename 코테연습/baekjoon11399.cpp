//그리디 알고리즘
#include <iostream>
#include <algorithm> 
using namespace std;

int p[1001];

int main(void){
    int n, result = 0; 

    cin >> n;
    
    for(int i = 0; i < n; i++){
        cin >> p[i];
    }
    //오름차순으로 정렬
    sort(p, p + n);
	//그리디 알고리즘 
    for(int i = 0; i < n; i++){
    	for(int j = 0; j <= i; j++){
    		result += p[j];
		}
        
    }
    cout << result;

    return 0 ;

}
