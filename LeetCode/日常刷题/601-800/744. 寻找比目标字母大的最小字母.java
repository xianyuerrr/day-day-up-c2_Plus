class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0, r = n-1;
        int m;
        while (l < r) {
            m = l + (r-l>>1);
            if (letters[m] <= target) l = m+1;
            else r = m;
        }
        return l == n-1 && letters[l] <= target ? letters[0] : letters[l];
    }
}