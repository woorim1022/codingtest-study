
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
