from typing import List


class Solution:
    def queensAttacktheKing(self, queens: List[List[int]], king: List[int]) -> List[List[int]]:
        res = []
        directions = ((1, 0), (0, 1), (-1, 0), (0, -1), (1, 1), (1, -1), (-1, 1), (-1, -1))
        n = 8
        mat = [[False] * n for _ in range(n)]
        
        def isValid(x, y):
            return 0 <= x < n and 0 <= y < n
        
        for i, j in queens:
            mat[i][j] = True
        for deleteX, deleteY in directions:
            x, y = king
            while (isValid(x, y)):
                if (mat[x][y]):
                    res.append([x, y])
                    break
                x += deleteX
                y += deleteY
        return res