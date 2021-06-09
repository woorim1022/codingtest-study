dx = [-1,-1,-1,0,0,1,1,1]
dy = [-1,0,1,-1,1,-1,0,1]

N, M, K = map(int, input().split(' '))
# 각 칸에 추가되는 양분의 양
nutrition = [list(map(int,input().split(' '))) for _ in range(N)]
# 나무가 심겨진 위치 (x,y)와 나이
# (x,y)이면 인덱스는 x-1, y-1이다.
tree = [list(map(int,input().split(' '))) for _ in range(M)]
# 현재 땅에 있는 양분의 양
land = [[5]*N for _ in range(N)]
# 각 좌표에 들어가있는 나무들의 나이(실제 농장의 모습)
pos = [[[]*N for _ in range(N)] for i in range(N)] # 3차원 배열 만드는법

print(nutrition)
print(tree)
print(land)

# pos에 나무를 심어준다
for i in range(len(tree)):
    pos[tree[i][0] - 1][tree[i][1] - 1].append(tree[i][2])

#같은 위치의 나무를 나이순으로 정렬
for i in range(len(pos)):
    for j in range(len(pos[i])):
        pos[i][j].sort()

print('--------')
for i in pos:
    print(i)

# 봄, 여름
for i in range(len(pos)):
    for j in range(len(pos[i])):
        for k in range(len(pos[i][j])):
            # 양분이 나이만큼 남아있으면
            if pos[i][j][k] <= land[i][j]:
                land[i][j] -= pos[i][j][k]
                pos[i][j][k] += 1
            # 양분이 부족하면
            else:
                # 나무 죽었다고 표시
                land[i][j] += pos[i][j][k]//2
                pos[i][j][k] = -1

print('--------')
for i in pos:
    print(i)

for i in range(len(pos)):
    for j in range(len(pos[i])):
        if -1 in pos[j]:
            pos[j].remove(-1)

print('--------')
for i in pos:
    print(i)

# 가을
for i in range(N):
    for j in range(N):
        # pos 의 길이가 for문 안에서 늘어나고있음, 비어있음 --> 확인
        if pos[i][j]:
            for k in range(len(pos[i][j])):
                # 나무의 나이가 5의 배수이면
                if pos[i][j][k] % 5 == 0:
                    for i in range(8):
                        if 0<=i+dx[i]<N and 0<=j+dy[i]<N:
                            pos[i+dx[i]][j+dy[i]].append(1)

# 겨울
for i in range(len(land)):
    for j in range(len(land[i])):
            land[i][j] += nutrition[i][j]

# 4.
# 겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가한다. 각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.




