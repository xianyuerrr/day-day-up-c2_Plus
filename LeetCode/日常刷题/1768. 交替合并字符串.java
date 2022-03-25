class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        StringBuilder res = new StringBuilder();
        int i=0, j=0;
        while (i < m && j < n) {
            res.append(word1.charAt(i++));
            res.append(word2.charAt(j++));
        }
        if (i < m) res.append(word1.substring(i, m));
        else res.append(word2.substring(j, n));

        return res.toString();
    }
}