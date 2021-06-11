def solution(numbers):
    answer = ''
    while not -1 in numbers:
        maxfront = 0
        for i in numbers:
            th = i // 1000
            hn = i % 1000 // 100
            tn = i % 1000 % 100 // 10
            on = i % 1000 % 100 % 10
            if th > maxfront:
                maxfront = i
            elif hn > maxfront:
                maxfront = i
            elif tn > maxfront:
                maxfront = i
            elif on > maxfront:
                maxfront = i
        answer += str(maxfront)
        numbers[numbers.index(maxfront)] = -1

    return answer