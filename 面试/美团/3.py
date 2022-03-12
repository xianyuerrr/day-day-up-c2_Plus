res = 0
n, m = list(map(int, input().split()))
orderLis = []

for i in range(n):
    orderLis.append(list(map(int, input().split())))

res = 0
# 状压
for i in range(pow(2, n)):
    canUse = [True] * m
    ans = 0
    for j in range(n):
        if i >> j & 1:
            a, b = orderLis[j]
            if not (canUse[a-1] and canUse[b-1]):
                break
            canUse[a-1] = False
            canUse[b-1] = False
            ans += 1
    else:
        res = max(res, ans)
print(res)