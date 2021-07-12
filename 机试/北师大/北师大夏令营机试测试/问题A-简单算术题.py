from functools import lru_cache
@lru_cache()
def dfs(n, m):
    if n == 1:
        return [0, 1] if m == 1 else [1, 0]
    if m % 2 == 1:
        return dfs(n-1, (m+1)//2)
    else:
        f1 = dfs(n, m-1)
        f2 = dfs(n, m+1)
        return [f1[0]+f2[0], f1[1]+f2[1]]
row = int(input())
while row > 0:
    row -= 1
    n, m = list(map(int, input().split()))
    ret = dfs(n+1, m+1)
    print(str(ret[0]) + '/' + str(ret[1]))