class Solution:
    def getMinDistance(self, nums: List[int], target: int, start: int) -> int:
        res = inf
        for i in range(len(nums)):
            if nums[i] == target:
                if abs(res-start) > abs(i-start):
                    res = i
        return abs(res-start)