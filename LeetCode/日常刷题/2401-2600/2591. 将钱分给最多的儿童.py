class Solution:
    def distMoney(self, money: int, children: int) -> int:
        if money < children:
            return -1
        # 1. 8x + (children - x) + y = money
        # 7x + y = money - children
        # y = money - children - 7x
        x = min((money - children) // 7, children)
        y = money - children - 7 * x
        if x == children and y != 0:
            return x - 1
        if x == children - 1 and y == 3:
            return x - 1
        return x