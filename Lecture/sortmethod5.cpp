#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
//페어를 이중으로 겹쳐서 정렬

bool compare(pair<string, pair<int, int> > a,
             pair<string, pair<int, int> > b){
    if(a.second.first == b.second.first){  //만약 성적이 같다면 
        return a.second.second > b.second.second;	//생년월일이 느린 학생이 높은 우선순위를 가짐 
    } else{    //성적이 다르다면 
        return a.second.first > b.second.first; //성적이 높은 학생이 높은 우선순위를 가짐 
    }
}
int main(void) {
    vector<pair<string, pair<int, int> > > v; //한 쌍의 데이터를 int와 string으로 묶어준다
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
