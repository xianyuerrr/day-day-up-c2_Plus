class Solution:
    def maxHappyGroups(self, batchSize: int, groups: List[int]) -> int:
        res = 0
        n = len(groups)
        new_groups1 = []
        new_groups2 = []
        for i in range(n):
            if groups[i] % 4 == 0:
                res += groups[i]
            else:
                if groups[i] % 2 == 0:
                    new_groups1.append(groups[i])
                else:
                    new_groups2.append(groups[i])
        new_groups1.sort(reverse=True)
        new_groups2.sort(reverse=True)
        new_g_len1 = len(new_groups1)
        new_g_len2 = len(new_groups2)
        for i in range(new_g_len1 // 2):
            res += new_groups1[i]
        dic = collections.defaultdict(list)
        for i in new_groups2:
            dic[i%4].append(i)
        for i in 

