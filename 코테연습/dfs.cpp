#include <iostream>
#include <vector>
using namespace std;

//깊이  우선 탐색 (DFS)
//스택을 사용 
//인접 노드 중에서 방문하지 않은 노드 중 작은 값의 노드에 방문 

int number = 7;
int c[7];
vector<int> a[8];

void dfs(int x){
	if(c[x]) return; //이미 방문을 했으면 리턴 
    c[x] = true;     //첫번째 노드 방문 처리 
    cout << x << ' ';//첫번째 노드 출력 
    for(int i = 0; i < a[x].size(); i++){ //첫번째 노드의 벡터 길이만큼 반복 
        int y = a[x][i]; //첫번째 노드와 연결된 노드 
        dfs(y);          //재귀함수   
    }
	
}

int main(void){
	a[1].push_back(2);
	a[2].push_back(1);
	
	a[1].push_back(3);
	a[3].push_back(1);
	
	a[2].push_back(3);
	a[3].push_back(2);
	
	a[2].push_back(4);
	a[4].push_back(2);
	
	a[2].push_back(5);
	a[5].push_back(2);
	
	a[3].push_back(6);
	a[6].push_back(3);
	
	a[3].push_back(7);
	a[7].push_back(3);
	
	a[4].push_back(5);
	a[5].push_back(4);
	
	a[6].push_back(7);
	a[7].push_back(6);
	
	dfs(1);
	return 0;
}
