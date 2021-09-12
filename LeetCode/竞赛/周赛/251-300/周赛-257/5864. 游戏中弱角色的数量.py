class Solution:
    def numberOfWeakCharacters(self, properties: List[List[int]]) -> int:
        res = 0
        n = len(properties)
        properties.sort()

        lis = [properties[-1]]
        for i in range(n-2, -1, -1):
            if properties[i][0] == lis[-1][0]:
                if len(lis) == 1:
                    continue
                if properties[i][1] < lis[-2][1]:
                    res += 1
            else:
                if properties[i][1] < lis[-1][1]:
                    res += 1
                if properties[i][1] > lis[-1][1]:
                    lis.append(properties[i])
                
        return res