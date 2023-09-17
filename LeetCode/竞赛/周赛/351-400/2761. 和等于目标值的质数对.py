from typing import List


class Solution:
    n = pow(10, 6+1)
    primeLis = [True] * n

    def __init__(self):
        for i in range(2, (self.n >> 2) + 1):
            tmp = i
            while tmp < self.n:
                self.primeLis[tmp] = False
                tmp *= i

    def findPrimePairs(self, n: int) -> List[List[int]]:
        res = []
        for i in range(1, (n >> 1) + 1):
            if (self.primeLis[i] and self.primeLis[n - i]):
                res.append([i, n - i])
        return res
