def solution(m, n, puddles):
    answer = 0
    dp = [[1] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            # 왼쪽 인덱스가 0보다 같거나 크고 puddle에 i, j 가 없으면
            if (i - 1) >= 0 and [i - 1, j] not in puddles:
                dp[i][j] += dp[i - 1][j]
            # 위쪽 인덱스가 0보다 같거나 크고 puddle에 i, j 가 없으면
            if (j - 1) >= 0 and [i, j - 1] not in puddles:
                dp[i][j] += dp[i][j - 1]
    print(dp[n-1][m-1])
    return dp[n-1][m-1]

solution(4,3,[[2,2]])