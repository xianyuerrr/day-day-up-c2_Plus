class Solution:
    def minimumDifference(self, nums: List[int], k: int) -> int:
        n = len(nums)
        nums.sort()
        res = nums[-1]
        for i in range(n-k+1):
            res = min(res, nums[i+k-1]-nums[i])
        return res