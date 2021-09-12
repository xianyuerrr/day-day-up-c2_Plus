class Solution:
    def firstDayBeenInAllRooms(self, nextVisit: List[int]) -> int:
        mod = 1000000007
        day = 0
        n = cnt = len(nextVisit)

        # 0 <= nextVisit[i] <= i
        # 所以只可能通过 访问次数为偶数的操作，才能访问到后面的房间
        # 而且 首次 到达 i 时，其前面的房间访问次数都只能为偶数

        pre = nextVisit.copy()
        pre[0] = 1
        pre_sum = pre.copy()

        for i in range(1, n):
            if i == nextVisit[i]:
                pre[i] = 1
            else:
                pre[i] = 1+pre[nextVisit[i]]+1
                pre[i] += pre_sum[i-1] - pre_sum[nextVisit[i]] + i-1-nextVisit[i]
                # for j in range(nextVisit[i]+1, i):
                #     pre[i] += pre[j] + 1
                pre[i] = pre[i] % mod
            pre_sum[i] = (pre_sum[i-1] + pre[i]) % mod

        i = 0
        while cnt:
            day += 1
            cnt -= 1
            if cnt == 0:
                break
            day = (day + pre[i]) % mod
            i = (i+1) % n
        return (day-1) % mod
# [0,0,0,0,0,0,0,0,0,9,1,8]
# 2048

# [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]