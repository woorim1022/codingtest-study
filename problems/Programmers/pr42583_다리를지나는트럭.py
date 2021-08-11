



#solution 함수의 매개변수로
# 다리에 올라갈 수 있는 트럭 수 bridge_length,
# 다리가 견딜 수 있는 무게 weight,
# 트럭 별 무게 truck_weights가 주어집니다.
# 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록
# solution 함수를 완성하세요.

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