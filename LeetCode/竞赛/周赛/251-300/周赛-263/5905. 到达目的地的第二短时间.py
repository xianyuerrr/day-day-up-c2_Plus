from collections import defaultdict
class Solution:
    def secondMinimum(self, n: int, edges: List[List[int]], t: int, change: int) -> int:
        dic = defaultdict(list)
        for b, e in edges:
            dic[b].append(e)
            dic[e].append(b)
        # 选一步，往回走一步，再走回去
        # 或者去掉最短路的一条边，再求最短路
        pre = [-1] * n
        nxt = [-1] * n
        q = [1]
        newQ = []
        visited = {1}
        time = 0
        
        while True and q:
            if n in visited:
                break
            if time // change & 1:
                time += change - (time % change)
            for i in q:
                for nex in dic[i]:
                    if nex in visited:
                        continue
                    pre[nex - 1] = i
                    nxt[i-1] = nex
                    visited.add(nex)
                    newQ.append(nex)
            q.clear()
            q, newQ = newQ, q
            time += t
        
        # 最快的时间
        fastestTime = time
        print(1)
        res = float('inf')
        b = n
        while b != 1:
            l, r = b, pre[b-1]
            dic[l].remove(r)
            dic[r].remove(l)
        
            q = [1]
            newQ = []
            visited = {1}
            time = 0
            while True and q:
                if n in visited:
                    break
                if time // change & 1:
                    time += change - (time % change)
                for i in q:
                    for nex in dic[i]:
                        if nex in visited:
                            continue
                        visited.add(nex)
                        newQ.append(nex)
                q.clear()
                q, newQ = newQ, q
                time += t
            # 若不可达，返回 极大
            if not (n in visited):
                time = float('inf')
            res = min(res, time)
            dic[l].append(r)
            dic[r].append(l)
            b = pre[b-1]

        # 若去掉最短路的任意一边之后就不可达，若是则需要走 1 -> n -> 1 -> n
        if res == float('inf'):
            time = fastestTime
            b = n
            while b != 1:
                if time // change & 1:
                    time += change - (time % change)
                time += t
                b = pre[b-1]

            while b != n:
                if time // change & 1:
                    time += change - (time % change)
                time += t
                b = nxt[b-1]
            res = time
        return res

