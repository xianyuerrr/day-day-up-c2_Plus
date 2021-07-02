class Solution:
    def maximumRemovals(self, s: str, p: str, removable: List[int]) -> int:
        l = 0
        r = len(removable)
        n = len(p)
        s_lis = list(s)
        while l < r:
            m = l + (r-l >> 1)
            ans = s_lis.copy()
            for i in range(m+1):
                ans[removable[i]] = ''
            idx = 0
            flag = False
            for i in ans:
                if i == p[idx]:
                    idx += 1
                    if idx == n:
                        flag = True
                        break
            if flag:
                l = m+1
            else:
                r = m
        return l
# class Solution:
#     def maximumRemovals(self, s: str, p: str, removable: List[int]) -> int:
#         def isords(s, p):
#             n = len(p)
#             idx = 0
#             l = -1
#             r = -1
#             for i in range(len(s)):
#                 ss = s[i]
#                 if ss == p[idx]:
#                     if idx == 0:
#                         l = i
#                     idx += 1
#                     if idx == n:
#                         r = i
#                         return l, r
#             return l, r
#         m = len(removable)
#         s = list(s)
#         l = 0
#         r = len(s)-1
#         for k in range(m):
#             for kk in range(k+1, m):
#                 if removable[kk] > removable[k]:
#                     removable[kk] -= 1
#             s = s[:removable[k]]+s[removable[k]+1:]
#             if l <= removable[k] <= r:
#                 l, r = isords(s, p)
#                 if l >= r:
#                     return k
#         return m