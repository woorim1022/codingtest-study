# 큰 수의 법칙


# 서로 다른 인덱스에 해당하는 수가 같은 경우에도 서로 다른 것으로 간주한다. 예를 들어
# 순서대로 3,4,3,4,5으로 이루어진 배열이 있을 때 M이 7이고, K가 2라고 가정하자.
# 이 경우 두 번째 원소에 해당하는 4와 네 번째 원소에 해당하는 4를 번갈아 두 번씩 더하는 것이
# 가능하다.

# N개의 자연수(배열의 크기)
# 2 <= N <= 1,000

# 숫자가 더해지는 횟수
# 1 <= M <= 10,000

# 특정한 인덱스에 해당하는 수가 연속으로 더해질 수 있는 최대의 수
# 1 <= K <= 10,000

n, m, k = list(map(int, input().split(' ')))
num = list(map(int, input().split(' ')))

# num을 크기가 큰 순서대로 정렬한다
# 인덱스 0의 숫자를 k번 더해주고 인덱스 1의 숫자를 1번 더해주는 것을
# 더한 횟수가 m이 될때까지 반복

# 내림차순으로 정렬
num.sort(reverse=True)

answer = 0
bc = 0
# m번 반복해서 더해주자
for _ in range(m):
    if bc < k:
        bc += 1
        answer += num[0]
        list.append(num[0])
    else:
        answer += num[1]
        bc = 0
        list.append(num[1])

print(answer)