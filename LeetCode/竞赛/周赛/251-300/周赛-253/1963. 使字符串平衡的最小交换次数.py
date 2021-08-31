from math import ceil
class Solution:
    def minSwaps(self, s: str) -> int:
        count = 0
        res = 0
        for i in s:
            if i == '[':
                count += 1
            else:
                count -= 1
            res = max(res, -count)
        return ceil(res / 2)
