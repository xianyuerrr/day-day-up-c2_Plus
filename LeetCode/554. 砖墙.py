class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        n = len(wall)
        res = n
        dic = defaultdict(int)
        for i in range(n):
            pre_sum = 0
            for j in range(0, len(wall[i])-1):
                pre_sum += wall[i][j]
                dic[pre_sum] += 1
        
        return res - max(dic.values()) if dic else res