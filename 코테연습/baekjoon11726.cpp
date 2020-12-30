//다이나믹 프로그래밍 타일링 문제 풀어보기 
//dp는 어떤 문제에서 규칙성을 찾아서 그 규칙으로부터 점화식을 찾는것이 중요하다 
//D[n] = D[n-1] + D[n-2]   ->    점화식 

#include <stdio.h>

int d[1001];

int dp(int x) {
    if(x == 1) return 1;
    if(x == 2) return 2;
    if(d[x] != 0) return d[x];
    return d[x] = (dp(x-1) + dp(x-2)) % 10007;
}

int main(void) {
    int number;
    scanf("%d", &number);
    
    printf("%d", dp(number));
}
