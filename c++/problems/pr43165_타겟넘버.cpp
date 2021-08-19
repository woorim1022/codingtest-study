#include <string>
#include <vector>
#include <iostream>

using namespace std;
int numSize;
int answer = 0;

void dfs(int idx, int sum, int target, vector<int>& numbers);
int solution(vector<int> numbers, int target);

int main(int argc, char const *argv[])
{
    cout << solution(vector<int>({1, 1, 1, 1, 1}), 3);
    return 0;
}





void dfs(int idx, int sum, int target, vector<int>& numbers){
    if(idx == numSize){
        if(sum == target){
            answer++;
        }
        return;
    }
    dfs(idx + 1,sum + numbers[idx],target,numbers);  //(인접 노드중 방문하지 않은 노드중 가장작은노드, 현재까지 가감한 결과, 타겟값, 배열)
    dfs(idx + 1,sum - numbers[idx],target,numbers);
}
int solution(vector<int> numbers, int target) {
    numSize = numbers.size();
    dfs(0,0,target,numbers);
    return answer;
}