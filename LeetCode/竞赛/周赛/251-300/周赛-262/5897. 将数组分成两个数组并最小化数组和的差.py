class Solution:
    def minimumDifference(self, nums: List[int]) -> int:
        nums.sort()
        # print(nums)
        ssum = sum(nums)
        n = len(nums)
        k = n // 2
        res = float('inf')
        flag = ssum

        def dfs(idx, ans, have):
            nonlocal res, flag
            if have == k:
                if abs(ssum-2*ans) < res:
                    res = abs(ans - (ssum-ans))
                    flag = ans
                return 
            if idx >= n:
                return
            if nums[idx] > 0 and (ssum-2*ans < -res):
                return
            dfs(idx+1, ans, have)
            dfs(idx+1, ans+nums[idx], have+1)
            return
        dfs(0, 0, 0)
        return res
