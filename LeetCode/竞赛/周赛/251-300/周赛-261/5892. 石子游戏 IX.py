class Solution:
    def stoneGameIX(self, stones: List[int]) -> bool:
        # 移除任一石子，看错题了
        n = len(stones)
        if n <= 1:
            return False
        ssum = sum(stones)
        flag = ssum % 3 == 0
        dp = [[0] * n for _ in range(n)]
        ddp = [[False] * n for _ in range(n)]
        for i in range(n):
            dp[i][i] = ssum - stones[i]
            ddp[i][i] = ssum % 3 != 0
        for i in range(n-1, -1, -1):
            for j in range(i+1, n):
                dp[i][j] = dp[i+1][j] - stones[i]
                if dp[i+1][j] % 3 == 0 and dp[i][j-1] % 3 == 0:
                    flag = True
                if dp[i+1][j] % 3 != 0:
                    ddp[i][j] |= not ddp[i+1][j]
                if dp[i][j-1] % 3 != 0:
                    ddp[i][j] |= not ddp[i][j-1]
        print(dp)
        print(ddp)
        print(ddp[0][n-1], flag)
        return ddp[0][n-1] and flag