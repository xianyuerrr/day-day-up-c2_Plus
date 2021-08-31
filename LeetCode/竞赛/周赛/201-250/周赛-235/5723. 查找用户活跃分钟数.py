import collections
class Solution:
    def findingUsersActiveMinutes(self, logs: List[List[int]], k: int) -> List[int]:
        res = [0 for _ in range(k)]
        dic = collections.defaultdict(set)
        for Id, Time in logs:
            dic[Id].add(Time)
        for k, v in dic.items():
            res[len(v)-1] += 1
        return res