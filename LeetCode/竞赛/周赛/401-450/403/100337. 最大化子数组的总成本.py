class Solution:
    def maximumTotalCost(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [-1] * n
        dp[0] = nums[0]
        for i in range(1, n):
            dp[i] = max(dp[i-1] + nums[i], (dp[i-2] if i >= 2 else 0) + ((nums[i-1] - nums[i]) if i >= 1 else 0))
        return dp[-1]