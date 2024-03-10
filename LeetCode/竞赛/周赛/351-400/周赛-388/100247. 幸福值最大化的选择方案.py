from typing import List


class Solution:
    def maximumHappinessSum(self, happiness: List[int], k: int) -> int:
        happiness.sort(key=lambda x: -x)
        res = 0
        for i in range(k):
            res += max(happiness[i] - i, 0)
        return res