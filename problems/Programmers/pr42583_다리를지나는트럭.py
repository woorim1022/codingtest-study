

from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 1
    tw = deque(truck_weights)
    q = deque()
    cur = 0
    while True:
        if len(q) < bridge_length and tw and cur+tw[0] <= weight:
            cur += tw[0]
            q.append([tw.popleft(),0])
        for i in range(len(q)):
            q[i][1] += 1
        if q[0][1] == bridge_length:
            cur -= q[0][0]
            q.popleft()


        answer += 1
        if not q and not tw:
            break
    print(answer)
    return answer



solution(100, 100, [10])