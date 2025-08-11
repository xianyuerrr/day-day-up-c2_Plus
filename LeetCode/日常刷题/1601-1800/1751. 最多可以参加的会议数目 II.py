from typing import List


class Solution:
    def maxValue(self, events: List[List[int]], k: int) -> int:
        n = len(events)
        events.sort(key=lambda x: x[1])
        # 前 i 个会议，参加 j 个的价值之和
        dp = [[0] * (k + 1) for _ in range(n+1)]
        # 初始化第一个会议价值
        dp[1][1] = events[0][2]
        # 遍历第 2 个到第 n 个会议
        for cur in range(2, n + 1):
            idx = cur - 1
            start_day = events[idx][0]
            # 寻找最后一个不冲突的会议下标
            l, r = 0, idx - 1
            while l < r:
                m = ((l + r) >> 1) + 1
                if events[m][1] >= start_day:
                    r = m - 1
                else:
                    l = m
            # 若当前下标会议冲突，则说明没有不冲突的会议，r 只会为 0，否则转换为前 r 个会议
            r += events[r][1] < start_day
            # 不参加会议的价值一定为 0；参加会议数量不可能大于当前遍历到的会议数，而且必须小于限制 k
            for cnt in range(1, min(cur, k) + 1):
                dp[cur][cnt] = max(dp[cur-1][cnt], (dp[r][cnt-1] + events[idx][2]))
        return max(dp[n])