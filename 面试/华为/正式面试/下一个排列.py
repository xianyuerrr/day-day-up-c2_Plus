from typing import *
class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        i = n-2
        while i >= 0 and nums[i] >= nums[i+1]:
            i -= 1
        if i == -1:
            nums.reverse()
            return
        # 找到第一个大于 nums[i] 的数，将其换到 i 位置，然后将 [i+1:] 排序
        # 等价于 先排序，后找第一个大于 nums[i] 的数
        nums[i+1:] = sorted(nums[i+1:])

        l = i+1
        r = n-1
        while l < r:
            m = l+(r-l>>1)
            if nums[m] > nums[i]:
                r = m
            else:
                l = m+1
        nums[i], nums[l] = nums[l], nums[i]