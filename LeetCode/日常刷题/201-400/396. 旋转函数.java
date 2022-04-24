class Solution {
    public int maxRotateFunction(int[] nums) {
        // return method1(nums);
        return method2(nums);
    }

    public int method2(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int res = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += i * nums[i];
            sum += nums[i];
        }
        res = cur;
        // 反向遍历可以每次少计算一次 n-i
        for (int i = n-1; i > -1; i--) {
            cur += sum;
            cur -= n * nums[i];
            res = Math.max(res, cur);
        }
        return res;
    }

    public int method1(int[] nums) {
        int n = nums.length;
        int [] presum = new int [n+1];
        int res = 0;
        for (int i = 1; i < n+1; i++) {
            res += (i-1) * nums[i-1];
            presum[i] = presum[i-1] + nums[i-1];
        }
        int F [] = new int [n];
        F[0] = res;
        for (int i = 1; i < n; i++) {
            F[i] = F[i-1] - (n-1) * nums[n - i] + presum[n-i] - presum[0] + presum[n] - presum[n-i + 1];
            res = Math.max(res, F[i]);
        }
        return res;
    }
}