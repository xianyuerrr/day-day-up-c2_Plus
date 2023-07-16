class Solution:
    def longestAlternatingSubarray(self, nums: List[int], threshold: int) -> int:
        res = 0
        l = 0
        for r in range(1, len(nums)):
            if (nums[l] > threshold or nums[l] & 1):
                l += 1
                continue
            if (nums[r] > threshold or (nums[r-1] + nums[r]) & 1):
                print(l, r)
                res = max(res, r - l)
                l = r
                continue
            res = max(res, r - l + 1)
        return res