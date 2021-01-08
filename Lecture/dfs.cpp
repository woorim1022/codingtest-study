#include <iostream>
#include <vector>
using namespace std;

//����  �켱 Ž�� (DFS)
//������ ��� 
//���� ��� �߿��� �湮���� ���� ��� �� ���� ���� ��忡 �湮 

int number = 7;
int c[7];
vector<int> a[8];

void dfs(int x){
	if(c[x]) return; //�̹� �湮�� ������ ���� 
    c[x] = true;     //ù��° ��� �湮 ó�� 
    cout << x << ' ';//ù��° ��� ��� 
    for(int i = 0; i < a[x].size(); i++){ //ù��° ����� ���� ���̸�ŭ �ݺ� 
        int y = a[x][i]; //ù��° ���� ����� ��� 
        dfs(y);          //����Լ�   
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
