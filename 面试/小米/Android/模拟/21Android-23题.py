class Solution:
    def maxarea(self, n, array):
        # 状压
        res = 0
        ssum = sum(array)
        mid = ssum / 2
        best_hei = 0
        for i in range(pow(2, n-1)):
            hei = 0
            for j in range(n):
                if i & (1 << j):
                    hei += array[j]
            if abs(best_hei - mid) > abs(hei-mid):
                best_hei = hei
                if best_hei == mid:
                    break
        return best_hei * (ssum - best_hei)
    
    def maxarea(self, n, array):
        # DP
        ssum = sum(array)
        target = (ssum+1) // 2
        


        


s = Solution()
n = 3
array = [3,4,5]
print(s.maxarea(n, array))