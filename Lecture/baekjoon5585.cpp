//�׸��� �˰���
//���� �� �տ� ���̴� ������ ��Ȳ���� �Ѵ� �˰���
//�׻� ������ ����� �����ϴ� ���� �ƴ����� ��� ���� ������ �ؾ� �ٻ��� ���� ���� �� ����
//��ǥ �� �� : �Ž��� �� ����
#include <iostream>

using namespace std;

int main(void){
    int n, result = 0;
    cin >> n;
    n = 1000 - n;
    result += n / 500;
    n = n % 500;
    result += n / 100;
    n = n % 100;
    result += n / 50;
    n = n % 50;
    result += n / 10;
    n = n % 10;
    result += n / 5;
    n = n % 5;
    result += n;
    cout << result;
    return 0 ;

}
