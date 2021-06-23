import heapq
from itertools import permutations

def solution(jobs):
    answer = 0
    heap = []
    # 순열로 모든 경우를 구해서 걸리는 시간을 구한다
    diskorder = list(permutations(jobs,len(jobs)))
    #print(diskorder)
    totaltime = 0
    for i in range(len(diskorder)):
        if diskorder[i][0][0] > totaltime:
            start = diskorder[i][0][0]
        else:
            start = totaltime
        totaltime = start + diskorder[i][0][1]
    heapq.heappush(heap,totaltime/len(jobs))
    print(heap)

    return int(heapq.heappop(heap))


solution([[0, 3], [1, 9], [2, 6]])


#
#
# import heapq
#
# jobs = [[0, 3], [1, 9], [2, 6]]
#
# def solution(jobs):
#     # now 현재 시점
#     answer, now, i = 0,0,0
#     # start 이전에 완료한 작업의 시작 시간
#     start = -1
#     heap = []
#
#     while i < len(jobs) :
#         for j in jobs :
#             if start < j[0] <= now :
#                 # 반대로 뒤집어서 heapq에 들어가게 된다. -> 작업의 소요 시간이 적은게 먼저 pop되게 된다.
#                 # 최소힙은 root node는 최소값이니까!
#                 heapq.heappush(heap, [j[1], j[0]])
#         # heap에 들어가 있으면 실행(처리할 작업이 있는 상태)
#         if len(heap) > 0 :
#             current = heapq.heappop(heap)
#             start = now
#             now += current[0]
#             # 현재 시점 - 작업이 요청되는 시점 = 요청부터 종료까지
#             answer += (now - current[1])
#             i += 1
#         else :
#             # 처리할 작업이 없는 상태
#             now += 1
#     return int(answer / len(jobs))
#
#
# solution(jobs)








# 힙 안쓴 풀이
#
# from heapq import *
#
# def solution(jobs):
#     answer = 0
#     start = 0  # 현재까지 진행된 작업 시간
#     length = len(jobs)
#
#     jobs = sorted(jobs, key=lambda x: x[1])  # 소요시간 우선 정렬
#
#     while len(jobs) != 0:
#         for i in range(len(jobs)):
#             if jobs[i][0] <= start:
#                 start += jobs[i][1]
#                 answer += start - jobs[i][0]
#                 jobs.pop(i)
#                 break
#             # 해당시점에 아직 작업이 들어오지 않았으면 시간 ++
#             if i == len(jobs) - 1:
#                 start += 1
#
#     return answer // length