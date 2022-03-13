# 0 <= n <= 100000
n = int(input())


nums = list(map(int, input().split()))

# 翻转区间值使得数组中 1 最多
# 就是说这个区间内的 cnt(0) - cnt(1) 的值达到最大

# 一次遍历，遍历过程中维护一个 cnt(0) - cnt(1) 的最小值
if n == 0:
    print(-1)
else:    
    minTarget = 0
    res = 0
    cnt0 = 0
    cnt1 = 0
    for i in range(n):
        if nums[i] == 0:
            cnt0 += 1
        else:
            cnt1 += 1
        ans = cnt0 - cnt1
        minTarget = min(minTarget, ans)
        res = max(res, ans - minTarget)
    print(cnt1+res)
