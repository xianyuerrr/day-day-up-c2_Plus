from typing import *

class Solution:
    def minimumPossibleSum(self, n: int, target: int) -> int:
        mid = (target >> 1)
        if n <= mid:
            return (1 + n) * n // 2
        else:
            return ((1 + mid) * mid // 2 + (target + target + n - mid - 1) * (n - mid) // 2) % (10 ** 9 + 7)