from functools import reduce
from typing import *


class Solution:
    def intersection(self, nums: List[List[int]]) -> List[int]:
        res = list(reduce(lambda x, y: set(x) & set(y), nums))
        return sorted(res)
