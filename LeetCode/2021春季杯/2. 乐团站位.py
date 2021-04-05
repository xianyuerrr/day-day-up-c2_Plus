class Solution:
    def orchestraLayout(self, num: int, xPos: int, yPos: int) -> int:
        n = num
        x = xPos+1
        y = yPos+1
        min_dis = min([x-1, n-x, y-1, n-y])
        # print(min_dis)
        ssum = 1
        ans = n
        # for i in range(min_dis):
        #     ssum += 4*ans-4
        #     ans -= 2
        ans = n - 2*min_dis
        ssum += 4 * (min_dis * (n + ans) // 2)
        
        # print(ans, min_dis, ssum)
        if ans != 1:
            if x == min_dis+1:
                ssum += y - (min_dis + 1)
            elif y == ans+min_dis:
                ssum += ans-1 + x - (min_dis+1)
            elif x == ans+min_dis:
                ssum += 2*ans -2 + (ans + min_dis - y)
            elif y == min_dis + 1:
                ssum += 3 * ans - 3 + (ans + min_dis - x)

        # print(ssum)
        res = int(ssum % 9)
        return res if res != 0 else 9