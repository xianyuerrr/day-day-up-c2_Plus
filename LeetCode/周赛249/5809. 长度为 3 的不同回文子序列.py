from typing import Counter


class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        if len(s) < 3:
            return 0
        res = 0
        n = len(s)

        dic = defaultdict(list)
        for i in range(n):
            if not dic[s[i]]:
                dic[s[i]] = [i, i]
            else:
                dic[s[i]][1] = i
        for k, v in dic.items():
            l, r = v
            sset = set()
            for i in range(l+1, r):
                if s[i] in sset:
                    continue
                sset.add(s[i])
                res += 1
        return res
