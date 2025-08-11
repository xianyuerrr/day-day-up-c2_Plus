from typing import List


class Solution:
    def maximumLength(self, nums: List[int]) -> int:
        res = [1, 1]
        prefix = [nums[0] & 1, nums[0] & 1]
        for num in nums[1:]:
            if num & 1 != prefix[0]:
                res[0] += 1
                prefix[0] = num & 1
            if num & 1 == prefix[1]:
                res[1] += 1
        return max(max(res), len(nums) - res[1])
    