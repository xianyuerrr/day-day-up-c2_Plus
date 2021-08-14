from pprint import pprint
class Solution:
    def rotateTheBox(self, box: List[List[str]]) -> List[List[str]]:
        m = len(box)
        n = len(box[0])
        res = [[None for _ in range(m)] for __ in range(n)]
        lis = [[n-1] for i in range(m)]
        n_lis = [0 for i in range(m)]
        for i in range(n):
            for j in range(m):
                res[i][j] = box[m-1 - j][i]
                if res[i][j] == '#':
                    n_lis[j] += 1
                    res[i][j] = '.'
                elif res[i][j] == '*':
                    for ii in range(i-1, i-1-n_lis[j], -1):
                        res[ii][j] = '#'
                    n_lis[j] = 0
        # print(n_lis)
        for j in range(m):
            for ii in range(n-1, n-1-n_lis[j], -1):
                    res[ii][j] = '#'
                    n_lis[j] = 0
        return res
