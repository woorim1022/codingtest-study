#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
//�� �������� ���ļ� ����

bool compare(pair<string, pair<int, int> > a,
             pair<string, pair<int, int> > b){
    if(a.second.first == b.second.first){  //���� ������ ���ٸ� 
        return a.second.second > b.second.second;	//��������� ���� �л��� ���� �켱������ ���� 
    } else{    //������ �ٸ��ٸ� 
        return a.second.first > b.second.first; //������ ���� �л��� ���� �켱������ ���� 
    }
}
int main(void) {
    vector<pair<string, pair<int, int> > > v; //�� ���� �����͸� int�� string���� �����ش�
    v.push_back(pair<string, pair<int, int> >("aaa", pair<int, int>(90, 19961022))); 
    v.push_back(pair<string, pair<int, int> >("bbb", pair<int, int>(85, 19941022))); 
    v.push_back(pair<string, pair<int, int> >("ccc", pair<int, int>(94, 19951022))); 
    v.push_back(pair<string, pair<int, int> >("ddd", pair<int, int>(90, 19981022))); 
    v.push_back(pair<string, pair<int, int> >("eee", pair<int, int>(89, 19931022))); 

    sort(v.begin(), v.end(), compare);

    for(int i =0; i < v.size(); i++){
        cout << v[i].first << ' ;
    }

}
