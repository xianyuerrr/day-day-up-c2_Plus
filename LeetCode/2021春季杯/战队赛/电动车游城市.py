class Solution:
    def electricCarPlan(self, paths: List[List[int]], cnt: int, start: int, end: int, charge: List[int]) -> int:
        mat = collections.defaultdict(dict)
        res = 0
        for city_a, city_b, dis in paths:
            mat[city_a][city_b] = dis
            mat[city_b][city_a] = dis

        pq = [(0, start)]
        visited = set()
        dis = [101 for _ in range(len(charge))]
        while pq:
            dis, city1 = pq.pop()
            if city1 in visited:
                continue
            visited.add(city1)
            for city2 in mat[city1]:
                if charge[city2] > cnt:
                    continue
                if dis[city1] + (1 + min(charge[city1], charge[city2])) * mat[city1][city2] < dis[city2]:
                    dis[city2] = dis[city1] + (1 + min(charge[city1], charge[city2])) * mat[city1][city2]
                    heappush((dis[city2], city2))
        return charge[end]
