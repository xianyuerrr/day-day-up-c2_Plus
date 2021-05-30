class Solution:
    def check_cirle(self, target, mat, n):

        def dfs(j, target):
            for i in range(n):
                if mat[i][j]:
                    if i == target or dfs(i, target):
                        return True
            return False
        return dfs(target, target)

    def get_res(self, j, mat, colors, n):
        ans = [0 for _ in range(26)]
        res = 0
        
        def dfs(j):
            nonlocal ans, res
            ans[ord(colors[j])-ord('a')] += 1
            flag = True
            for i in range(n):
                if mat[i][j]:
                    dfs(i)
                    flag = False
            if flag:
                # print(1)
                res = max(res, max(ans))
            ans[ord(colors[j])-ord('a')] -= 1
            return
        dfs(j)
        return res

    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
        n = len(colors)
        mat = [[0 for _ in range(n)] for __ in range(n)]
        can_get = set()
        for i, j in edges:
            # 到达点 出发点
            mat[j][i] = 1
            can_get.add(j)
        # for i in range(n):
        #     print(mat[i])
        res = 0
        for i in range(n):
            if i not in can_get:
                res = self.get_res(i, mat, colors, n)
            else:
                if self.check_cirle(i, mat, n):
                    return -1
        return res
        
        