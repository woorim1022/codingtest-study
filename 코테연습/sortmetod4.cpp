#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
//���� ���̺귯���� ��� ���̺귯���� �̿��� �迭�� Ŭ������ �̿��ߴ� ����� ��ü 
//�ҽ��ڵ��� ���̸� ª�� ���ִ� ����� ���ڵ� �̶�� �Ѵ� 
//����  STL�� �迭�� ���� �۵��ϴµ� ���Ҹ� ���������� ����(push) �� ����(pop)�� �� ���� 
//��� STL�� �� ���� �����͸� ó���� �� �ֵ��� ���ִ� �ڷᱸ�� 
int main(void) {
    vector<pair<int, string> > v; //�� ���� �����͸� int�� string���� �����ش�
    v.push_back(pair<int, string>(90, "aaa")); //���Ϳ� ������ ���� 
    v.push_back(pair<int, string>(93, "bbb"));
    v.push_back(pair<int, string>(87, "ccc"));
    v.push_back(pair<int, string>(98, "ddd"));
    v.push_back(pair<int, string>(79, "eee"));
    
    sort(v.begin(), v.end());

    for(int i = 0; i < v.size(); i++){
        cout << v[i].second << ' ';
    }
}
