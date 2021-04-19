from heapq import *
class Solution:
    def getOrder(self, tasks):
        res = []
        queue = []
        now = 0
        n = len(tasks)
        new_tasks = []
        for i in range(n):
            heappush(new_tasks, (tasks[i][0], i))

        while new_tasks and queue:
            if new_tasks:
                net = heappop(new_tasks)
                heappush(new_tasks, net)
                while net[0] <= now:
                    i = net[1]
                    cost = tasks[i][1]
                    heappush(queue, (cost, i))
                    if new_tasks:
                        net = heappop(new_tasks)
                    else:
                        break
            if queue:
                run = heappop(queue)
                now += run[0]
                res.append(run[1])
            if not queue and now < net[0]:
                now = net[0]
                
        return res

s = Solution()
s.getOrder([[1,2],[2,4],[3,2],[4,1]])