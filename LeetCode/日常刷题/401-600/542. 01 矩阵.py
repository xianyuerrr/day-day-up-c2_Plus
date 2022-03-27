from typing import *
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        # 应该可以使用 BFS 和 DP
        m, n = len(mat), len(mat[0])
        max_dis = m*n
        dp = [[max_dis if mat[i][j] != 0 else 0 for j in range(n)] for i in range(m)]
        for i in range(1, m):
            for j in range(1, n):
                if dp[i][j] == 0:
                    continue
                dp[i][j] = min(dp[i][j], (dp[i-1][j] if i != 0 else max_dis) + 1, (dp[i][j-1] if j != 0 else max_dis) + 1)
        # print(dp)
        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                if dp[i][j] == 0:
                    continue
                dp[i][j] = min(dp[i][j], (dp[i+1][j] if i != m-1 else max_dis) + 1, (dp[i][j+1] if j != n-1 else max_dis) + 1)
        return dp
