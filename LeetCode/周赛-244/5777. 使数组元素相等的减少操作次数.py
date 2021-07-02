from typing import Counter
class Solution:
    def reductionOperations(self, nums: List[int]) -> int:
        n = len(nums)
        res = 0
        count = Counter(nums)
        sset = list(set(nums))
        sset.sort(reverse=True)
        ans = 0
        for i in sset[:-1]:
            ans += count[i]
            res += ans
        return res