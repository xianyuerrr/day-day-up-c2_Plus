from bisect import bisect, bisect_right
class Solution:
    def longestObstacleCourseAtEachPosition(self, obstacles: List[int]) -> List[int]:
        n = len(obstacles)
        # 长度为 i+1 的子序列的最小末尾值
        ans = []
        # 当前的最长长度
        l = 0
        res = [1 for _ in range(n)]
        for i in range(n):
            val = obstacles[i]
            if not l or val >= ans[-1]:
                l += 1
                ans.append(val)
                res[i] = l
            else:
                # bisect_left: i 左侧都是小于 val 的
                # bisect_right: i 左侧都是小于等于 val 的
                idx = bisect_right(ans, val)
                res[i] = idx+1
                ans[idx] = val
        return res


        # # DP, O(n2) 超时
        # dp = [1 for _ in range(n)]
        # for i in range(1, n):
        #     for j in range(i):
        #         if obstacles[i] >= obstacles[j]:
        #             dp[i] = max(dp[i], dp[j]+1)
        # return dp
