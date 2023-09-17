from typing import List


class Solution:
    def numberOfPoints(self, nums: List[List[int]]) -> int:
        dp = [False] * 100
        res = 0
        for i, j in nums:
            dp[i:j+1] = [True] * (j+1-i)
        
        return sum(dp)