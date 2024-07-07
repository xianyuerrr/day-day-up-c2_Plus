class Solution:
    def minimumAverage(self, nums: List[int]) -> float:
        n = len(nums)
        nums.sort()
        cnt = 0
        res = nums[-1] * 2
        while (cnt < (n>>1)):
            cnt += 1
            res = min(res, (nums[cnt-1] + nums[n-cnt]) / 2)
        return res