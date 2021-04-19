class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        # 很明显，数组有序，且要求原地很多时候就是需要使用双指针
        if not nums:
            return 0

        l = 0
        n = len(nums)
        for r in range(1, n):
            if nums[r] == nums[l]:
                continue
            l += 1
            nums[l], nums[r] = nums[r], nums[l]
        return l+1