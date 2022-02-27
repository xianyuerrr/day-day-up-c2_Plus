from typing import *
from collections import defaultdict

class Solution:
    def isBeautifulNumber(self, n) -> bool:
        dic = defaultdict(int)
        while n:
            ans = n % 10
            n //= 10
            dic[ans] += 1
        for k in dic.keys():
            if k != dic[k]:
                return False
        return True

    def nextBeautifulNumber(self, n: int) -> int:
        n += 1
        while not self.isBeautifulNumber(n):
            n += 1
        return n