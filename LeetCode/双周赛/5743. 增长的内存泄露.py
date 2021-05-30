class Solution:
    def memLeak(self, memory1: int, memory2: int) -> List[int]:
        p = []
        heappush(p, [-memory1, 1])
        heappush(p, [-memory2, 2])
        t = 1
        while True:
            memory, idx = heappop(p)
            if memory + t > 0:
                heappush(p, [memory, idx])
                break
            heappush(p, [memory+t, idx])
            t += 1
        res = [t, 0, 0]
        memory, idx = heappop(p)
        res[idx] = -memory
        memory, idx = heappop(p)
        res[idx] = -memory
        return res