from collections import deque


def bfs(i, j):
    global r, c
    sheep, wolf = 0, 0
    visited[i][j] = True
    que = deque()
    que.append([i, j])
    if list[i][j] == 'o':
        sheep += 1
    elif list[i][j] == 'v':
        wolf += 1
    #### 상하좌우 연결여부 확인하고 너비우선탐색하기
    while que:
        a, b = que.popleft()
        for n in range(4):
            p = a + da[n]
            q = b + db[n]
            if 0 <= p and p < r and 0 <= q and q < c and list[p][q] != '#' and not visited[p][q]:
                visited[p][q] = True
                que.append([p, q])
                if list[p][q] == 'v':
                    wolf += 1
                elif list[p][q] == 'o':
                    sheep += 1
    return sheep, wolf

da = [0, 0, -1, 1]
db = [-1, 1, 0, 0]

r,c = map(int, input().split())
list = [input() for _ in range(r)]

visited = [[False]*c for _ in range(r)]
o, v = 0, 0

for i in range(r):
    for j in range(c):
        if not visited[i][j] and list[i][j] != '#':
            sheep, wolf = bfs(i, j)
            if sheep > wolf:
                o += sheep
            else:
                v += wolf
print(o, v)

