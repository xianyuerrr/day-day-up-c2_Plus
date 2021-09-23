def func():
    s, m = input().split()
    m = int(m)
    n = len(s)
    dp = [float('inf')] * (n)
    dp[0] = 0
    lis = [0] * n
    lis[0] = 0
    
    for i in range(1, n):
        v = abs(ord(s[i]) - ord(s[i-1]))
        lis[i] = min(v, 26-v)
        dp[i] = min(dp[i], dp[i-1]+lis[i])
        # 应该是不能把 第一个字母 算在连续的m个序列里的
        if i >= m-1:
            # 比如 m=2, i = 3
            # 1-2-3
            # dp[3] = min(dp[3], dp[1] + m)
            dp[i] = min(dp[i], (dp[i-m] if i-m >= 0 else 0) + m)
    print(dp)
    print(dp[-1]+n)
    return
func()

# ADDA 2
# 9

# ACAC 2
# 8