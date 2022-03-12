n = int(input())
nums = list(map(int, input().split()))
print(nums)
cnt1 = 1
cnt2 = 0

pre = [1] * n
res = 0

for i in range(n):
    pre[i] = (pre[i-1] if i-1 >= 0 else 1) * nums[i]
    if pre[i] > 0:
        res += cnt1
        cnt1 += 1
    else:
        res += cnt2
        cnt2 += 1
    # print(res, cnt1, cnt2)
print(pre)
print(res)