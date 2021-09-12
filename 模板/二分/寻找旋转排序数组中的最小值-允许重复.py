class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums:
            return
        n = len(nums)
        l = 0
        r = n-1
        # 三叶の思路
        # while r != 0 and nums[r] == nums[0]:
        #     r -= 1
        # while l < r:
        #     m = l + (r-l >> 1)
        #     if nums[m] <= nums[r]:
        #         r = m
        #     else:
        #         l = m+1

        # 合并后的思路
        while l < r:
            m = l + (r-l >> 1)
            if nums[m] > nums[r]:
                l = m + 1
            elif nums[m] < nums[r]:
                r = m                
            else:
                r -= 1
        return nums[l]