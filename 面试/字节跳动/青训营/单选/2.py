dp = [0] * 51
dp[0] = 1
dp[1] = 1
for i in range(2, 51):
    dp[i] = dp[i-1] + dp[i-2]
print(dp[50])