from itertools import pairwise
from typing import List


class Solution:
    def checkValidGrid(self, grid: List[List[int]]) -> bool:
        n = len(grid)
        def isValid(x, y):
            return 0 <= x < n and 0 <= y < n

        x, y = 0, 0
        if grid[x][y] != 0:
            return False
        start = 0
        directions = [(-1, -2), (-2, -1), (-2, 1), (-1, 2), (1, 2), (2, 1), (2, -1), (1, -2)]
        for i in range(n * n):
            for delteX, delteY in directions:
                nextX = x + delteX
                nextY = y + delteY
                if not isValid(nextX, nextY) or grid[nextX][nextY] != start + 1:
                    continue
                x, y = nextX, nextY
                start += 1
        return start == pow(n, 2) - 1

    def checkValidGrid(self, grid: List[List[int]]) -> bool:
        if grid[0][0]:
            return False
        n = len(grid)
        pos = [None] * (n * n)
        for i in range(n):
            for j in range(n):
                pos[grid[i][j]] = (i, j)
        for (x1, y1), (x2, y2) in pairwise(pos):
            dx, dy = abs(x1 - x2), abs(y1 - y2)
            ok = (dx == 1 and dy == 2) or (dx == 2 and dy == 1)
            if not ok:
                return False
        return True