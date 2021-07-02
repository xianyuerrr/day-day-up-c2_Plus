class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
        n = len(triplets)
        lis = [False, False, False]
        for i in range(n):
            if triplets[i][0] == target[0] and triplets[i][1] <= target[1] and triplets[i][2] <= target[2]:
                lis[0] = True
            if triplets[i][1] == target[1] and triplets[i][0] <= target[0] and triplets[i][2] <= target[2]:
                lis[1] = True
            if triplets[i][2] == target[2] and triplets[i][0] <= target[0] and triplets[i][1] <= target[1]:
                lis[2] = True
        return lis[0] and lis[1] and lis[2]