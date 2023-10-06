from typing import List


class Solution:
    def sumIndicesWithKSetBits(self, nums: List[int], k: int) -> int:
        res = 0
        for i, val in enumerate(nums):
            res += val if self.count(i) == k else 0
        return res

    def count(self, num: int) -> int:
        res = 0
        while num:
            if (num & 1):
                res += 1
            num >>= 1
        return res