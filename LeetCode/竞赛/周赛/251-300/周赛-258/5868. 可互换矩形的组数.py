from math import comb
from collections import defaultdict
class Solution:
    def interchangeableRectangles(self, rectangles: List[List[int]]) -> int:
        dic = defaultdict(int)
        for w, h in rectangles:
            dic[w/h] += 1

        res = 0
        for k, v in dic.items():
            res += comb(v, 2)
        return res