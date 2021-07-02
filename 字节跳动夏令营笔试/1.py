from functools import lru_cache
n = int(input())
nums = [-1] + list(map(int, input().split()))
# print(nums)
@lru_cache()
def dfs(idx, flag):
    if idx > n:
        return 0
    if flag == 1:
        # print(nums[idx])
        return nums[idx] + dfs(idx*2, 0) + dfs(idx*2+1, 0)
    else:
        a = dfs(idx*2, 0)
        b = dfs(idx*2, 1)
        c = dfs(idx*2+1, 0)
        d = dfs(idx*2+1, 1)
        return max(a+c, a+d, b+c, b+d)
        
    
print(max(dfs(1, 1), dfs(1, 0)))