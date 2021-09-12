from typing import *
class Solution:
    def numberOfUniqueGoodSubsequences(self, binary: str) -> int:
        mod = 10**9 + 7

        even = odd = 0
        for ch in binary:
            if ch == "0":
                even = (even + odd) % mod
            else:
                odd = (even + odd + 1) % mod
        
        ans = (even + odd + ("0" in binary)) % mod
        return ans
        
