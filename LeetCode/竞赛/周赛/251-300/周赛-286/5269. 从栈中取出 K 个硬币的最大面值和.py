class Solution:
    def maxValueOfCoins(self, piles: List[List[int]], k: int) -> int:
        dp = [-1] * k
        n = len(piles)
        for i in range(n):
            dpNew = dp.copy()
            pile = piles[i]
            m = len(pile)
            ssum = 0
            for j in range(min(k, m)):
                ssum += pile[j]
                for kk in range(j, k):
                    if kk - (j+1) >= 0 and dp[kk-(j+1)] == -1:
                        continue
                    dpNew[kk] = max(dpNew[kk], (dp[kk-(j+1)] if kk-(j+1) >= 0 else 0) + ssum)
            for kk in range(k):
                dp[kk] = max(dp[kk], dpNew[kk])
        return dp[k-1]