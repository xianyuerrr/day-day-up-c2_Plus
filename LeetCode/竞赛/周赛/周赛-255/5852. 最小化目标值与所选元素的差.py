from typing import *
class Solution:
    def minimizeTheDifference(self, mat: List[List[int]], target: int) -> int:
        m, n = len(mat), len(mat[0])

        ll = 0
        rr = 0
        for row in mat:
            row.sort()
            ll += row[0]
            rr += row[-1]
        if rr <= target:
            return target - rr
        if ll >= target:
            return ll - target

        dp = [[0 for _ in range(target*2)] for _ in range(2)]
        
        for i in range(n):
            if mat[0][i] >= target*2:
                continue
            dp[0][mat[0][i]] = 1

        for i in range(1, m):
            cnt = 0
            for k in range(1, target*2):
                if not dp[0][k]:
                    continue
                if k > target:
                    if cnt == 0:
                        cnt += 1
                    else:
                        break
                for j in range(n):
                    val = k+mat[i][j]
                    if val >= target * 2:
                        break
                    dp[1][val] = 1
            for k in range(1, target*2):
                dp[0][k] = dp[1][k]
                dp[1][k] = 0
        l = r = target
        while l > 0 and not dp[0][l]:
            l -= 1
        while r < 2*target and not dp[0][r]:
            r += 1
        return min(target-l, r-target)

        # ans = 0
        # for i in mat:
        #     i.sort()
        #     ans += i[0]
        # if ans >= target:
        #     return ans - target

        # res = -1
        # def dfs(idx, ssum, ans):
        #     nonlocal res
        #     if res == target:
        #         return
        #     if idx == m:
        #         if res == -1:
        #             res = abs(ssum-target)
        #         else:
        #             if abs(ssum-target) < res:
        #                 res = abs(ssum-target)
        #         return
        #     ans -= mat[idx][0]
        #     for i in range(n):
        #         next_ssum = ssum+mat[idx][i]
        #         if next_ssum + ans >= 2 * target
        #             break
        #         dfs(idx+1, next_ssum, ans)
        #     return
        # dfs(0, 0, ans)
        # return res
mat = [[1,2,3],[4,5,6],[7,8,9]]
target = 13
s = Solution()
print(s.minimizeTheDifference(mat, target))