#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
//벡터 라이브러리와 페어 라이브러리를 이용해 배열과 클래스를 이용했던 방식을 대체 
//소스코드의 길이를 짧게 해주는 기법을 숏코딩 이라고 한다 
//벡터  STL은 배열과 같이 작동하는데 원소를 선택적으로 삽입(push) 및 삭제(pop)할 수 있음 
//페어 STL은 한 쌍의 데이터를 처리할 수 있도록 해주는 자료구조 
int main(void) {
    vector<pair<int, string> > v; //한 쌍의 데이터를 int와 string으로 묶어준다
    v.push_back(pair<int, string>(90, "aaa")); //벡터에 데이터 삽입 
    v.push_back(pair<int, string>(93, "bbb"));
    v.push_back(pair<int, string>(87, "ccc"));
    v.push_back(pair<int, string>(98, "ddd"));
    v.push_back(pair<int, string>(79, "eee"));
    
    sort(v.begin(), v.end());

    for(int i = 0; i < v.size(); i++){
        cout << v[i].second << ' ';
    }
}
