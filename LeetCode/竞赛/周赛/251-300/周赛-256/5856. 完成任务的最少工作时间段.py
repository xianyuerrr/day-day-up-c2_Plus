from typing import *
import random
class Solution:
    def work(self, tasks, sessionTime):
        res = 0
        ans = 0
        for i in tasks:
            ans += i
            if ans > sessionTime:
                res += 1
                ans = i
        res += 1
        return res

    def minSessions(self, tasks: List[int], sessionTime: int) -> int:

        # # 邪道，蒙特卡洛模拟
        # n = len(tasks)
        # time = 1000
        # res = n
        # while time:
        #     time -= 1
        #     random.shuffle(tasks)
        #     count = self.work(tasks, sessionTime)
        #     res = min(res, count)
        # return res

        n = len(tasks)
        # 预处理，求子集是否可以在 sessionTime 内完成
        valid = [False] * (1 << n)
        for mask in range(1, 1 << n):
            needTime = 0
            for i in range(n):
                if mask & (1 << i):
                    needTime += tasks[i]
                if needTime > sessionTime:
                    valid[mask] = False
                    break
            else:
                valid[mask] = True

        f = [float("inf")] * (1 << n)
        f[0] = 0
        for mask in range(1, 1 << n):
            subset = mask
            # print(bin(subset)[2:])
            while subset:
                if valid[subset]:
                    # print(bin(subset)[2:], bin(mask ^ subset)[2:])
                    # subset 和 mask ^ subset 组成 mask
                    f[mask] = min(f[mask], f[mask ^ subset] + 1)
                # 这个太妙了
                # 在 O(1) 的时间快速得到下一个（即更小的）mask 的子集
                subset = (subset - 1) & mask
        return f[(1 << n) - 1]


    # dp 有两个参数
    def minSessions(self, tasks: List[int], sessionTime: int) -> int:        
        def add(cur: [int, int], task: int):
            if cur[1] + task <= sessionTime:
                return [cur[0], cur[1]+task]
            return [cur[0]+1, task]

        # 状压DP
        n = len(tasks)

        # 需要的 session 数, 当前 session 已使用的时间
        dp = [[float('inf'), float('inf')]] * (1 << n) 
        # (1 << n) == pow(2, n)，共 pow(2, n) 种情况
        
        dp[0] = [1, 0]

        for mask in range(1, 1 << n):
            for i in range(n):
                # 在已选 mask 中除任务 i 的任务的基础上，新增任务 i，由此来计算 mask 需要的 session 数
                # mask ^ (1 << i) + (1 << i) = mask
                if mask & (1 << i):
                    dp[mask] = min(dp[mask], add(dp[mask ^ (1 << i)], tasks[i]))
        return dp[-1][0]
    
    # dp 只有一个参数
    def minSessions(self, tasks: List[int], sessionTime: int) -> int:        
        def add(cur: int, task: int):
            this_session = cur % sessionTime
            if this_session + task <= sessionTime:
                return cur + task
            return cur - this_session + sessionTime + task

        # 状压DP
        n = len(tasks)

        # 需要的 session 数, 当前 session 已使用的时间
        dp = [float('inf')] * (1 << n) 
        # (1 << n) == pow(2, n)，共 pow(2, n) 种情况
        
        dp[0] = 0

        for mask in range(1, 1 << n):
            for i in range(n):
                # 在已选 mask 中除任务 i 的任务的基础上，新增任务 i，由此来计算 mask 需要的 session 数
                # mask ^ (1 << i) + (1 << i) = mask
                if mask & (1 << i):
                    dp[mask] = min(dp[mask], add(dp[mask ^ (1 << i)], tasks[i]))
        
        return ceil(dp[-1] / sessionTime)

# s = Solution()
# tasks = [1,2,3]
# sessionTime = 3
# print(s.minSessions(tasks, sessionTime))
