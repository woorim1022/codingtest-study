//�׸��� �˰���
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
    //������������ ����
    sort(p, p + n);
	//�׸��� �˰��� 
    for(int i = 0; i < n; i++){
    	for(int j = 0; j <= i; j++){
    		result += p[j];
		}
        
    }
    cout << result;

    return 0 ;

}
