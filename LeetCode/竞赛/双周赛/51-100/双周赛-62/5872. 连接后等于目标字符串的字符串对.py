class Solution:
    def numOfPairs(self, nums: List[str], target: str) -> int:
        n = len(nums)
        res = 0
        for i in range(n):
            for j in range(n):
                if i == j:
                    continue
                if nums[i] + nums[j] == target:
                    res += 1
        return res