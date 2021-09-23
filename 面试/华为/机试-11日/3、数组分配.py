from collections import defaultdict

def myPrint(num, l):
    for i in range(l-1):
        print(num[i], end=' ')
    print(num[l-1])
    return

def func():
    s1 = list(map(int, input().split()))
    s2 = list(map(int, input().split()))
    m, n = len(s1), len(s2)
    dic1 = defaultdict(list)
    dic2 = defaultdict(list)
    for i in range(m):
        for j in range(i+1, m):
            diff = s1[j] - s1[i]
            if diff in dic1:
                continue
            subLis = [s1[i], s1[j]]
            for k in range(j+1, m):
                if s1[k] - subLis[-1] == diff:
                    subLis.append(s1[k])
            dic1[diff] = subLis

    for i in range(n):
        for j in range(i+1, n):
            diff = s2[j] - s2[i]
            if diff in dic2:
                continue
            subLis = [s2[i], s2[j]]
            for k in range(j+1, n):
                if s2[k] - subLis[-1] == diff:
                    subLis.append(s2[k])
            dic2[diff] = subLis

    res = 0
    subLis1 = []
    subLis2 = []

    for k, v in dic1.items():
        if k in dic2:
            sameLen = min(len(dic1[k]), len(dic2[k]))
            if res < sameLen:
                res = sameLen
                subLis1 = dic1[k]
                subLis2 = dic2[k]
    print(res)
    if res != 0:
        myPrint(subLis1, res)
        myPrint(subLis2, res)
    return

func()


# 有两个序列单调递增序列s1和s2，如果这两个序列，存在子序列对于 [公式]
# 则输出子序列长度和分别对应的子序列，如果有好几个这样的数列，就留下数相对较小的。
# 如果不存在则输出0.

# 例1：

# 1 2 3 4 5 
# 2 4 6 8
# 输出

# 3
# 1 3 5
# 2 4 6 