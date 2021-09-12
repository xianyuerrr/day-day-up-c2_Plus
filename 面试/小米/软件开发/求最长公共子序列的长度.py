def myFunc():
    # s1, s2 = list(map(lambda x : x[1:-1], input().split(',')))
    s1 = input()
    s2 = input()
    m, n = len(s1), len(s2)
    res = 0
    dp = [[0] * n for _ in range(m)]
    for i in range(m):
        for j in range(n):
            if s1[i] == s2[j]:
                dp[i][j] = max(dp[i][j], (dp[i-1][j-1] if i > 0 and j > 0 else 0) + 1)
                res = max(res, dp[i][j])
            else:
                dp[i][j] = max(dp[i-1][j] if i > 0 else 0, dp[i][j-1] if j > 0 else 0)

    print(dp[-1][-1])
myFunc()