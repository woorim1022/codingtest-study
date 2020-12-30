//그리디 알고리즘
//당장 눈 앞에 보이는 최적의 상황만을 쫓는 알고리즘
//항상 최적의 결과를 도출하는 것은 아니지만 어느 정도 최적의 해애 근사한 값을 구할 수 있음
//대표 적 예 : 거스름 돈 문제
#include <iostream>

using namespace std;

int main(void){
    int n, result = 0;
    cin >> n;
    n = 1000 - n;
    result += n / 500;
    n = n % 500;
    result += n / 100;
    n = n % 100;
    result += n / 50;
    n = n % 50;
    result += n / 10;
    n = n % 10;
    result += n / 5;
    n = n % 5;
    result += n;
    cout << result;
    return 0 ;

}
