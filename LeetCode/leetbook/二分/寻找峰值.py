class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        nums = [-inf] + nums + [inf]
        n = len(nums)
        l = 1
        r = n-2
        while l < r:
            mid = l + (r - l >> 1) + 1
            if nums[mid] > nums[mid-1]:
                l = mid
            else:
                r = mid-1
        return l-1