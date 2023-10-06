from typing import List
import bisect


class Solution:
    def countWays(self, nums: List[int]) -> int:
        res = 0
        nums.sort()
        n = len(nums)
        for i in range(n+1):
            if i > (nums[i-1] if i-1 >= 0 else -1) and i < (nums[i] if i < n else n+1):
                res += 1
        return res