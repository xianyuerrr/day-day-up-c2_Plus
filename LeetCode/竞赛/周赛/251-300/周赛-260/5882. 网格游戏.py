class Solution:
    def gridGame(self, grid: List[List[int]]) -> int:
        n = len(grid[0])
        preSum = [[grid[i][j] for j in range(n)] for i in range(2)]
        for i in range(2):
            for j in range(n):
                preSum[i][j] += preSum[i][j-1] if j != 0 else 0

        res = float('inf')
        for i in range(n):
            ans = preSum[0][i] + preSum[1][-1] - (preSum[1][i-1] if i != 0 else 0)
            res = min(res, max(preSum[1][i-1] if i != 0 else 0, preSum[0][-1] - preSum[0][i]))

        # for i in range(n):
        #     if i <= idx:
        #         grid[0][i] = 0
        #     if i >= idx:
        #         grid[1][i] = 0

        # res = 0
        # preSum = [[grid[i][j] for j in range(n)] for i in range(2)]
        # for i in range(2):
        #     for j in range(n):
        #         preSum[i][j] += preSum[i][j-1] if j != 0 else 0
        # for i in range(n):
        #     ans = preSum[0][i] + preSum[1][-1] - (preSum[1][i-1] if i != 0 else 0)
        #     if ans > res:
        #         res = ans
        return res