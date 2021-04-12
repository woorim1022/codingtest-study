# a의 자리수를 p만큼 곱해서 다음 수를 구한다
# if 다음 수가 수열 리스트에 존재하면,
# while문 벗어나

# 마지막에 비교한 숫자~리스트 마지막 값까지 제거
# 나머지 출력

# 시간복잡도

a, p = map(int, input().split(' '))

anslist = [a]

while True:
    val = 0
    while a:
        val += ((a % 10) ** p)
        a //= 10
    a = val
    if val in anslist:
        break
    else:
        anslist.append(val)

for i in range(len(anslist)):
    if anslist[i] == a:
        answer = anslist[0:i]

print(len(answer))
