#include <iostream >
#include <algorithm>
//데이터를 묶어서 정렬하는 방법
//객체로 묶여있는 데이터를 정렬
 
using namespace std;

class Student {
	public:
		string name;
		int score;
		Student(string name, int score){  //생성자 
			this -> name = name;
			this -> score = score;
		}
		
		//정렬 기준은 '점수가 작은 순서' 
		bool operator <(Student &student){
			return this->score < student.score;
		}
}; 

bool compare(int a, int b){   
	return a > b; //오름차순 정렬
	//a > b   내림차순 정렬 
}

int main(void) {
    Student students[] = {
    	Student("aaa", 90),
    	Student("bbb", 93),
    	Student("ccc", 97),
    	Student("ddd", 87),
    	Student("eee", 92)
	};
    
    sort(students, students + 5);  //배열 이름, 가장 마지막 주소, true/false
    
    for(int i = 0; i < 5; i++){
        cout << students[i].name << ' ';
    }

	return 0;
}
