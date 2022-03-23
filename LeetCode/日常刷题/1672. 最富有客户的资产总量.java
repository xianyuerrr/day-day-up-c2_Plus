class Solution {
    public int maximumWealth(int[][] accounts) {
        int res=0;
        int ans;
        for(int [] account : accounts) {
            ans = 0;
            for (int money : account) {
                ans += money;
            }
            res = Math.max(res, ans);
        }
        return res;
    }
}