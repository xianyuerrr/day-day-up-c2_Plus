class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int res=0;
        int n = arr.length;
        // int [] preSum = new int[n+1];
        // for (int i = 1; i < n+1; i++) {
        //     preSum[i] = preSum[i-1] + arr[i-1];
        // }
        // for (int i = 0; i < n; i++) {
        //     for (int j = i; j < n; j++) {
        //         if ((j-i+1 & 1) == 1) res += preSum[j+1] - preSum[i];
        //     }
        // }
        for (int i = 0; i < n; i++) {
            int leftCount = i, rightCount = n - i - 1;
            int leftOdd = (leftCount + 1) / 2;
            int rightOdd = (rightCount + 1) / 2;
            int leftEven = leftCount / 2 + 1;
            int rightEven = rightCount / 2 + 1;
            res += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
        }
        return res;
    }
}