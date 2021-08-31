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
        # tasks.sort()
        n = len(tasks)
        time = 1000
        res = n
        while time:
            time -= 1
            random.shuffle(tasks)
            count = self.work(tasks, sessionTime)
            res = min(res, count)
        return res
