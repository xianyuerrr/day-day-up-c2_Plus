n, m = list(map(int, input().split()))

generator = list(map(int, input().split()))

# 在炸弹生成在当前位置之前跳出
# 距离下个生成炸弹的时间最久

res = 0
time = 1
now = 1
while time < m:
    while time < m and now != generator[time]:
        time += 1
    if time == m:
        break
    # 寻找最佳跳跃房间
    has = set(range(1, n+1))
    has.discard(now)
    while time < m and len(has) > 1:
        time += 1
        has.discard(generator[time-1])
    now = list(has)[0]
    res += 1
print(res)
