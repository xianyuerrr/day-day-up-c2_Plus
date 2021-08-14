class Solution:
    def xorOperation(self, n: int, start: int) -> int:
        # 数学
        def cal(x):
            """
                4a ^ (4a + 1) = 1
                4a ^ (4a + 1) ^ (4a + 2) = 1 ^ (4a + 2) = 4a + 3
                4a ^ (4a + 1) ^ (4a + 2) ^ (4a + 3) = (4a + 3) ^ (4a + 3) = 0
            """
            if x % 4 == 0:
                return x
            elif x % 4 == 1:
                return 1
            elif x % 4 == 2:
                return x + 1
            return 0
        
        # 整体除以2, 利用 %4 结论计算 ans 中除「最低一位」的结果
        s = start >> 1
        # 计算 1 到 s - 1的异或结果，再计算 1 到 s + n - 1的异或结果，两者异或得到ans中除最后一位的结果
        prefix = cal(s - 1) ^ cal(s + n - 1)
        # 利用「奇偶性」计算 ans 中的「最低一位」结果
        last = n & start & 1
        return prefix << 1 | last

        # # 模拟
        # res = 0
        # for i in range(n):
        #     res ^= start + 2 * i
        # return res