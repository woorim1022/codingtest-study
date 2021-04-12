# 높이 0 부터 256 까지 257번 for문 돌면서 완탐
# 삼중 for문 257 * 500 * 500 = 64,250,000 시간복잡도 만족
# 시간을 전부 다 비교하지 말고 인벤토리에 들어있는 블록 수가 필요한 블록 수보다 작으면 continue

N, M, B = map(int, input().split(' '))
land = [[0]*M for _ in range(N)]
for i in range(N):
    land[i] = list(map(int,input().split(' ')))

h = [0]*257

ansheight = 0
anstime = 1000000000000000000
for k in range(257):
    add = 0 # 추가해야 하는 블록 개수
    remove = 0 # 제거해야 하는 블록 개수
    for i in range(N):
        for j in range(M):
            if land[i][j] < k:
                # 블록을 추가해야됨
                add += (k-land[i][j])
            elif land[i][j] > k:
                # 블록을 제거해야됨
                remove += (land[i][j]-k)
    inventory = B + remove
    if inventory < add:
        continue
    else:
        time = add + 2*remove
    if time <= anstime:
        anstime = time
        ansheight = k

print(anstime,ansheight)

