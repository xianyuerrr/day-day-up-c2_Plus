from collections import Counter
from typing import List


class Solution:
    def findLucky(self, arr: List[int]) -> int:
        counter = Counter(arr)
        res = -1
        for num, cnt in counter.items():
            if num == cnt:
                res = max(res, num)
        return res