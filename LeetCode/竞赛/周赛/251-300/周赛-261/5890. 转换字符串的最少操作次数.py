class Solution:
    def minimumMoves(self, s: str) -> int:
        res = 0
        n = len(s)
        l = 0
        while l < n:
            if s[l] == 'X':
                res += 1
                l = l+3
            else:
                l += 1
        return res 