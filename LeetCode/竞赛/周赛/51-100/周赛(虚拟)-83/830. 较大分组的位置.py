class Solution:
    def largeGroupPositions(self, s: str) -> List[List[int]]:
        res = []
        left = 0
        s += '1'
        n = len(s)
        for right in range(1, n):
            if s[right] == s[right-1]:
                continue
            if right - left >= 3:
                res.append([left, right-1])
            left = right
        return res