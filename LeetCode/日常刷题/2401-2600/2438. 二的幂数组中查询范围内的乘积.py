from functools import reduce
from typing import List


class Solution:
    def productQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        mod_val = (pow(10, 9) + 7)
        powers = []
        ans = 1
        while ans <= n:
            if ans & n:
                powers.append(ans & n)
            ans <<= 1
        return list(map(lambda x: reduce(lambda y, z: (y * z) % mod_val, powers[x[0] : x[1] + 1]), queries))
