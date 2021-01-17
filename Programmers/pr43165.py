answer = 0

def func(numbers, v, sum, target):
    global answer
    if v == len(numbers):
        if sum == target:
            answer += 1
            return
        else:
            return
    func(numbers, v+1, sum + (-1*numbers[v]), target)
    func(numbers, v+1, sum + numbers[v], target)


numbers = [1,1,1,1,1]
target = 3

func(numbers, 0, 0, target)

print(answer)