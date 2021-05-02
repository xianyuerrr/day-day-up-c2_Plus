class Solution:
    def splitString(self, s: str) -> bool:
        s_lis = list(s)
        n = len(s_lis)
        pre = None
        ans = 0
        last = -1
        def dfs(idx, pre, ans):
            nonlocal last
            if idx == n:
                if pre != None:
                    return ans == pre - 1 and last != n-1
                else:
                    return False
            res = False
            ans = ans * 10 + ord(s_lis[idx]) - ord('0')
            if pre == None or ans < pre:
                res = res or dfs(idx+1, pre, ans)
            if pre == None or ans == pre - 1:
                pre = ans
                ans = 0
                last = idx
                res = res or dfs(idx+1, pre, ans)
            return res
        return dfs(0, pre, ans)