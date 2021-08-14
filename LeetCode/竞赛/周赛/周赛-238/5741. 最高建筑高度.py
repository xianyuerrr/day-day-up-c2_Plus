class Solution:
    def maxBuilding(self, n: int, rst: List[List[int]]) -> int:
        rst.append([1, 0])
        rst.sort()
        if rst[-1][0] == n:
            rst[-1][1] = min(rst[-1][1], n-1)
        else:
            rst.append([n, n-1])
        
        # 要求只会更加严格
        for i in range(1, n):
            rst[i][1] = min(rst[i][1], rst[i-1][1] + abs(rst[i-1][0]-rst[i][0]))

        for i in range(n-1, 0, -1):
            rst[i-1][1] = min(rst[i-1][1], rst[i][1] + abs(rst[i][0]-rst[i-1][0]))
    
        # for i in range(len(rst)):
        #     for j in range(i+1, len(rst)):
                # rst[j][1] = min(rst[j][1], rst[i][1] + abs(rst[i][0]-rst[j][0]))
        #         rst[i][1] = min(rst[i][1], rst[j][1] + abs(rst[i][0]-rst[j][0]))

        res = 0
        for i in range(1, len(rst)):
            res = max(res, (rst[i-1][1] + rst[i][1] + rst[i][0] - rst[i-1][0]) // 2)
        return res