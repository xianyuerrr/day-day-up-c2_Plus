class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        i = len(nums) - 2
        # 找到第一个满足 nums[i] < nums[i+1] 的 i
        while i >= 0 and nums[i] >= nums[i + 1]:
            i -= 1
        # 找到 大于 i 的下标里，大于 nums[i] 的最小值下标
        # 交换其值
        if i >= 0:
            j = len(nums) - 1
            while j >= 0 and nums[i] >= nums[j]:
                j -= 1
            nums[i], nums[j] = nums[j], nums[i]
        
        left, right = i + 1, len(nums) - 1
        # 操作暗含了一个条件：
        # 原来的 [left, right] 是降序的，所以现在将其反转即可
        while left < right:
            nums[left], nums[right] = nums[right], nums[left]
            left += 1
            right -= 1
