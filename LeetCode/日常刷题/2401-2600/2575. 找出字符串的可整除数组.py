from typing import List


class Solution:
    def divisibilityArray(self, word: str, m: int) -> List[int]:
        n = len(word)
        l = 0
        res = [0] * n
        num = 0
        for i in range(n):
            num = num * 10 + int(word[i]) 
            num %= m
            if num == 0:
                res[i] = 1
                num = 0
        return res

