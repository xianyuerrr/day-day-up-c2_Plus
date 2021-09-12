class Solution:
    def qpow(self, x, y, m):
        res = 1
        while y:
            if y & 1:
                res = res * x % m
            y >>= 1
            x = x * x % m
        return res

    def numberOfGoodSubsets(self, nums: List[int]) -> int:
        mod = 1000000007
        nums = list(set(nums))
        max_num = max(nums)
        dp = [True] * (1 + max_num)
        dp[0] = False

        return res % mod