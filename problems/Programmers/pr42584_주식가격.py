from collections import deque


def solution(prices):
    answer = []
    q = deque(prices)
    for i in range(len(prices)):
        if prices[i] > min(prices):
            answer.append(len(prices) - (lambda x: prices[x] < prices[i],  range(i+1,len(prices))) - (i + 1))
        else:
            answer.append(len(prices) - (i + 1))

    return answer



solution([1, 2, 3, 2, 3])