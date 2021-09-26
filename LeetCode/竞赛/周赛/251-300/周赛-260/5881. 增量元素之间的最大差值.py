class Solution:
    def maximumDifference(self, nums: List[int]) -> int:
        n = len(nums)
        res = 0
        for i in range(n):
            for j in range(i+1, n):
                res = max(res, nums[j]-nums[i])
        return res if res != 0 else -1