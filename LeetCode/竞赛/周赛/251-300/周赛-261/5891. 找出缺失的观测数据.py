class Solution:
    def missingRolls(self, rolls: List[int], mean: int, n: int) -> List[int]:
        m = len(rolls)
        ssum = (m+n) * mean
        mSum = sum(rolls)
        nSum = ssum - mSum
        if nSum / n > 6 or nSum < n:
            return []
        res = [nSum // n] * n
        for i in range(nSum % n):
            res[i] += 1
        return res