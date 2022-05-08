from functools import cache, lru_cache


class Solution:
    def hasValidPath(self, grid: List[List[str]]) -> bool:
        m, n = len(grid), len(grid[0])
        # print(m, n)
        if ((m+n-1) & 1): return False

        flag = False

        @cache
        def dfs(i, j, diff):
            nonlocal flag
            if (flag):
                return
            if grid[i][j] == '(':
                diff += 1
            else:
                diff -= 1
            v = m + n - (i + j + 2) - diff
            if diff >= 0 and v >= 0 and v & 1 == 0:
                if (i == m-1 and j == n-1 and diff == 0):
                    flag = True
                if (i+1 < m):
                    dfs(i+1, j, diff)
                if (j+1 < n):
                    dfs(i, j+1, diff)

        dfs(0, 0, 0)
        return flag
