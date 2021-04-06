class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        can_have = 1
        left = 0
        for right in range(1, len(nums)):
            if nums[right] == nums[left]:
                if can_have:
                    can_have -= 2
                else:
                    continue
            # can_have == -1 为相等的标志，即第二个元素进入选取范围
            # can_have != -1 说明 right 为新元素， right != left，需要重置为 1
            can_have = 0 if can_have == -1 else 1
            left += 1
            nums[left], nums[right] = nums[right], nums[left]
            # print(nums)
            # print(left, right)
        return left+1