class Solution:
    def minFlips(self, s: str) -> int:
        bixu = 0
        for i in range(n):
            if s[i-1] == s[i] and s[i] == s[(i+1) % n]:
                bixu += 1
        

