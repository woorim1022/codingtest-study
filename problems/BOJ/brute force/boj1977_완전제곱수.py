m = int(input())
n = int(input())

sum = 0
min = 10000
for i in range(1,n+1):
    sq = i**2
    if sq < m:
        continue
    elif sq >= m and sq <= n :
        sum += sq
        if sq < min:
            min = sq
    else:
        break

if sum == 0:
    print(-1)
else:
    print(sum)
    print(min)
