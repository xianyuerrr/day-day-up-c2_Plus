from copy import deepcopy
class Solution:
    def latestDayToCross(self, row: int, col: int, cells: List[List[int]]) -> int:
        self.diections = ((1, 0), (-1, 0), (0, 1), (0, -1))
        self.row, self.col = row+1, col+1
        n = len(cells)
        nums = [[0 for _ in range(col+1)] for __ in range(row+1)]
        l = 0
        r = n
        while l < r:
            m = l + (r-l >> 1) + 1
            for x, y in cells[:m]:
                nums[x][y] = 1
            if self.bfs(deepcopy(nums)):
                l = m
            else:
                r = m-1
            for x, y in cells[:m]:
                nums[x][y] = 0
        return l

    def bfs(self, nums):
        sset = set()
        for j in range(1, self.col):
            if nums[1][j] == 0:
                sset.add((1, j))
        new_sset = set()
        while sset:
            for x, y in sset:
                if x == self.row-1:
                    return True
                nums[x][y] = 1
                for delte_x, delte_y in self.diections:
                    new_x, new_y = x+delte_x, y+delte_y
                    if new_x <= 0 or new_y <= 0 or new_y >= self.col:
                        continue
                    if nums[new_x][new_y] == 1:
                        continue
                    new_sset.add((new_x, new_y))
            sset.clear()
            sset, new_sset = new_sset, sset
        return False
    # def check(self, nums):
    #     row, col = self.row, self.col
    #     for j in range(col):
    #         if nums[1][j] == 0 and self.dfs(nums, 1, j):
    #             return True
    #     return False
    # def dfs(self, nums, x, y):
    #     if x == self.row:
    #         return True
    #     if x <= 0 or x >= self.row or y <= 0 or y >= self.col:
    #         return False
    #     if nums[x][y] == 1:
    #         return False
    #     flag = False
    #     nums[x][y] = 1
    #     for delte_x, delte_y in self.diections:
    #         if self.dfs(nums, x+delte_x, y+delte_y):
    #             flag = True
    #             break
    #     nums[x][y] = 0
    #     return flag
        
        