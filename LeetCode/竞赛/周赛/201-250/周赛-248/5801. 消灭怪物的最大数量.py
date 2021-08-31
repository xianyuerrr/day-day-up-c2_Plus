class Solution:
    def test(self, dist, speed, time):
        n = len(dist)
        count = 0
        for i in range(n):
            if dist[i] - speed[i] * time <= 0:
                count += 1
        if count > time:
            return False
        return True

    def eliminateMaximum(self, dist: List[int], speed: List[int]) -> int:
        n = len(dist)

        time = [0 for _ in range(n)]

        for i in range(n):
            idx = ceil(dist[i] / speed[i])
            if idx < n:
                time[idx] += 1

        # print(time)
        if time[0] > 0:
            return 0
            
        for i in range(1, n):
            time[i] += time[i-1]
            if time[i] > i:
                return i
        return n
        # for i in range(n):
        #     if not self.test(dist, speed, i):
        #         return i
        # return n

