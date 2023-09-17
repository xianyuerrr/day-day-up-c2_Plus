from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if (n < 2):
            return nums[0]
        # dp[i] 在前i号房间选择，且以选择i号房间为结束时的最高窃取金额
        dp = [0] * n
        for i in range(n):
            dp[i] = max((dp[i-2] if i >=2 else 0), (dp[i-3] if i >= 3 else 0)) + nums[i]
        return max(dp[-1], dp[-2])