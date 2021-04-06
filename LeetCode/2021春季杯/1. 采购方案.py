import math
import collections
class Solution:
    def purchasePlans(self, nums: List[int], target: int) -> int:
        # Python 太慢了，双指针还总是超时，只能用 set 再次降低运算量
        
        # 一共有 n 个数，定义为左右边界内共有多少个值
        n = len(nums)
        # 记录每个数的数量
        count = collections.Counter(nums)
        # 转化为 set，然后排序
        nums_set = list(set(nums))
        nums_set.sort()
        # 定义右指针，设定取值的右边界
        right = len(nums_set) - 1
        res = 0
        # 计算 相同元素 满足要求 的 两两配对数目，（组合数）
        for k, v in count.items():
            if v < 2:
                # 此值的数量小于2的话，就无法配队了
                continue
            if k+k <= target:
                res += math.factorial(v) / (math.factorial(2) * math.factorial(v-2))
        # 以 i 为左边界，单向寻找其另一半的左右边界
        for i in range(len(nums_set)):
            # 左边界右移，范围内值的数目减少
            n -= count[nums_set[i]]
            # 找到 i 的另一半的右边界
            while right > i and nums_set[i] + nums_set[right] > target:
                # print(nums_set[i], nums_set[right], target)
                n -= count[nums_set[right]]
                right -= 1
                if right == i:
                    break
            # 左右指针相遇，结束
            if right == i:
                    break
            res += n * count[nums_set[i]]
        return int(res) % (pow(10, 9) + 7)