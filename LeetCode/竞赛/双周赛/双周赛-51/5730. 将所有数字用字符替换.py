class Solution:
    def replaceDigits(self, s: str) -> str:
        lis = list(s)
        n = len(s)
        for i in range(1, n, 2):
            lis[i] = chr(ord(lis[i-1]) + ord(lis[i])-ord('0'))
        return ''.join(lis)