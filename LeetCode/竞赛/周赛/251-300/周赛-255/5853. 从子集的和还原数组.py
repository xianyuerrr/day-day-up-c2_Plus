from typing import *
class Solution:
    def recoverArray(self, n: int, sums: List[int]) -> List[int]:
        dic = {}
        for s in sums:
            dic[s] = True
        
# from random import *
# from bisect import *
# a = [1, 3, 5]
# val = randint(1, a[-1])
# idx = bisect_left(a, val)
# print(val, idx)
