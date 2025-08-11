class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:
        if x < y:
            x, y = y, x
            s = "".join("b" if c == "a" else "a" if c == "b" else c for c in s)
        ans = i = 0
        while i < len(s):
            cntA = cntB = 0
            while i < len(s) and s[i] in "ab":
                if s[i] == "a":
                    cntA += 1
                else:
                    if cntA > 0:
                        cntA -= 1
                        ans += x
                    else:
                        cntB += 1
                i += 1
            i += 1
            ans += min(cntA, cntB) * y
        return ans

