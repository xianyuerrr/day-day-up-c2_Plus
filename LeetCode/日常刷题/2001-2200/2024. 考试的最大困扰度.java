class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        // 滑动窗口
        int n = answerKey.length();
        int res = 0;
        int l = 0, r = 0;
        int cntT = 0, cntF = 0;
        while (r < n) {
            while (r <= n && (cntT <= k || cntF <= k)) {
                res = Math.max(res, r-l);
                if (r == n) break;
                if (answerKey.charAt(r) == 'T') cntT++;
                else cntF++;
                r++;
            }
            while(l < r && cntT > k && cntF > k) {
                if (answerKey.charAt(l) == 'T') cntT--;
                else cntF--;
                l++;
            }
            // System.out.println(l + ", " + r + ", cntT: " + cntT + ", cntF: " + cntF);
        }
        return res;
    }
}