class Solution:
    def getXORSum(self, arr1, arr2) -> int:
        m = len(arr1)
        n = len(arr2)
        a = 0
        b = 0
        if m > n:
            m, n, arr1, arr2 = n, m, arr2, arr1
        # for i in range(m):
            # a ^= arr1[i]
        for j in range(n):
            b ^= arr2[j]
        res = 0
        for i in range(m):
            res ^= (arr1[i] & b)
        
        return res

# class Solution:
#     def getXORSum(self, arr1, arr2) -> int:
#         m = len(arr1)
#         n = len(arr2)
#         lis = []
#         for i in range(m):
#             for j in range(n):
#                 lis.append(arr1[i] & arr2[j])
#         res = 0
#         for i in lis:
#             res ^= i
#         return res
# s = Solution()
# s.getXORSum([1, 3, 15], [2, 4])
#         # res = 0
#         # if n % 2 == 1:
#         #     for i in arr1:
#         #         res ^= i
#         # if m % 2 == 1:
#         #     for i in arr2:
#         #         res ^= i
#         # return res
