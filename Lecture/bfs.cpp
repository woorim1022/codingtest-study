#include <iostream>
#include <queue>
#include <vector>
using namespace std;

//너비 우선 탐색 (BFS)
//거리가 가까운것 순서대로 출력하는것 
//시작 노드를 큐에 삽입
//시작 노드를 방문 처리
//큐에서 하나의 노드를 꺼낸다
//해당 노드에 연결된 노드 중 방문하지 않은 노드를 방문하고, 차례대호보로 큐에 삽입
//위 두 과정을 계리속해서 반복  

int number = 7;
int c[7];
vector<int> a[8];

void bfs(int start){    //첫번째 노드  
	queue<int> q;
	q.push(start);       //큐에 첫번째 노드 십입  
	c[start] = true;     //첫번째 노드 방문 처리 
	while(!q.empty()){   //큐가 비어있지 않으면 반복 
		int x = q.front();  //첫 번째 노드  
		q.pop();            //첫번째 노드 꺼내기 
		printf("%d ", x);   //첫번째 노드 출력 
		for(int i= 0; i < a[x].size(); i++){   //첫 번째 노드 벡터의 길이만큼 반복 
			int y = a[x][i];                   //첫번째 노드와 연결된 노드 
			if(!c[y]){                         //노드에 아직 방문하지 않았으면 
				q.push(y);                     //큐에 삽입 
				c[y] = true;                   //방문 처 
			}		
		}
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
	
	bfs(1);
	return 0;
}
