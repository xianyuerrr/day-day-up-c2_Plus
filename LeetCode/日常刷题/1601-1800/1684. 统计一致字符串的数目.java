class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        boolean[] has = new boolean[26];
        for (int i = 0; i < allowed.length(); i++) {
            has[allowed.charAt(i) - 'a'] = true;
        }
        for (String word : words) {
            label: {
                for (int i = 0; i < word.length(); i++) {
                    if (!has[word.charAt(i) - 'a']) {
                        break label;
                    }
                }
                res++;
            }
        }
        return res;
    }
}