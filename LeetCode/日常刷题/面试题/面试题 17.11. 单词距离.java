class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int first = -1, second = -1;
        boolean flag;
        for (int i = 0; i < words.length; i++) {
            flag = true;
            if (words[i].equals(word1)) first = i;
            else if (words[i].equals(word2)) second = i;
            else flag = false;
            if (flag && first != -1 && second != -1) res = Math.min(res, Math.abs(first - second));
        }

        return res;
    }
}