class Solution:
    def findFarmland(self, land: List[List[int]]) -> List[List[int]]:
        res = []
        if not land:
            return res
        m, n = len(land), len(land[0])
        for i in range(m):
            for j in range(n):
                if land[i][j] == 0:
                    continue

                ii = i
                jj = j
                while ii+1 < m and land[ii+1][j] == 1:
                    ii += 1
                land[i][j] = 1
                while jj+1 < n and land[i][jj+1] == 1:
                    jj += 1
                for x in range(i, ii+1):
                    for y in range(j, jj+1):
                        land[x][y] = 0
                res.append([i, j, ii, jj])
        return res
