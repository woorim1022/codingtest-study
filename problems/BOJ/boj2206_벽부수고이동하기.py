from collections import deque

w, h = map(int, input().split(' '))
map_s = [list(map(int,input().split(' '))) for _ in range(h)]


q = deque()
for i in range(h):
    for j in range(w):
        if map_s[i][j] == 1:
            q.append((i, j))
            map_s[i][j] = 2
            while q:
                cx, cy = q.popleft()
                for k in range(8):
                    nx = cx + dx[k]
                    ny = cy + dy[k]
                    if 0 <= nx < h and 0 <= ny < w:
                        if map_s[nx][ny] == 1:
                            q.append((nx, ny))
                            map_s[nx][ny] = 2
            else:
                cnt += 1
