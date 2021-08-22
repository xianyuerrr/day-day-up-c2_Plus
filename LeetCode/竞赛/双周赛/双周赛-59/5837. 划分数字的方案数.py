from functools import lru_cache
from typing import *
class Solution:
    @lru_cache()
    def numberOfCombinations(self, num: str) -> int:
        n = len(num)
        mod = pow(10, 9) + 7
        # 1 <= n <= 3500，正确归正确，但是严重超时，DP是正解
        @lru_cache()
        def dfs(l, r, pre_val, pre_len):
            print(pre_val)
            if l > n-1 or r > n-1:
                return 0
            if num[l] == '0':
                return 0
            if r == n-1:
                print(pre_val, num[l:r+1])
                if pre_len == r+1-l and num[l:r+1] < pre_val:
                    return 0
                print("end: ", num[l:r+1])
                return 1

            ans = 0
            if r-l+1 > pre_len or num[l:r+1] >= pre_val:
                ans += dfs(r+1, r+1+(r-l), num[l:r+1], r-l+1)
            ans += dfs(l, r+1, pre_val, pre_len)
            return ans % mod
        return dfs(0, 0, '', 0)
s = Solution()
ss = "4321"
res = s.numberOfCombinations(ss)
print(res)
