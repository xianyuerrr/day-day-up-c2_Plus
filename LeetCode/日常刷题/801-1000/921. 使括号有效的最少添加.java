class Solution {
    public int minAddToMakeValid(String s) {
        int res = 0;
        int cnt = 0;s
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else {
                if (cnt > 0) cnt--;
                else res++;
            }
        }
        return res + cnt;
    }
}