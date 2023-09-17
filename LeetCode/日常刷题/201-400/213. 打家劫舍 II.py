from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 0:
            return 0
        if (n == 1):
            return nums[0]
        if n == 2:
            return max(nums)
        dp1 = [0 for _ in range(n-1)]
        for i, num in enumerate(nums[:n-1]):
            dp1[i] = max(dp1[i-2] + nums[i], dp1[i-1])

        dp2 = [0 for _ in range(n-1)]
        for i, num in enumerate(nums[1:]):
            dp2[i] = max(dp2[i-2] + nums[i+1], dp2[i-1])
        return max(dp1[-1], dp2[-1])