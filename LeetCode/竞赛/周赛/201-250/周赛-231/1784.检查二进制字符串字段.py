class Solution:
    def checkOnesSegment(self, s: str) -> bool:
        lis = s.split('0')
        res = 0
        for i in lis:
            if i != '':
                res += 1
        return res <= 1