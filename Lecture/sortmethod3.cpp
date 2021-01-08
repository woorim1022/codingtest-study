#include <iostream >
#include <algorithm>
//�����͸� ��� �����ϴ� ���
//��ü�� �����ִ� �����͸� ����
 
using namespace std;

class Student {
	public:
		string name;
		int score;
		Student(string name, int score){  //������ 
			this -> name = name;
			this -> score = score;
		}
		
		//���� ������ '������ ���� ����' 
		bool operator <(Student &student){
			return this->score < student.score;
		}
}; 

bool compare(int a, int b){   
	return a > b; //�������� ����
	//a > b   �������� ���� 
}

int main(void) {
    Student students[] = {
    	Student("aaa", 90),
    	Student("bbb", 93),
    	Student("ccc", 97),
    	Student("ddd", 87),
    	Student("eee", 92)
	};
    
    sort(students, students + 5);  //�迭 �̸�, ���� ������ �ּ�, true/false
    
    for(int i = 0; i < 5; i++){
        cout << students[i].name << ' ';
    }

	return 0;
}
