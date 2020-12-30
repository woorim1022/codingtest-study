//그리디 알고리즘
#include <iostream>

using namespace std;

int a[11];

int main(void){
    int n, k, result = 0; 

    cin >> n >> k;
    for(int i = 0; i < n; i++){
        cin >> a[i];
    }
    for(int i = n - 1; i >= 0; i--){
        result += k / a[i];
        k = k % a[i];
    }
    cout << result;

    return 0 ;

}
