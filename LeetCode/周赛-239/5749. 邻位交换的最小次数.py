class Solution:
    def getMinSwaps(self, num: str, k: int) -> int:
        num_lis = list(num)
        n = len(num)
        while k > 0:
            k -= 1
            for i in range(n-2, -1, -1):
                if num_lis[i] < num_lis[i+1]:
                    for j in range(n-1, i, -1):
                        if num_lis[j] > num_lis[i]:
                            num_lis[j], num_lis[i] = num_lis[i], num_lis[j]
                            num_lis[i+1:] = sorted(num_lis[i+1:])
                            break
                    break
        num_start = list(num)
        res = 0
        for i in range(n):
            if num_lis[i] == num_start[i]:
                continue
            for j in range(i+1, n):
                if num_start[j] == num_lis[i]:
                    res += j-i
                    while j > i:
                        num_start[j], num_start[j-1] = num_start[j-1], num_start[j]
                        j -= 1
                    break
        return res