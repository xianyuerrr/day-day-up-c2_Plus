class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        nums.sort()
        return [nums[i//2] if i%2 == 0 else nums[-i//2] for i in range(len(nums))]