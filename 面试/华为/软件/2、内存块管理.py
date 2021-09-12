def func():
    # 规格种类
    n = int(input())
    cnt = [0] * n
    typ = [0] * n
    i = 0
    while i < n:
        cnt[i], typ[i] = list(map(int, input().split()))
        i += 1
    m = int(input())
    lis = list(map(int, input().split()))
    
    ssum = 0
    for i in range(n):
        ssum += cnt[i] * typ[i]
    
    have = [0] * n
    res = -1
    # 爆搜
    def dfs(i, ans):
        nonlocal res
        if i == m:
            res = max(res, ans)
            return
        for t in range(n):
            if typ[t] < lis[i]:
                continue
            if have[t] >= lis[i]:
                have[t] -= lis[i]
                dfs(i+1, ans)
                have[t] += lis[i]
            else:
                if cnt[t] == 0:
                    continue
                else:
                    # 保护现场
                    leave = have[t]
                    
                    cnt[t] -= 1
                    have[t] = typ[t] - lis[i]
                    dfs(i+1, ans - typ[t])
                    have[t] = leave
                    cnt[t] += 1
    dfs(0, ssum)
    print(res)
    return

func()