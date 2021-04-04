# 문제
# N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다.
# 당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 최단경로는 맵에서 가장 적은 개수의
# 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.
#
# 만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 한 개 까지 부수고 이동하여도 된다.
#
# 한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.
#
# 맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.
#
# 입력
# 첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다.
# (1, 1)과 (N, M)은 항상 0이라고 가정하자.
#
# 출력
# 첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.



# 아이디어
# 전체 경우의 수 탐색 - 부루트포스
# 상하좌우로 벽이 아니면 이동 or 아직 벽 안부쉈으면 벽 부수고 이동
# deque에 푸쉬할 때 현재까지의 이동거리도 같이 푸쉬
# 좌표가 (N, M)일 때까지 반복(for문)

from collections import deque

dx = [-1,0,1,0]
dy = [0,1,0,-1]
move = []

def bfs(mapp):
    global dx, dy
    # N, M, 벽부순여부, 이동거리
    q = deque()
    q.append((0,0,0,0))
    visited[0][0][0] = 1
    while q:
        cn, cm, crash, dist = q.popleft()
        if cn == N and cm == M:
            move.append(dist)
        for k in range(4):
            nx = cn + dx[k]
            ny = cm + dy[k]
            if 0 <= nx < N and 0 <= ny < M:
                # 벽이 아니고 벽 아직 안부셨으면
                if mapp[nx][ny] == 0  and visited[nx][ny][0] == 0:
                    visited[nx][ny][0] = 1
                    q.append((nx, ny, 0, dist+1))
                # 벽이 아니고 벽 부셨으면
                elif mapp[nx][ny] == 0 and crash == 1 and visited[nx][ny][1] == 0:
                    visited[nx][ny][1] = 1
                    q.append((nx, ny, 1, dist+1))
                # 벽이고 아직 안부셨으면
                elif mapp[nx][ny] == 1 and crash == 0 and visited[nx][ny][0] == 0:
                    visited[nx][ny][1] = 1
                    q.append((nx, ny, 1, dist+1))




N, M = map(int, input().split(' '))
mapp = [list(map(int,input().strip())) for _ in range(N)]
visited = [[[0]*2]*M for _ in range(N)]
bfs(mapp)
print(move)


