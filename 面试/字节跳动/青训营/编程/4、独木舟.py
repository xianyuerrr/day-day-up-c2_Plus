def func():
    # 准备要用到的变量
    w = int(input())
    n = int(input())
    m = [0] * n
    for i in range(n):
        m[i] = int(input())

    # 排序
    m.sort()
    if m[-1] > w:
        print(-1)
        return

    # 双指针
    res = 0
    l = 0
    r = n-1
    while l <= r:
        if l == r:
            res += 1
            l -= 1
            r += 1
            break
        res += 1
        if m[r] + m[l] <= w:
            l += 1
        r -= 1

    print(res)

func()