def solution(answers):
    answer = []
    supo = [
        [1, 2, 3, 4, 5],
        [2, 1, 2, 3, 2, 4, 2, 5],
        [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    ]
    correct = [0, 0, 0]

    for i in range(len(answers)):
        for j in range(3):
            if answers[i] == supo[j][i % len(supo[j])]:
                correct[j] += 1

    print(correct)

    maxcor = -1
    for i in range(3):
        if correct[i] == maxcor:
            answer.append(i + 1)
        elif correct[i] > maxcor:
            answer.clear()
            answer.append(i + 1)
            maxcor = correct[i]

    return answer
