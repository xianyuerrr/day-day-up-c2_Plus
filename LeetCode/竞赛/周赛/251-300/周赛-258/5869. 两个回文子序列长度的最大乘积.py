from bisect import bisect
class Solution:
    def check(self, s):
        n = len(s)
        for i in range(n>>1):
            if s[i] == s[n-1-i]:
                continue
            else:
                return False
        return True


    def maxProduct(self, s: str) -> int:
        n = len(s)
        subLis = []
        subSLis = []

        ans = []
        sans = []
        def dfs(i):
            if i == n:
                if self.check(''.join(sans)):
                    subLis.append(ans.copy())
                    subSLis.append(sans.copy())
                return
            dfs(i+1)
            ans.append(i)
            sans.append(s[i])
            dfs(i+1)
            ans.pop()
            sans.pop()

        dfs(0)
        res = 0
        m = len(subLis)
        for i in range(m):
            for j in range(i+1, m):
                for idx in subLis[i]:
                    if idx in subLis[j]:
                        break
                else:
                    res = max(res, len(subLis[i]) * len(subLis[j]))
        return res