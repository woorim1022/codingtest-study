/*
- int arr1[5] = { 1, 2, 3 }; // �迭�� ��ҵ��� { 1, 2, 3, 0, 0 } ���� �ʱ�ȭ ��
- int arr2[5]; // �迭�� ��ҵ��� ��� �����Ⱚ���� �ʱ�ȭ ��
- int arr3[10] = { 0 }; // �迭�� ��ҵ��� ��� 0���� �ʱ�ȭ ��
�迭�� �Ϲ� ������ ���� �ڷ���(type)�� ���� �����ϰ� �迭�� �̸�(�⺻������ arr �Ǵ� ary ���� ����մϴ�)��
������� ��, ���ȣ( ' [ ' , ' ] ' )�� ����ؼ� �迭�� ũ�⸦ ������ �ݴϴ�. 
�̶� �迭�� ũ��� ������ ���(���� ������ ����)���� �ϸ� �Ϲ� ������ ������ �� �� �����ϴ�.
�迭 ����� �ڷ����� int(����)���� ����, ��� �⺻ �ڷ���(char, double ��)�� �����մϴ�.
���� �Ʒ��� ���� ũ�⸦ ��� �� �����ʰ� �迭�� ��Ҹ� ��� ������ �� �ֽ��ϴ�.
int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };


�迭�� �̸��� �迭�� �����ּ��̴�
    arr = &arr[0] 
    arr[2] = *(arr + 2)


�迭�� ũ�⸦ �������� ����� ���
    int *p; // ������ ���� ����
    int arr_size; // �迭�� ũ�⸦ �Է¹��� ����
    cin >> arr_size; // �迭�� ũ�⸦ �Է¹���
    p = new int[arr_size]; // �Է¹��� ũ�⸸ŭ �迭�� ���� ����
    delete[] p; // ����� ���� �� �޸� ����




���� ����
        vector<int> integer_vector;
        vector<double> double_vector;
        vector<char> char_vector;
    ���Ϳ� ������ �߰��ϱ�
        for (int i = 0; i < 5; i++) {
            integer_vector.push_back(i);
            double_vector.push_back((double)i);
            char_vector.push_back('a' + i);
        }
        ���� Ŭ�������� push_back() �Լ��� �̿��Ͽ� ����� ���� �����͸� �߰��� �� �ֽ��ϴ�.
        ������ ��ġ�� ��Ҹ� �߰��Ϸ��� insert() �Լ��� ����ϼ���.
    ������ ������ �����ϱ�
        integer_vector.pop_back(); // ��� ���� ������ ����
        double_vector.erase(double_vector.begin()); // ������ ��ġ�� ������ ����
        char_vector.clear(); // ��� ������ ����

    ���ʹ� ������ ���� ���� �Լ��� �����մϴ�.
        begin() - ������ ù��° ��Ҹ� ����ŵ�ϴ�.
        end() - ������ ������ ��Ҹ� ����ŵ�ϴ�.
        size() - ������ ��� ��(ũ��)�� ��ȯ�մϴ�.
        resize() - ������ ũ�⸦ �������մϴ�.
        empty() - ���Ͱ� ����ִ��� ����(true or false)�� ��ȯ�մϴ�.
        at() (�Ǵ� [ ]) - ������ �ε����� ������ �� �ֽ��ϴ�.
        front() - ������ ù��° ��Ҹ� ��ȯ�մϴ�.
        back() - ������ ������ ��Ҹ� ��ȯ�մϴ�.
        data() - �����Ͱ� ������ �� �ֵ��� ������ �ּҰ��� ��ȯ�մϴ�( int *p = vector1.data() )


*/
#include <iostream>
#define endl '\n'
using namespace std;

//����ü
struct CCTV{
    int type, r, c; // cctv ��ȣ, ��ġ
};
// ��������
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
// update �Լ��� �� �������θ� ���ø� ���ִ� �Լ�
void update(int dir, CCTV cctv){
    // cctv�� �������� dir ���⿡ ���� üũ�� �Ѵ�.
    // dir = 0 : ��, 1 : ��, 2 : ��, 3 : ��
    dir %= 4;    // dir���� 4���� ū ���� ���� �� �����Ƿ�

    if(dir == 0){   // ����
        for(int c = cctv.c + 1; c < M; c++){
            if(map[cctv.r][c] == 6) break;
            map[cctv.r][c] = -1;
        }
    }
    else if(dir == 1){   // ����
        for(int r = cctv.r - 1; r >= 0; r--){
            if(map[r][cctv.c] == 6) break;
            map[r][cctv.c] = -1;
        }
    }
    else if(dir == 2){   // ����
        for(int c = cctv.c - 1; c >= 0; c--){
            if(map[cctv.r][c] == 6) break;
            map[cctv.r][c] = -1;
        }
    }
    else if(dir == 3){   // ����
        for(int r = cctv.r + 1; r < N; r++){
            if(map[r][cctv.c] == 6) break;
            map[r][cctv.c] = -1;
        }
    }

}

void dfs(int cctv_idx){
    // ��������
    if(cctv_idx == cctv_size){
        int cnt = 0;
        // 0�� ���� count
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
        //map ���
        map_cpy(backup, map);
        //map ������Ʈ 
        //update �Լ��� �� ���⸸ �����ϴ� �Լ�
        //���� �� �Լ��� �ʿ信 �°� ȣ���� �ָ� ��
        if(type == 1){                  // 1�� ī�޶�� �� ���� �����̴� �ϳ��� �ҷ���
            update(dir, cctv[cctv_idx]);
        }
        else if(type == 2){             // 2�� ī�޶�� �⺻����� �� 180�� �ݴ������ ������
            update(dir, cctv[cctv_idx]);
            update(dir+2, cctv[cctv_idx]);
        }
        else if(type == 3){             // 3�� ī�޶�� �⺻����� 90�� ������ ������
            update(dir, cctv[cctv_idx]);
            update(dir+1, cctv[cctv_idx]);
        }
        else if(type == 4){             // 4�� ī�޶�� �⺻����� 90��, 180�� ������ ������
            update(dir, cctv[cctv_idx]);
            update(dir+1, cctv[cctv_idx]);
            update(dir+2, cctv[cctv_idx]);
        }
        else if (type == 5){            // 5�� ī�޶�� �� ���� ��� ������
            update(dir, cctv[cctv_idx]);
            update(dir+1, cctv[cctv_idx]);
            update(dir+2, cctv[cctv_idx]);
            update(dir+3, cctv[cctv_idx]);
        }
        // ���� cctv�� �Ѿ��
        dfs(cctv_idx + 1);

        // map ���� - ��Ʈ��ŷ
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
