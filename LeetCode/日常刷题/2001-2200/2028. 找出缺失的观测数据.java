class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int [] res;
        int sum = 0;
        for (int num : rolls) {
            sum += num;
        }
        int diff = mean * (m+n) - sum;
        if (diff > 6*n || diff < n) return new int[0];
        res = new int[n];
        int x = diff / n, y = diff % n;
        for (int i = 0; i < n; i++) {
            res[i] = x + (i < y ? 1 : 0);
        }
        return res;
    }
}