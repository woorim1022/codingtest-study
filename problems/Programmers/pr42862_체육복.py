def solution(n, lost, reserve):
    answer = 0
    cloth = [1]*n
    for i in range(len(lost)):
        cloth[lost[i]-1] -= 1
    for i in range(len(reserve)):
        cloth[reserve[i]-1] += 1
    print(cloth)

    for i in range(len(cloth)):
        if cloth[i] ==  0:
            if i > 0 and cloth[i-1] == 2:
                cloth[i] += 1
                cloth[i-1] -= 1
            elif i < len(cloth)-1 and cloth[i+1] == 2:
                cloth[i] += 1
                cloth[i+1] -= 1

    for i in range(len(cloth)):
        if cloth[i] >= 1:
            answer += 1

    return answer