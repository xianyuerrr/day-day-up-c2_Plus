class Solution:
    def maxGroupNumber(self, tiles: List[int]) -> int:
        count = collections.Counter(tiles)
        s = set(count.keys())
        lis = list(count.keys()).sort()
        n = len(tiles)
        res = 0
        for r in s:
            if count[r] == 0:
                continue
            while count[r+1] > 0 and count[r+2] > 0:
                count[r] -= 1
                count[r+1] -= 1
                count[r+2] -= 1
                res += 1
            while count[r] > 2:
                count[r] -= 3
                res += 1
        return res