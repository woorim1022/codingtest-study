#include <iostream>
#include <queue>
#include <vector>
using namespace std;

//�ʺ� �켱 Ž�� (BFS)
//�Ÿ��� ������ ������� ����ϴ°� 
//���� ��带 ť�� ����
//���� ��带 �湮 ó��
//ť���� �ϳ��� ��带 ������
//�ش� ��忡 ����� ��� �� �湮���� ���� ��带 �湮�ϰ�, ���ʴ�ȣ���� ť�� ����
//�� �� ������ �踮���ؼ� �ݺ�  

int number = 7;
int c[7];
vector<int> a[8];

void bfs(int start){    //ù��° ���  
	queue<int> q;
	q.push(start);       //ť�� ù��° ��� ����  
	c[start] = true;     //ù��° ��� �湮 ó�� 
	while(!q.empty()){   //ť�� ������� ������ �ݺ� 
		int x = q.front();  //ù ��° ���  
		q.pop();            //ù��° ��� ������ 
		printf("%d ", x);   //ù��° ��� ��� 
		for(int i= 0; i < a[x].size(); i++){   //ù ��° ��� ������ ���̸�ŭ �ݺ� 
			int y = a[x][i];                   //ù��° ���� ����� ��� 
			if(!c[y]){                         //��忡 ���� �湮���� �ʾ����� 
				q.push(y);                     //ť�� ���� 
				c[y] = true;                   //�湮 ó 
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
