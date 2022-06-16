import java.util.Random;

class Solution {
    int n;
    int [][] rects;
    int [] preSum;
    Random random;

    public Solution(int[][] rects) {
        this.rects = rects;
        random = new Random();
        n = rects.length;
        int [] lis = new int [n];
        preSum = new int [n];
        int a, b, c, d;
        for (int i = 0; i < n; i++) {
            a = rects[i][0]; b = rects[i][1];
            c = rects[i][2]; d = rects[i][3];
            lis[i] = (c - a + 1) * (d - b + 1);
            preSum[i] = (i > 0 ? preSum[i-1] : 0) + lis[i];
        }
    }
    
    private int binarySearchRight(int []nums, int l, int r, int target) {
        int m;
        while (l < r) {
            m = l + (r-l >> 1);
            if (nums[m] < target) l = m+1;
            else r = m;
        }
        return l;
    }

    public int[] pick() {
        int v = random.nextInt(preSum[n-1] + 1);
        int idx = binarySearchRight(preSum, 0, n-1, v);

        int a, b, c, d;
        a = rects[idx][0]; b = rects[idx][1];
        c = rects[idx][2]; d = rects[idx][3];
        int x, y;
        x = random.nextInt(c-a+1);
        y = random.nextInt(d-b+1);
        return new int [] {a + x, b + y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */