#include <string>
#include <vector>
#include <iostream>
#include <string>

using namespace std;

int main(void){
	int n = 8;
	std::string s;
	s =	"aabbaccc";
	int answer = solution(*s);
	cout << answer;
}

int solution(string &s) {
    int n = s.length(), ans = n;
    for(int k = 1; k <= n/2; k++){
        int cnt = 0, i = 0;
        //�񱳴�� i
        while(i < n){
            int same_n = 0, next = 0;
            if(i + k > n){
                cnt+= n - i; break;
            }
            //���� j
            for(int j = i+k; j < n; j+=k){
                //�񱳽���
                int t;
                for(t = 0; t < k; t++){
                    //�ٸ��� �ϳ��� ������ 0����
                    if(s[i+t] != s[j+t])break;
                }
                if(t == k) same_n ++;
                else {
                    next = j; break;
                }
            }
            if(same_n){
                if(same_n + 1 <= 9)cnt += k + 1;
                else if(same_n + 1 <= 99)cnt += k + 2;
                else if(same_n + 1 <= 999)cnt += k + 3;
                else  cnt += k + 4;
            }
            else cnt+= k;
            if(next == 0)break;
            i = next;
        }
        if(cnt < ans) ans = cnt;
    }
    return ans;
}
