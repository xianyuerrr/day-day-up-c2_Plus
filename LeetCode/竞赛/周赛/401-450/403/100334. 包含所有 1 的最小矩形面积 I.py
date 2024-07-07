class Solution:
    def minimumArea(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        edge = [m, -1, n, -1]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    edge[0] = min(edge[0], i)
                    edge[1] = max(edge[1], i)
                    edge[2] = min(edge[2], j)
                    edge[3] = max(edge[3], j)
        return (edge[1] - edge[0] + 1) * (edge[3] - edge[2] + 1)