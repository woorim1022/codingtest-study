//크루스칼 알고리즘
//가장 적은 비용으로 모든 노드를 연결하기 위해 사용하는 알고리즘
//사이클이 발생하면 안됨
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int getParent(int parent[], int x){
    if(x == parent[x]) return x;
    return parent[x] = getParent(parent, parent[x]);
}

int findParent(int parent[], int a, int b){
    a = getParent(parent, a);
    b = getParent(parent, b);
    if(a == b) return 1;
    return 0;
}

int unionParent(int parent[], int a, int b){
    a = getParent(parent, a);
    b = getParent(parent, b);
    if(a < b) parent[b] = a;
    else parent[a] = b;
}

//간선 정보를 담는 클래스 선언
class Edge {
    public:
        int node[2];
        int distance;
        Edge(int a, int b, int distance){
            this->node[0] = a;
            this->node[1] = b;
            this->distance = distance;
        }

        bool operator <(Edge &edge) {
            return this->distance < edge.distance;
        }
};

int main(void){
    int n = 7;
    int m = 11; 

    vector<Edge> v;
    v.push_back(Edge(1, 7, 12));
    v.push_back(Edge(1, 4, 28));
    v.push_back(Edge(1, 5, 17));
    v.push_back(Edge(1, 2, 67));
    v.push_back(Edge(2, 4, 24));
    v.push_back(Edge(2, 5, 62));
    v.push_back(Edge(3, 5, 20));
    v.push_back(Edge(3, 6, 37));
    v.push_back(Edge(4, 7, 13));
    v.push_back(Edge(5, 6, 45));
    v.push_back(Edge(5, 7, 73));

    //간선의 비용으로 오름차순 정렬
    sort(v.begin(), v.end());

	//각 정점이 포함된 그래프가 어디인지 저장  
    int parent[n];
    for(int i = 0; i < n; i++){
        parent[i] = i;
    }
    
    //거리의 합을 0으로 초기화  
    int sum = 0;
    for(int i = 0; i < v.size(); i++){
    	//사이클이 발생하지 않는 경우 그래프에 포함  
        if(!findParent(parent, v[i].node[0] - 1, v[i].node[1] - 1)){ //노드는 1부터 시작하지만 배열은 0부터 시작. 배열 인덱스에 맞게 노드번호를 입력해주기 위해 정점번호 -1을 수행해 1번 정점을 0번 인덱스에 넣어준다.  
            sum += v[i].distance;
            unionParent(parent, v[i].node[0] - 1, v[i].node[1] - 1);
        }
    }
    
    
    printf("%d\n", sum);
    return 0;
}
 

