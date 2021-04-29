class Solution:
    def can_do_it(self, nums, m, target):
        ssum = 0
        for i in range(len(nums)):
            ssum += nums[i]
            if ssum > target:
                ssum = 0
                m -= 1
                ssum += nums[i]
                if m == 0 or ssum > target:
                    return False
        return True

    def splitArray(self, nums: List[int], m: int) -> int:
        left = 0
        right = sum(nums)
        while left < right:
            mid = left + (right - left >> 1)
            if self.can_do_it(nums, m, mid):
                right = mid
            else:
                left = mid + 1
        return left