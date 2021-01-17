def func(computers, visited, start, n):
    visited[start] = True
    for i in range(n):
        if not visited[i] and computers[start][i] == 1:
            func(computers, visited, i, n)

n = 3
computers = [[1, 1, 0], [1, 1, 0], [0, 0, 1]]
answer = 0
visited = [False] * n

for i in range(len(computers)):
    if not visited[i]:
        answer += 1
        func(computers, visited, i, n)

print(answer)