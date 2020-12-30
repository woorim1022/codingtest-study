#include <iostream>
#include <stack>
using namespace std; 

//스택은 택배 상하차
//큐는 은행 창구 

int main(void){
	stack<int> s;
	s.push(7);
	s.push(5);
	s.push(4);
	s.pop();
	s.push(6);
	s.pop();
	
	while(!s.empty()){
		cout << s.top() << ' ';
		s.pop();
	}
	return 0;
}
