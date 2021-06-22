import heapq


def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)

    while scoville[0] < K:
        # print(scoville[0])
        if len(scoville) >= 2:
            answer += 1
            heapq.heappush(scoville, (heapq.heappop(scoville) + 2 * heapq.heappop(scoville)))
        else:
            answer = -1
            break
        # print(scoville)

    # print(answer)
    return answer