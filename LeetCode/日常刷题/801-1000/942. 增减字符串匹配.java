class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        // 1 <= n <= 10**5
        int [] res = new int [n+1];
        int l = 0, r = n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') res[i] = l++;
            else res[i] = r--;
        }
        res[n] = l;
        return res;
    }
}