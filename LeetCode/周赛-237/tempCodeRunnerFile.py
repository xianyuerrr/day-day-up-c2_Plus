from heapq import *
class Solution:
    def getOrder(self, tasks):
        res = []
        queue = []
        now = 0
        n = len(tasks)
        time_sort = []
        for i in range(n):
            time_sort.append((tasks[i], i))
        time_sort.sort(reverse=True)

        while time_sort or queue:
            if time_sort:
                net = time_sort[-1]
                while net[0][0] <= now:
                    time_sort.pop()

                    i = net[1]
                    cost = net[0][1]
                    
                    heappush(queue, (cost, i))
                    if time_sort:
                        net = time_sort[-1]
                    else:
                        break
            if queue:
                run = heappop(queue)
                now += run[0]
                res.append(run[1])
            else:
                now = net[0][0]
        return res

s = Solution()
print(s.getOrder([[1,2],[2,4],[3,2],[4,1]]))