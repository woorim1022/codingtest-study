#include <string>
#include <vector>
#include <iostream>

using namespace std;


bool visit[201];

void dfs(vector<vector<int>> &computers,int i, int n){

	visit[i] = true;

    
	for (int j = 0; j < n; j++) {
		 if ((!visit[j]) && (computers[i][j] == 1)) 
			dfs(computers, j, n);
	}
 
}

int solution(int n, vector<vector<int>> computers) {
    int cnt = 0;
   for (int i = 0; i < n; i++) {
		if (!visit[i]) {
			dfs(computers, i, n);
			cnt++;
		}
	}

	return cnt;
}