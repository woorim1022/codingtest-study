/*
- int arr1[5] = { 1, 2, 3 }; // 배열의 요소들은 { 1, 2, 3, 0, 0 } 으로 초기화 됨
- int arr2[5]; // 배열의 요소들은 모두 쓰레기값으로 초기화 됨
- int arr3[10] = { 0 }; // 배열의 요소들은 모두 0으로 초기화 됨
배열은 일반 변수와 같이 자료형(type)을 먼저 선언하고 배열의 이름(기본적으로 arr 또는 ary 등을 사용합니다)을
명시해준 후, 대괄호( ' [ ' , ' ] ' )를 사용해서 배열의 크기를 지정해 줍니다. 
이때 배열의 크기는 고정된 상수(양의 정수형 숫자)여야 하며 일반 변수를 지정해 줄 수 없습니다.
배열 요소의 자료형은 int(정수)형을 포함, 모든 기본 자료형(char, double 등)을 지원합니다.
또한 아래와 같이 크기를 명시 해 주지않고 배열의 요소를 모두 정의할 수 있습니다.
int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };


배열의 이름은 배열의 시작주소이다
    arr = &arr[0] 
    arr[2] = *(arr + 2)


배열의 크기를 동적으로 만드는 방법
    int *p; // 포인터 변수 선언
    int arr_size; // 배열의 크기를 입력받을 변수
    cin >> arr_size; // 배열의 크기를 입력받음
    p = new int[arr_size]; // 입력받은 크기만큼 배열을 동적 생성
    delete[] p; // 사용이 끝난 후 메모리 해제




벡터 사용법
        vector<int> integer_vector;
        vector<double> double_vector;
        vector<char> char_vector;
    벡터에 데이터 추가하기
        for (int i = 0; i < 5; i++) {
            integer_vector.push_back(i);
            double_vector.push_back((double)i);
            char_vector.push_back('a' + i);
        }
        벡터 클래스에서 push_back() 함수를 이용하여 요소의 끝에 데이터를 추가할 수 있습니다.
        지정된 위치에 요소를 추가하려면 insert() 함수를 사용하세요.
    벡터의 데이터 삭제하기
        integer_vector.pop_back(); // 요소 끝의 데이터 삭제
        double_vector.erase(double_vector.begin()); // 지정된 위치의 데이터 삭제
        char_vector.clear(); // 모든 데이터 삭제

    벡터는 다음과 같은 내부 함수가 존재합니다.
        begin() - 벡터의 첫번째 요소를 가리킵니다.
        end() - 벡터의 마지막 요소를 가리킵니다.
        size() - 벡터의 요소 수(크기)를 반환합니다.
        resize() - 벡터의 크기를 재조정합니다.
        empty() - 벡터가 비어있는지 여부(true or false)를 반환합니다.
        at() (또는 [ ]) - 벡터의 인덱스에 접근할 수 있습니다.
        front() - 벡터의 첫번째 요소를 반환합니다.
        back() - 벡터의 마지막 요소를 반환합니다.
        data() - 포인터가 접근할 수 있도록 벡터의 주소값을 반환합니다( int *p = vector1.data() )


*/
#include <iostream>
#define endl '\n'
using namespace std;

//구조체
struct CCTV{
    int type, r, c; // cctv 번호, 위치
};
// 전역변수
int N, M, ans = 1e9;
int map[8][8];
int cctv_size;
CCTV cctv[8];
const int rotation[] = {NULL, 4, 2, 4, 4, 1};


void map_cpy(int desc[8][8], int src[8][8]){
    for(int r = 0; r < N; r++){
        for(int c = 0 ; c < M; c++){
            desc[r][c] = src[r][c];
        }
    }
}
// update 함수는 한 방향으로만 감시를 해주는 함수
void update(int dir, CCTV cctv){
    // cctv를 기준으로 dir 방향에 대한 체크를 한다.
    // dir = 0 : 동, 1 : 북, 2 : 서, 3 : 남
    dir %= 4;    // dir값이 4보다 큰 값이 들어올 수 있으므로

    if(dir == 0){   // 동쪽
        for(int c = cctv.c + 1; c < M; c++){
            if(map[cctv.r][c] == 6) break;
            map[cctv.r][c] = -1;
        }
    }
    else if(dir == 1){   // 북쪽
        for(int r = cctv.r - 1; r >= 0; r--){
            if(map[r][cctv.c] == 6) break;
            map[r][cctv.c] = -1;
        }
    }
    else if(dir == 2){   // 서쪽
        for(int c = cctv.c - 1; c >= 0; c--){
            if(map[cctv.r][c] == 6) break;
            map[cctv.r][c] = -1;
        }
    }
    else if(dir == 3){   // 남쪽
        for(int r = cctv.r + 1; r < N; r++){
            if(map[r][cctv.c] == 6) break;
            map[r][cctv.c] = -1;
        }
    }

}

void dfs(int cctv_idx){
    // 기저조건
    if(cctv_idx == cctv_size){
        int cnt = 0;
        // 0의 개수 count
        for(int r = 0; r < N; r++){
            for(int c = 0 ; c < M; c++){
                if(map[r][c] == 0)
                    ++cnt;
            }
        }
        if(ans > cnt)
            ans = cnt;
        return;
    }


    int backup[8][8];
    int type = cctv[cctv_idx].type;

    for(int dir = 0; dir < rotation[type]; ++dir){
        //map 백업
        map_cpy(backup, map);
        //map 업데이트 
        //update 함수는 한 방향만 갱신하는 함수
        //따라서 이 함수를 필요에 맞게 호출해 주면 됨
        if(type == 1){                  // 1번 카메라는 한 방향 감시이니 하나만 불러줌
            update(dir, cctv[cctv_idx]);
        }
        else if(type == 2){             // 2번 카메라는 기본방향과 그 180도 반대방향을 감시함
            update(dir, cctv[cctv_idx]);
            update(dir+2, cctv[cctv_idx]);
        }
        else if(type == 3){             // 3번 카메라는 기본방향과 90도 방향을 감시함
            update(dir, cctv[cctv_idx]);
            update(dir+1, cctv[cctv_idx]);
        }
        else if(type == 4){             // 4번 카메라는 기본방향과 90도, 180도 방향을 감시함
            update(dir, cctv[cctv_idx]);
            update(dir+1, cctv[cctv_idx]);
            update(dir+2, cctv[cctv_idx]);
        }
        else if (type == 5){            // 5번 카메라는 전 방향 모두 감시함
            update(dir, cctv[cctv_idx]);
            update(dir+1, cctv[cctv_idx]);
            update(dir+2, cctv[cctv_idx]);
            update(dir+3, cctv[cctv_idx]);
        }
        // 다음 cctv로 넘어간다
        dfs(cctv_idx + 1);

        // map 복원 - 백트래킹
        map_cpy(map, backup);
    }
}



int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;
    for (int r = 0; r < N; r++)
    {                                               
        for (int c = 0; c < M; c++)
        {
            cin >> map[r][c];
            if (map[r][c] != 0 && map[r][c] != 6)
            {
                cctv[cctv_size].r = r;
                cctv[cctv_size].c = c;
                cctv[cctv_size].type = map[r][c];
                ++cctv_size;
            }
        }
    }
    dfs(0);
    cout << ans << endl;
    return 0;
}
