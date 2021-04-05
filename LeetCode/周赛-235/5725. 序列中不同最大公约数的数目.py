from functools import lru_cache
class Solution:
    @lru_cache
    def gcd(self, x, y):
        if y % x == 0:
            return x
        return gcd(y%x, x)
    def countDifferentSubsequenceGCDs(self, nums: List[int]) -> int:
        res_set = set()
        for i in nums:
            res_set.add(i)
        queue1 = res_set.copy()
        queue2 = queue1.copy()
        while(queue2):
            new_queue2 = set()
            lis1 = list(queue1)
            lis2 = list(queue2)
            for i in range(len(lis1)):
                if lis1[i] == 1:
                    continue
                for j in range(i+1, len(lis2)):
                    x = lis1[i]
                    y = lis2[j]
                    # print(lis1, '-', lis2)
                    # print(x, y)
                    # print('-' * 20)
                    if y == 1 or y == x:
                        continue
                    if x > y:
                        x, y = y, x
                    g = self.gcd(x, y)
                    # print('g: ', g)
                    if g not in res_set:
                        res_set.add(g)
                        new_queue2.add(g)
            queue2 = new_queue2
        # print(res_set)
        return len(res_set)