#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <list>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    int n = answers.size();
    vector <vector<int>> arr({
        vector<int>({1, 2, 3, 4, 5}),
        vector<int>({2, 1, 2, 3, 2, 4, 2, 5}),
        vector<int>({3, 3, 1, 1, 2, 2, 4, 4, 5, 5})
    });
    vector <int> cnt(3);
    
    for(int i = 0; i < arr.size(); i++){
        int idx = 0;
        for(int j = 0; j < n; j++){
            idx = j % arr[i].size();
            if(answers[j] == arr[i][idx]) cnt[i]++;
        }
    }
    //cnt 원소 크기비교
    // for(int i = 0; i < cnt.size(); i++){
    //     cout << cnt[i];
    // }
    
   int maxCnt = max(cnt[0], max(cnt[1], cnt[2]));
    cout << maxCnt;
    if(maxCnt == cnt[0]) answer.push_back(1);
    if(maxCnt == cnt[1]) answer.push_back(2);
    if(maxCnt == cnt[2]) answer.push_back(3);
                    
    
    
    return answer;
}