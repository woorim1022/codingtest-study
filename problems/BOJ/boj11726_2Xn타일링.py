dp = [0]*1003
dp[0] = 1
dp[1] = 3

for i in range(n+1):
    dp[i+2] = dp[i+1]%MOD + dp[i]%MOD
    dp[i + 2] %= MOD
print(dp[n-1])