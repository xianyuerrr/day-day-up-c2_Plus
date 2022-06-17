class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double res = 0;
        int n = brackets.length;
        int lastUpper = 0, upper, percent;
        for (int i = 0; i < n; i++) {
            upper = brackets[i][0]; percent = brackets[i][1];
            if (lastUpper >= income) break;
            res += (Math.min(income, upper) - lastUpper) * (percent / 100.0);
            lastUpper = upper;
        }
        return res;
    }
}