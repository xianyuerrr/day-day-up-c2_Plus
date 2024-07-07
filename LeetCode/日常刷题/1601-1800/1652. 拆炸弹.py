class Solution:
    def decrypt(self, code: List[int], k: int) -> List[int]:
        # 前缀和+双倍空间简化；也可使用滑动窗口
        n = len(code)
        if k == 0:
            return [0] * n
        pre_sum = 2 * n * [0]
        for i in range(2 * n):
            pre_sum[i] = (pre_sum[i-1] if i >= 1 else 0) + code[i%n]

        res = [0] * n
        for i in range(n):
            if k > 0:
                res[i] = pre_sum[i+k] - pre_sum[i+1-1]
            elif k < 0:
                res[i] = pre_sum[i-1+n] - pre_sum[i+k+n-1]
        return res
    