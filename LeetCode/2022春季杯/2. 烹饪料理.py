class Solution:
    def perfectMenu(self, materials: List[int], cookbooks: List[List[int]], attribute: List[List[int]], limit: int) -> int:
        n = len(materials)
        res = -1
        # 爆搜，也可以使用状压
        def dfs(idx, ssum):
            nonlocal res, limit
            if idx == len(cookbooks):
                if limit <= 0:
                    res = max(res, ssum)
                return
            dfs(idx+1, ssum)

            flag = True
            for i in range(n):
                if materials[i] < cookbooks[idx][i]:
                    flag = False
                    break
            if flag:
                for i in range(n):
                    materials[i] -= cookbooks[idx][i]
                limit -= attribute[idx][1]
                ssum += attribute[idx][0]
                dfs(idx+1, ssum)
                for i in range(n):
                    materials[i] += cookbooks[idx][i]
                limit += attribute[idx][1]
                ssum -= attribute[idx][0]
        
        
        dfs(0, 0)
        return res
