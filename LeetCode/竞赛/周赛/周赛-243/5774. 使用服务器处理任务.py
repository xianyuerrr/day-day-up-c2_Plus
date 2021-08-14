import heapq
class Solution:
    def assignTasks(self, servers: List[int], tasks: List[int]) -> List[int]:
        pq = []
        m = len(tasks)
        n = len(servers)
        ans = [None for _ in range(m)]
        for i in range(n):
            heapq.heappush(pq, [servers[i], i])
        pqing = []
        
        time = 0
        idx = 0
        while True:
            if idx == m:
                break
            if time < idx:
                time = idx
            if not pq:
                p = heapq.heappop(pqing)
                time = p[0]
                heapq.heappush(pq, p[1:])
            while pqing:
                p = heapq.heappop(pqing)
                if p[0] > time:
                    heapq.heappush(pqing, p)
                    break
                heapq.heappush(pq, p[1:])

            p = heapq.heappop(pq)
            heapq.heappush(pqing, [time+tasks[idx], p[0], p[1]])
            ans[idx] = p[1]
            idx += 1
        return ans