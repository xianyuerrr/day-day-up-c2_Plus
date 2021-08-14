# 枚举边界
class Solution:
    def maxSumSubmatrix(self, matrix: List[List[int]], k: int) -> int:
        m = len(matrix)
        n = len(matrix[0])
        res = -inf
        for left in range(n):
            sum_row = [0 for _ in range(m)]
            for right in range(left, n):
                for row in range(m):
                    sum_row[row] += matrix[row][right]
                for x1 in range(m):
                    ans = 0
                    for x2 in range(x1, m):
                        ans += sum_row[x2]
                        if ans <= k:
                            if ans == k:
                                return k
                            res = max(res, ans)
        return res

# 暴力 + DP + 状态压缩
# class Solution:
#     def maxSumSubmatrix(self, matrix: List[List[int]], k: int) -> int:
#         m = len(matrix)
#         n = len(matrix[0])
#         dp = [[0 for _ in range(n+1)] for __ in range(m+1)]
#         res = -inf
#         for x in range(m):
#             for y in range(n):
#                 for xx in range(x, m):
#                     for yy in range(y, n):
#                         dp[xx+1-x][yy+1-y] = dp[xx-x][yy+1-y] + dp[xx+1-x][yy-y] - dp[xx-x][yy-y] + matrix[xx][yy]
#                         if dp[xx+1-x][yy+1-y] <= k:
#                             if dp[xx+1-x][yy+1-y] == k:
#                                 return k
#                             res = max(res, dp[xx+1-x][yy+1-y])
#         return res

# 暴力 + DP
# class Solution:
#     def maxSumSubmatrix(self, matrix: List[List[int]], k: int) -> int:
#         m = len(matrix)
#         n = len(matrix[0])
#         dp = [[0 for _ in range(n+1)] for __ in range(m+1)]
#         res = -inf
#         for i in range(m):
#             for j in range(n):
#                 dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j] - dp[i][j] + matrix[i][j]
#         for x1 in range(m):
#             for x2 in range(x1, m):
#                 for y1 in range(n):
#                     for y2 in range(y1, n):
#                         # print(dp[x2+1][y2+1], '-', dp[x1][y2+1], '-', dp[x2+1][y1], '+', dp[x1][y1])
#                         ans = dp[x2+1][y2+1] - dp[x1][y2+1] - dp[x2+1][y1] + dp[x1][y1]
#                         # print(ans)
#                         if ans <= k:
#                             if ans == k:
#                                 return k
#                             res = max(res, ans)
#         return res