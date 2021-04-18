# 벽을 3개 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 한다. 위의 지도에서 안전 영역의 크기는 27이다.
# 연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최댓값을 구하는 프로그램을 작성하시오
# 조합, bfs/dfs 사용
from collections import deque

# 세로, 가로
N, M = map(int,input().split(' '))
lab = []
for i in range(N):
    lab.append(list(map(int, input().split(' '))))
count = 0
dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]
answer = []

def virusspread():
    q = deque()
    safezone = 0
    for i in range(N):
        for j in range(M):
            if lab[i][j] == 2:
                q.append([i,j])
    while q:
        cur = q.popleft()
        for i in range(4):
            newN = cur[0] + dx[i]
            newM = cur[1] + dy[i]
            if 0 <= newN < N and 0 <= newM < M:
                if lab[newN][newM] == 0:
                    lab[newN][newM] = 3
                    q.append([newN, newM])

    for i in range(N):
        for j in range(M):
            if lab[i][j] == 0:
                safezone += 1
    answer.append(safezone)
    for i in range(N):
        for j in range(M):
            if lab[i][j] == 3:
                lab[i][j] = 0

def makewall(count):
    # 종료조건
    if count == 3:
        virusspread()
        return
    for i in range(N):
        for j in range(M):
            if lab[i][j] == 0:
                lab[i][j] = 1
                count += 1
                makewall(count)
                lab[i][j] = 0

makewall(count)

print(max(answer))