import sys
# depth 깊이 지정해주는 코드
sys.setrecursionlimit(100000)

dp = [0]*1002

def tiles(n):
    if n == 1:
        return 1
    if n == 2:
        return 2
    if dp[n-1] == 0:
        dp[n-1] = tiles(n-1)
    if dp[n-2] == 0:
        dp[n-2] = tiles(n-2)
    return dp[n-2] + dp[n-1]


n = int(input())
print(tiles(n)%10007)