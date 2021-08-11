from collections import deque

def solution(priorities, location):
    answer = 0
    que = deque()
    for i in range(len(priorities)):
        que.append([priorities[i],i])
    #print(que)
    while len(que):
        j, idx = que.popleft()
        maxp = 0
        for k in range(len(que)):
            if que[k][0] > maxp:
                maxp = que[k][0]
        if len(que) != 0 and maxp > j:
            que.append([j,idx])
        else:
            answer += 1
            if idx == location:
                break
        #print(que)
    return answer