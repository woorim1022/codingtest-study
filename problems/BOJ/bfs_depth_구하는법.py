from collections import deque

# 1번
visited = [-1] * (N+1)
queue = deque()
queue.append(start)
visited[start] = 0

while queue:
    cur = queue.popleft()
    # print(cur, end=' ')


    for i in range(1, N+1):
        if graph[cur][i] == 1 and visited[i] == -1:
            queue.append(i)
            visited[i] = visited[cur] + 1
print(visited[1:])

# 2번
queue = deque()
queue.append((3,0))
visited[start] = 1

while queue:
    cur = queue.popleft()   # (node, depth)
    # print(cur, end=' ')
    print(cur, end=' ')

    for i in range(1, N+1):
        if graph[cur[0]][i] == 1 and visited[i] == 0:
            queue.append((i, cur[1] + 1))
            visited[i] = 1
