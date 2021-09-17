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

# 有不同容量的硬盘若干；
# 有不同大小的不可分文件；
# 尽可能使最后的剩余内存要多；
# 输入

# 3 # 3种不同硬盘
# 2 4 # 2张内存为4的硬盘
# 4 8 # 2张内存为6的硬盘
# 4 16  # 2张内存为16的硬盘
# 4 # 4个文件，这4个文件不能分开存储
# 9 7 11 4 # 4个文件对应的文件大小 
# 输出

# 64