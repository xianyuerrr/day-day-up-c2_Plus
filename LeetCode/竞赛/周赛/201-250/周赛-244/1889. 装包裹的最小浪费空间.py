class Solution:
    def minWastedSpace(self, packages: List[int], boxes: List[List[int]]) -> int:
        MOD = 10**9 + 7
        
        packages.sort()
        # 计算数组 packages 的前缀和
        pre = list(accumulate(packages, initial=0))

        # 辅助函数，通过前缀和数组，得到数组 packages[left..right] 的和
        get = lambda left, right: pre[right + 1] - pre[left]
        
        ans = float("inf")
        for box in boxes:
            box.sort()
            # 小优化，如果最大包裹的尺寸大于最大箱子的尺寸，那么一定不满足，直接跳过
            if packages[-1] > box[-1]:
                continue

            # 初始化指针 pt，它指向还未被放入箱子的第一个包裹
            pt = 0
            # 总浪费空间
            total = 0

            for y in box:
                # 小优化，如果当前箱子 y 的尺寸小于 pt 指向的包裹，那么无需进行二分查找
                if y < packages[pt]:
                    continue
                
                # pt'
                pt_next = bisect_right(packages, y, pt) - 1
                
                total += (pt_next - pt + 1) * y - get(pt, pt_next)
                pt = pt_next + 1
                # 小优化，如果所有包裹都已经被放入箱子，可以提前退出
                if pt == len(packages):
                    break
            
            ans = min(ans, total)

        return -1 if ans == float("inf") else ans % MOD
