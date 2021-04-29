class Solution:
    def canCross(self, stones: List[int]) -> bool:
        n = len(stones)
        # dp = [[False for __ in range(n+1)] for _ in range(n)]
        # 由于 k 是稀疏的，所以可以使用 dict 存储
        dp = [defaultdict(bool) for _ in range(n)]
        # row: 石头编号
        # col: 上一步跳了 k 的距离跳到当前石头
        dp[0][0] = True
        for i in range(1, n):
            # 位于 i 的是 第 i+1 块石头，在此位置最多能跳 i+1 的距离
            # 在其之前的石块上，最多能跳 i 的距离
            # 如果在离 i 位置石块最近的 i-1 位置石块都需要跳超过 i 的距离才能到达 i 位置的石块
            # 那么青蛙就不可能跳到 i 位置的石块上
            if stones[i] - stones[i-1] > i:
                break
            # 枚举我们是从哪里跳过来的
            for pre in range(i-1, -1, -1):
                k = stones[i] - stones[pre]
                # 位于 pre 的是 第 pre+1 块石头，在此位置最多能跳 pre+1 的距离
                # 如果我们在 pre 需要跳 k 的距离，而我们最多能跳 pre+1
                # 那么当我们在 pre-1 时，我们需要跳 大于k 的距离，而我们能跳的最大距离反而减小了
                # 所以一旦出现 能跳的最大距离 < 需要跳的距离时，就没有必要再继续下去了
                if k > pre+1:
                    break
                if dp[pre][k-1] or dp[pre][k] or dp[pre][k+1]:
                    dp[i][k] = True

        return True in dp[-1].values()

        # 脑瘫了的DP
        # n = len(stones)
        # # 第 x 块石头，上一步跳了 k
        # dp = [[False for __ in range(n+1)] for _ in range(n)]
        # dp[0][0] = True
        # for i in range(n):
        #     left = 0
        #     right = i
        #     # 由于石头相对稀疏，所以 k 是稀疏的，枚举 k 反而将 k 和 上一块石头的位置 稠密化
        #     for k in range(1, min(i+1, stones[i]+1)):
        #         pre_val = stones[i]-k
        #         right = self.binary_search(stones, left, right, pre_val)

        #         if stones[right] != pre_val:
        #             continue
        #         if dp[right][k] or dp[right][k-1] or dp[right][k+1]:
        #             dp[i][k] = True

        # return 1 in dp[-1]
        
    # def binary_search(self, stones, l, r, target):
    #     while l < r:
    #         mid = l + (r - l >> 1)
    #         if stones[mid] == target:
    #             return mid
    #         elif stones[mid] > target:
    #             r = mid
    #         else:
    #             l = mid+1
    #     return l