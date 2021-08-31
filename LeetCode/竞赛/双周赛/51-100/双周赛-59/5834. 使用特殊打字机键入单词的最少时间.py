class Solution:
    def minTimeToType(self, word: str) -> int:
        cur = 'a'
        res = 0
        for c in word:
            x = abs(ord(cur)-ord(c))
            y1 = min(ord(cur), ord(c))-ord('a')
            y2 = ord('z')-max(ord(c), ord(cur))
            res += min(x, y1+1+y2)
            cur = c
            res += 1
        return res