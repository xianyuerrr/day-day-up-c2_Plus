from typing import List


class Solution:
    def minCount(self, coins: List[int]) -> int:
        res = 0
        for coin in coins:
            if coin & 1:
                res += 1
            res += coin >> 1
        return res