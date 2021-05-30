class Solution:
    def sumOfFlooredPairs(self, nums: List[int]) -> int:
        mod = pow(10, 9) + 7
        res = 0
        counter = Counter(nums)
        ks = sorted(list(counter.keys()))
        ks_len = len(ks)
        for i in range(ks_len):
            res += counter[ks[i]] * counter[ks[i]] % mod
            for j in range(i+1, ks_len):
                res += counter[ks[i]] * counter[ks[j]] * (ks[j] // ks[i]) % mod
        return res % mod