from collections import deque


# 큐에 넣는다
# while문 돌린다
# 매일 progress[i]에 speed[i] 만큼 더한다
# progress[i] == 100 이면 pop

def solution(progresses, speeds):
    answer = []
    que = deque()
    for i in range(len(progresses)):
        que.append([progresses[i], speeds[i]])
    while que:
        for i in range(len(que)):
            que[i][0] = que[i][0] + que[i][1]
        deploy = 0
        isdeploy = False
        while que and que[0][0] >= 100:
            isdeploy = True
            deploy += 1
            que.popleft()
        if isdeploy:
            answer.append(deploy)
    return answer


solution([93, 30, 55], 	[1, 30, 5])