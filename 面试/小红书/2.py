mod = pow(10, 9) + 7

m, n, k = list(map(int, input().split()))

dp1 = [0 for _ in range(n)]
dp2 = [0 for _ in range(n)]

stones = set()

for i in range(k):
    x, y = list(map(int, input().split()))
    stones.add((x-1, y-1))

dp2[0] = 1
for i in range(m):
    for j in range(n):
        if (i == 0 and j == 0) or (i, j) in stones:
            continue
        dp2[j] = (dp1[j] if i-1 >= 0 and ((i-1, j) not in stones) else 0) + \
            (dp2[j-1] if j-1 >= 0 and (i, j-1) not in stones else 0)
        dp2[j] %= mod
    dp1, dp2 = dp2, dp1
print(dp1[n-1])

# mod = pow(10, 9) + 7

# m, n, k = list(map(int, input().split()))

# dp = [[0 for _ in range(n)] for __ in range(m)]

# for i in range(k):
#     x, y = list(map(int, input().split()))
#     dp[x-1][y-1] = -1

# dp[0][0] = 1
# for i in range(m):
#     for j in range(n):
#         if (i == 0 and j == 0) or dp[i][j] == -1:
#             continue
#         dp[i][j] = (dp[i-1][j] if i-1 >= 0 and dp[i-1][j] != -1 else 0) + \
#             (dp[i][j-1] if j-1 >= 0 and dp[i][j-1] != -1 else 0)
#         dp[i][j] %= mod

# # print(dp)
# print(dp[m-1][n-1])
