def solution(brown, yellow):
    answer = []
    temp = brown - 4
    a1 = 2
    a2 = temp - a1
    while a1 <= a2:
        if a1/2 * a2/2 == yellow:
            answer.append(a2/2 + 2)
            answer.append(a1/2 + 2)
            break
        a1+=2
        a2-=2
    return answer