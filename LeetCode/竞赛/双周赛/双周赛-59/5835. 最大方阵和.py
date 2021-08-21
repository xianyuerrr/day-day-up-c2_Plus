from typing import *
class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        mmin = 1000000
        res = 0
        cnt = 0
        zero = False

        for x in range(n):
            for y in range(n):
                val = matrix[x][y]
                if val == 0:
                    zero = True
                if val < 0:
                    cnt += 1
                mmin = min(mmin, abs(val))
                res += abs(val)
        if not zero and cnt & 1 == 1:
            res -= 2*mmin
        return res

# s = Solution()
# a = [[1,-1],[-1,1]]
# b = [[1,2,3],[-1,-2,-3],[1,2,3]]
# c = [[10000,10000,10000],[10000,10000,10000],[10000,10000,10000]]
# d = [[5,4],[1,-8]]
# print(s.maxMatrixSum(a))
# print(s.maxMatrixSum(b))
# print(s.maxMatrixSum(c))
# print(s.maxMatrixSum(d))