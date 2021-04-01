n, k = map(int, input().split(' '))
table = input()


eat = [False]*n
cnt = 0
for i in range(n):
    if table[i] == 'P':
        for j in range(-k,k+1):
            if 0 <= i+j < len(table):
                if table[i+j] == 'H' and eat[i+j] == False:
                    eat[i+j] = True
                    cnt += 1
                    break

print(cn)



