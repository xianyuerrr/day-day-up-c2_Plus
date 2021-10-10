from collections import Counter
from typing import *
class Solution:
    def minOperations(self, grid: List[List[int]], x: int) -> int:
        lis = []
        for g in grid:
            lis += g
        n = len(lis)
        lis.sort()
        ssum = sum(lis)
        if n == 1 or lis[-1] == lis[0]:
            return 0
        for i in range(n-1):
            if (lis[i+1] - lis[i]) % x != 0:
                return -1
        counter = Counter(lis)
        res = float('inf')

        l = 0; lCnt = 0
        r = ssum; rCnt = n
        for i in range(lis[0], lis[-1]+1, x):            
            r -= counter[i] * i
            rCnt -= counter[i]

            ans = abs(l - lCnt * i) + abs(r - rCnt*i)
            res = min(res, ans // x)
            
            l += counter[i] * i
            lCnt += counter[i]
        return res