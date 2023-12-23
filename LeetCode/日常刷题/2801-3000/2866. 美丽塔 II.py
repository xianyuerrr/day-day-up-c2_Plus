from typing import List


class Solution:
    def maximumSumOfHeights(self, maxHeights: List[int]) -> int:
        """单调栈加速，O(n)

        Args:
            maxHeights (List[int]): _description_

        Returns:
            int: _description_
        """        
        n = len(maxHeights)
        # 存储从左往右前i个最大和
        prefix = [0 for i in range(n)]
        # 存储从右往左前i个最大和
        suffix = [0 for i in range(n)]
        
        stackLeft = [-1]
        stackRight = [n]

        for i in range(n):
            while (stackLeft[-1] != -1 and maxHeights[stackLeft[-1]] > maxHeights[i]):
                stackLeft.pop()
            j = stackLeft[-1]
            prefix[i] = (0 if j < 0 else prefix[j]) + (i-j) * maxHeights[i]
            stackLeft.append(i)

            while (stackRight[-1] != n and maxHeights[stackRight[-1]] > maxHeights[n-1-i]):
                stackRight.pop()
            j = stackRight[-1]
            suffix[n-1-i] = (0 if j > (n-1) else suffix[j]) + (j+i+1-n) * maxHeights[n-1-i]
            stackRight.append(n-1-i)

        res = 0
        for top in range(n):
            res = max(res, -maxHeights[top] + (prefix[top] if (top >= 0) else 0) + (suffix[top] if (top <= n-1) else 0))
        return res
    
    def method1(self, maxHeights: List[int]) -> int:
        """朴素解，O(n^2)

        Args:
            maxHeights (List[int]): _description_

        Returns:
            int: _description_
        """        
        n = len(maxHeights)
        prefix = [0]

        res = 0
        for top in range(n):
            sum = maxHeights[top]
            pointer = maxHeights[top]
            for left in range(top-1, -1, -1):
                pointer = min(maxHeights[left], pointer)
                sum += pointer
            pointer = maxHeights[top]
            for right in range(top+1, n):
                pointer = min(maxHeights[right], pointer)
                sum += pointer
            res = max(res, sum)
        return res