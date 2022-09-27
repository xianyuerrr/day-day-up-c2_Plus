class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        int[] cnt = new int[200];
        for (int i = 0; i < s1.length(); i++) {
            cnt[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            cnt[s2.charAt(i)]--;
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }
}