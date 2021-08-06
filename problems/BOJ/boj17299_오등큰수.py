












N = int(input())
A = list(map(int, input().split(' ')))
count = [0]*1001  # [F(A[i]), 가장오른쪽인덱스]
ans = [-1]*N

for i in range(N):
    count[A[i]] += 1
print(count)
stack = [0]
for i in range(N):
    if count[A[i]] > stack[-1]:
        stack.pop()
