class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;
        int minPrice = prices[0];
        
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            res = Math.max(res, prices[i] - minPrice);
        }
        return res;
    }
}