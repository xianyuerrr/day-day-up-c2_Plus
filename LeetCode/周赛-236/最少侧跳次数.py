class Solution:
    def minSideJumps(self, obstacles: List[int]) -> int:
        n = len(obstacles)
        dp = [[1, 0, 1] for _ in range(n)]
        for i in range(1, n):
            if obstacles[i] == 0:
                dp[i][0] = min(dp[i-1][0], dp[i-1][1]+1, dp[i-1][2]+1)
                dp[i][1] = min(dp[i-1][1], dp[i-1][0]+1, dp[i-1][2]+1)
                dp[i][2] = min(dp[i-1][2], dp[i-1][0]+1, dp[i-1][1]+1)
            elif obstacles[i] == 1:
                dp[i][0] = n
                dp[i][1] = min(dp[i-1][1], dp[i-1][2]+1)
                dp[i][2] = min(dp[i-1][2], dp[i-1][1]+1)
            elif obstacles[i] == 2:
                dp[i][0] = min(dp[i-1][0], dp[i-1][2]+1)
                dp[i][1] = n
                dp[i][2] = min(dp[i-1][2], dp[i-1][0]+1)
            elif obstacles[i] == 3:
                dp[i][0] = min(dp[i-1][0], dp[i-1][1]+1)
                dp[i][1] = min(dp[i-1][1], dp[i-1][0]+1)
                dp[i][2] = n
        return min(dp[-1])
